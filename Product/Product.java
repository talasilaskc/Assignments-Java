package Product;

public class Product {

    private double price;
    private String brand;
    private String category;
    private double rating;
    private double discount;
    private int id;
    private String name;

    public Product(int id, String name, double price, String brand, String category, double rating, double discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.category = category;
        this.rating = rating;
        this.discount = discount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", discount=" + discount +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
