package ShoppingManagement;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class PurchaseService {

    private static final String HISTORY_FILE =
            "D:\\Java Notes\\Java_oops\\purchase_history.xlsx";

    private Map<Product, Integer> cart =
            new LinkedHashMap<>();

    public void addToCart(Product p, int qty) {
        cart.put(p,
                cart.getOrDefault(p, 0) + qty);
    }

    public void checkout() {

        double total = 0;

        System.out.println("\nBill:");

        for (var entry : cart.entrySet()) {

            Product p = entry.getKey();
            int qty = entry.getValue();

            double cost = qty * p.getPrice();
            total += cost;

            p.setQuantity(
                    p.getQuantity() - qty);

            System.out.println(
                    p.getName() +
                            " x " + qty +
                            " = " + cost);
        }

        System.out.println("Total = " + total);
    }

    public void saveHistory() throws Exception {

        Workbook wb;
        Sheet sheet;

        File file = new File(HISTORY_FILE);

        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                wb = new XSSFWorkbook(fis);
            }
            sheet = wb.getSheetAt(0);
        } else {
            wb = new XSSFWorkbook();
            sheet = wb.createSheet("History");

            Row header = sheet.createRow(0);
            header.createCell(0)
                    .setCellValue("Product");
            header.createCell(1)
                    .setCellValue("Quantity");
            header.createCell(2)
                    .setCellValue("Total Price");
        }

        int rowIndex =
                sheet.getLastRowNum() + 1;

        for (var entry : cart.entrySet()) {

            Product p = entry.getKey();
            int qty = entry.getValue();

            Row r = sheet.createRow(rowIndex++);

            r.createCell(0)
                    .setCellValue(p.getName());
            r.createCell(1)
                    .setCellValue(qty);
            r.createCell(2)
                    .setCellValue(
                            p.getPrice() * qty);
        }

        try (FileOutputStream fos = new FileOutputStream(file)) {
            wb.write(fos);
        } finally {
            wb.close();
        }
    }
}
