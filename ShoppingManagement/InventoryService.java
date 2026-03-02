package ShoppingManagement;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class InventoryService {

    private static final String PRODUCT_FILE =
            "D:\\Java Notes\\Java_oops\\product_inventory.xlsx";

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void loadProducts() throws Exception {

        try (FileInputStream fis = new FileInputStream(PRODUCT_FILE)) {
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row r = sheet.getRow(i);

                products.add(new Product(
                        (int) r.getCell(0).getNumericCellValue(),
                        r.getCell(1).getStringCellValue(),
                        r.getCell(2).getStringCellValue(),
                        (int) r.getCell(3).getNumericCellValue(),
                        r.getCell(4).getNumericCellValue()
                ));
            }

            wb.close();
        }
    }

    public void displayProducts() {

        System.out.println("\nAvailable Products:");

        for (Product p : products) {
            System.out.println(
                    p.getId() + " | " +
                            p.getName() +
                            " | Stock: " +
                            p.getQuantity() +
                            " | Price: " +
                            p.getPrice());
        }
    }

    public Product findProduct(int id) {

        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void saveProducts() throws Exception {

        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Products");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Name");
        header.createCell(2).setCellValue("Description");
        header.createCell(3).setCellValue("Quantity");
        header.createCell(4).setCellValue("Price");

        int rowIndex = 1;

        for (Product p : products) {

            Row r = sheet.createRow(rowIndex++);

            r.createCell(0).setCellValue(p.getId());
            r.createCell(1).setCellValue(p.getName());
            r.createCell(2).setCellValue(p.getDescription());
            r.createCell(3).setCellValue(p.getQuantity());
            r.createCell(4).setCellValue(p.getPrice());
        }

        try (FileOutputStream fos = new FileOutputStream(PRODUCT_FILE)) {
            wb.write(fos);
        } finally {
            wb.close();
        }
    }
}
