package buoi5.bt;

public class Product {
    String id;
    String name;
    double price;
    int quantity;

    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = DataCleaner.formatName(name);
        this.price = price;
        this.quantity = quantity;
    }


}
