package Collections;

public class Phone {
    private int id;
    private String brand;
    private String model;
    private double price;

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    private String releaseDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Phone(int id, String brand, String model, double price, String releaseDate) {
        this.id=id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public String setBrand(String brand) {
        this.brand = brand;
        return brand;
    }

    public String setModel(String model) {
        this.model = model;
        return model;
    }

    public double setPrice(double price) {
        this.price = price;
        return price;
    }

}
