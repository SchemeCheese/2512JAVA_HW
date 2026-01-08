package buoi5.bt;

public class Main {

    public static void main(String[] args) {


        String rawName = "   nguyen   van   a   ";

        String cleanName = DataCleaner.formatName(rawName);

        // Tạo ID
        String id = DataCleaner.generateID(cleanName, 1);

        System.out.println("Tên ban đầu: [" + rawName + "]");
        System.out.println("Tên sau chuẩn hóa: " + cleanName);
        System.out.println("ID sinh ra: " + id);

        Product[] list = new Product[100];
        int n = 2;

        list[0] = new Product("A1", " tivi ", 5000, 2);
        list[1] = new Product("A2", " chuot ", 200, 10);

        Product cheap = findCheapest(list, n);
        System.out.println("Rẻ nhất: " + cheap.name);

        System.out.println("Tổng kho: " + calculateTotalValue(list, n));
    }


    public static Product findCheapest(Product[] list, int n) {
        Product min = list[0];
        for (int i = 1; i < n; i++) {
            if (list[i].price < min.price) {
                min = list[i];
            }
        }
        return min;
    }

    public static double calculateTotalValue(Product[] list, int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += list[i].price * list[i].quantity;
        }
        return sum;
    }

}
