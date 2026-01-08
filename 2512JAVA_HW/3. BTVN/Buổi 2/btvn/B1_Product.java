package buoi2.btvn;

public class B1_Product {

    String productName;
    double price;
    int quantity;

    public static void main(String[] args) {

        B1_Product p = new B1_Product();
        p.productName = "Macbook Air";
        p.price = 200000;
        p.quantity = 12;

        double discount;
        discount = p.quantity > 10 ? 0.1 : 0.05;

        double total = (p.price * p.quantity) * (1 - discount);

        System.out.println("Product: " + p.productName + " - Total price: " + total);
    }
}
