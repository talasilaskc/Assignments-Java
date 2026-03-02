package ShoppingManagement;

public class Product {

    private int id;
    private String name;
    private String description;
    private int quantity;
    private double price;

    public Product(int id, String name,
                   String description,
                   int quantity,
                   double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
