package Product;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer,Product> products=new TreeMap<>();

        products.put(1, new Product(1,"Laptop", 999.99, "Dell", "Electronics", 4.5, 10));
        products.put(2, new Product(2,"Smartphone", 499.99, "Samsung", "Electronics", 4.7, 15));
        products.put(3, new Product(3,"Headphones", 199.99, "Sony", "Audio", 4.3, 20));
        products.put(5, new Product(4,"Smartwatch", 299.99, "Apple", "Wearables", 4.8, 5));
        products.put(4, new Product(5,"Camera", 799.99, "Canon", "Photography", 4.6, 12));

        ProductService productService = new ProductService();
        String result = productService.printTreeMap(products);
        System.out.println(result);

        //get entries
        ArrayList<Map.Entry<Integer, Product>> entries = new ArrayList<>(products.entrySet());
        System.out.println("Entries in the TreeMap:" + entries);

        ArrayList<Product> productList = new ArrayList<>(products.values());

        //sort by price ascending
        ArrayList<Product> sortedResult = productService.sortProductsByPrice(productList);
        LinkedHashMap<Integer, Product> sortedProductsByPrice = productService.convertToLinkedHashMap(sortedResult,products);
        System.out.println("Products sorted by price:\n" + productService.printTreeMap(sortedProductsByPrice));

        //sort by discount ascending
        ArrayList<Product> sortedByDiscount = productService.sortProductsByDiscount(productList);
        LinkedHashMap<Integer, Product> sortedProductsByDisc=productService.convertToLinkedHashMap(sortedByDiscount,products);
        System.out.println("Products sorted by discount:\n" + productService.printTreeMap(sortedProductsByDisc));

        //filter by name
        String name="Smartwatch";
        Map.Entry<Integer, Product> filteredProduct=productService.filterProductByName(products,name);
        if(filteredProduct!=null){
            System.out.println("Product found in "+filteredProduct.getKey()+" . Here are the details "+filteredProduct.getValue().toString());
        }
        else{
            System.out.println("Product not found.");
        }

        //filter by brand
        String brand="Xioami";
        Map.Entry<Integer, Product> filteredProductBrand= (Map.Entry<Integer,Product>) productService.filterProductByBrand(products,brand);
        if(filteredProductBrand!=null){
            System.out.println("Product found in "+filteredProductBrand.getKey()+" . Here are the details "+filteredProductBrand.getValue().toString());
        }
        else{
            System.out.println("Product not found.");
        }

        //filter by category
        String category="Audio";
        Map.Entry<Integer, Product> filteredProductCategory=productService.filterProductByCategory(products,brand);
        if(filteredProductCategory!=null){
            System.out.println("Product found in "+filteredProductCategory.getKey()+" . Here are the details "+filteredProductCategory.getValue().toString());
        }
        else{
            System.out.println("Product not found.");
        }

        //filter by min-max cost














    }
}
