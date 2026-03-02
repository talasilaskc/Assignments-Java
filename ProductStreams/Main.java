package ProductStreams;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductService service = new ProductService();

        Map<Integer, Product> productMap = new TreeMap<>();

        // Sample data
        productMap.put(1, new Product(1,"Laptop", 90000,"Dell","Electronics",4.5,10));
        productMap.put(2, new Product(2,"Phone",60000,"Samsung","Electronics",4.3,15));
        productMap.put(3, new Product(3,"Shoes",4000,"Nike","Fashion",4.0,20));
        productMap.put(4, new Product(4,"Watch",8000,"Titan","Accessories",4.1,5));
        productMap.put(5, new Product(5,"Tablet",30000,"Apple","Electronics",4.6,12));

        int choice;

        do {
            System.out.println("1. View All Products");
            System.out.println("2. Sort by Price");
            System.out.println("3. Sort by Price Desc");
            System.out.println("4. Sort by Discount");
            System.out.println("5. Sort by Discount Desc");
            System.out.println("6. Sort by Rating");
            System.out.println("7. Sort by Price then Discount");
            System.out.println("8. Sort by Price then Rating");
            System.out.println("9. Filter by Name");
            System.out.println("10. Filter by Brand");
            System.out.println("11. Filter by Category");
            System.out.println("12. Filter by Price Range");
            System.out.println("0. Exit");


            choice = sc.nextInt();
            sc.nextLine();

            Map<Integer, Product> result;

            switch (choice) {

                case 1:
                    System.out.println(service.printTreeMap(productMap));
                    break;

                case 2:
                    result = service.sortByPrice(productMap);
                    System.out.println(service.printTreeMap(result));
                    break;

                case 3:
                    result = service.sortByPriceDesc(productMap);
                    System.out.println(service.printTreeMap(result));
                    break;

                case 4:
                    result = service.sortByDiscount(productMap);
                    System.out.println(service.printTreeMap(result));
                    break;

                case 5:
                    result = service.sortByDiscountDesc(productMap);
                    System.out.println(service.printTreeMap(result));
                    break;

                case 6:
                    result = service.sortByRating(productMap);
                    System.out.println(service.printTreeMap(result));
                    break;

                case 7:
                    result = service.sortByPricethenDiscount(productMap);
                    System.out.println(service.printTreeMap(result));
                    break;

                case 8:
                    result = service.sortByPricethenRating(productMap);
                    System.out.println(service.printTreeMap(result));
                    break;

                case 9:
                    System.out.print("Enter product name: ");
                    String pname = sc.nextLine();
                    result = service.filterByName(productMap, pname);
                    System.out.println(service.printTreeMap(result));
                    break;

                case 10:
                    System.out.print("Enter brand: ");
                    String brand = sc.nextLine();
                    result = service.filterByBrand(productMap, brand);
                    System.out.println(service.printTreeMap(result));
                    break;

                case 11:
                    System.out.print("Enter category: ");
                    String cat = sc.nextLine();
                    result = service.filterByCategory(productMap, cat);
                    System.out.println(service.printTreeMap(result));
                    break;

                case 12:
                    System.out.print("Enter min price: ");
                    double min = sc.nextDouble();
                    System.out.print("Enter max price: ");
                    double max = sc.nextDouble();
                    result = service.filterByMinMaxAmt(productMap, min, max);
                    System.out.println(service.printTreeMap(result));
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }


        } while (choice != 0);

        sc.close();
    }
}
