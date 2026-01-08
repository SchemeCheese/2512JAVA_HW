package CK;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StoreManagement manager = new StoreManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSTORE MANAGEMENT SYSTEM");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Tìm kiếm theo tên");
            System.out.println("3. Xóa sản phẩm theo ID");
            System.out.println("4. Sắp xếp giá giảm dần");
            System.out.println("5. Thống kê tổng giá trị");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = 0;
            try {
                String input = scanner.nextLine();
                if (input.isEmpty()) continue;
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch (choice) {
                case 1:
                    manager.addProduct();
                    break;
                case 2:
                    manager.searchByName();
                    break;
                case 3:
                    manager.deleteById();
                    break;
                case 4:
                    manager.sortAndDisplay();
                    break;
                case 5:
                    manager.showStatistics();
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Chức năng không tồn tại!");
            }
        }
    }
}

