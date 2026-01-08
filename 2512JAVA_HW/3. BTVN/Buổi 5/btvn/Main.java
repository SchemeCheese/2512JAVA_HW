package buoi5.btvn;

import java.util.Scanner;

public class Main {
    static Product[] storage = new Product[100];
    static int count = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- HỆ THỐNG QUẢN LÝ KHO ---");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị & Thống kê");
            System.out.println("3. Tìm sản phẩm rẻ nhất");
            System.out.println("4. Cập nhật số lượng");
            System.out.println("5. Xóa sản phẩm");
            System.out.println("6. Sắp xếp giá giảm dần");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: addProduct(); break;
                case 2: showAndStats(); break;
                case 3: findCheapest(); break;
                case 4: updateProduct(); break;
                case 5: deleteProduct(); break;
                case 6: sortProducts(); break;
                case 0: System.exit(0);
                default: System.out.println("Sai chức năng!");
            }
        }
    }

    public static void addProduct() {
        if (count >= 100) {
            System.out.println("Kho đã đầy (max 100)!");
            return;
        }

        System.out.print("Bạn muốn thêm bao nhiêu sản phẩm? ");
        int n = 0;
        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số nguyên!");
            return;
        }

        if (n <= 0) {
            System.out.println("Số lượng phải lớn hơn 0.");
            return;
        }
        if (count + n > 100) {
            System.out.println("Kho không đủ chỗ. Chỉ còn trống " + (100 - count) + " vị trí.");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập thông tin sản phẩm thứ " + (i + 1) + " ---");

            System.out.print("Nhập ID: ");
            String id = scanner.nextLine();

            boolean isExist = false;
            for (int k = 0; k < count; k++) {
                if (storage[k].getId().equals(id)) {
                    System.out.println("Lỗi: ID '" + id + "' đã tồn tại! Vui lòng nhập lại.");
                    isExist = true;
                    break;
                }
            }

            if (isExist) {
                i--;
                continue;
            }

            System.out.print("Nhập tên: ");
            String name = formatName(scanner.nextLine());

            System.out.print("Nhập giá: ");
            double price = 0;
            try {
                price = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Giá phải là số! Nhập lại sản phẩm này.");
                i--; continue;
            }

            System.out.print("Nhập số lượng tồn kho: ");
            int quantity = 0;
            try {
                quantity = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Số lượng phải là số nguyên! Nhập lại sản phẩm này.");
                i--; continue;
            }

            storage[count] = new Product(id, name, price, quantity);
            count++;
            System.out.println("-> Thêm xong sản phẩm " + (i + 1) + "/" + n);
        }

        System.out.println("\n=== Hoàn tất thêm " + n + " sản phẩm mới! ===");
    }

    public static String formatName(String name) {
        name = name.trim().replaceAll("\\s+", " ");
        String[] words = name.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return result.toString().trim();
    }

    public static void showAndStats() {
        if (count == 0) {
            System.out.println("Kho trống.");
            return;
        }
        double totalValue = 0;
        for (int i = 0; i < count; i++) {
            storage[i].showInfo();
            totalValue += storage[i].getPrice() * storage[i].getQuantity();
        }
        System.out.println("=> TỔNG GIÁ TRỊ KHO: " + totalValue);
    }

    public static void findCheapest() {
        if (count == 0) return;
        Product minProd = storage[0];
        for (int i = 1; i < count; i++) {
            if (storage[i].getPrice() < minProd.getPrice()) {
                minProd = storage[i];
            }
        }
        System.out.println("Sản phẩm rẻ nhất:");
        minProd.showInfo();
    }

    public static void updateProduct() {
        System.out.print("Nhập ID cần sửa: ");
        String id = scanner.nextLine();
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (storage[i].getId().equals(id)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.print("Nhập tên mới: ");
            String newName = formatName(scanner.nextLine());
            System.out.print("Nhập giá mới: ");
            double newPrice = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhập số lượng mới: ");
            int newQty = Integer.parseInt(scanner.nextLine());

            storage[index].setName(newName);
            storage[index].setPrice(newPrice);
            storage[index].setQuantity(newQty);
            System.out.println("Cập nhật thành công.");
        } else {
            System.out.println("Sản phẩm không tồn tại.");
        }
    }

    public static void deleteProduct() {
        System.out.print("Nhập ID cần xóa: ");
        String id = scanner.nextLine();
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (storage[i].getId().equals(id)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                storage[i] = storage[i + 1];
            }
            storage[count - 1] = null;
            count--;
            System.out.println("Đã xóa sản phẩm.");
        } else {
            System.out.println("Không tìm thấy ID.");
        }
    }

    public static void sortProducts() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (storage[j].getPrice() < storage[j + 1].getPrice()) {
                    Product temp = storage[j];
                    storage[j] = storage[j + 1];
                    storage[j + 1] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp danh sách theo giá giảm dần:");
        showAndStats();
    }
}