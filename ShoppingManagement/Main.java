package ShoppingManagement;


import java.util.Scanner;

public class Main {

    public static void main(String[] args)
            throws Exception {

        InventoryService inventory =
                new InventoryService();

        PurchaseService purchase =
                new PurchaseService();

        inventory.loadProducts();

        Scanner sc = new Scanner(System.in);

        while (true) {

            inventory.displayProducts();

            System.out.print(
                    "Enter ID (0 checkout): ");

            int id = sc.nextInt();

            if (id == 0)
                break;

            Product p =
                    inventory.findProduct(id);

            if (p == null) {
                System.out.println(
                        "Invalid product");
                continue;
            }

            System.out.print("Quantity: ");
            int qty = sc.nextInt();

            if (qty > p.getQuantity()) {
                System.out.println(
                        "Insufficient stock!");
                continue;
            }

            purchase.addToCart(p, qty);
        }

        purchase.checkout();
        inventory.saveProducts();
        purchase.saveHistory();

        System.out.println(
                "Purchase Completed!");
    }
}
