package buoi4.btvn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n================ MENU BÀI TẬP ================");
            System.out.println("1.  Bài 1: Mảng cơ bản");
            System.out.println("2.  Bài 2: Chuỗi cơ bản");
            System.out.println("3.  Bài 3: Ký tự thoát");
            System.out.println("4.  Bài 4: Min/Max & Sắp xếp");
            System.out.println("5.  Bài 5 & 6: Tách & Cắt chuỗi");
            System.out.println("7.  Bài 7: So sánh chuỗi");
            System.out.println("8.  Bài 8 & 15: Ma trận (Nhập & Tính tổng)");
            System.out.println("9.  Bài 9: Check Null (Null Safety)");
            System.out.println("10. Bài 10: StringBuilder");
            System.out.println("11. Bài 11: Đảo ngược mảng");
            System.out.println("12. Bài 12: Kiểm tra Palindrome");
            System.out.println("13. Bài 13: Tìm số lớn thứ hai");
            System.out.println("14. Bài 14: Đếm tần suất ký tự");
            System.out.println("0.  Thoát");
            System.out.print("Chọn bài muốn chạy: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch (choice) {
                case 1:
                    B1.bai1();
                    break;
                case 2:
                    B2.bai2();
                    break;
                case 3:
                    B3.bai3();
                    break;
                case 4:
                    B4.bai4();
                    break;
                case 5:
                case 6:
                    B5_B6.bai5va6();
                    break;
                case 7:
                    B7.bai7();
                    break;
                case 8:
                case 15:
                    B8_11_15.xuLyMaTran();
                    break;
                case 9:
                    System.out.println("Test với 'T3H':");
                    B9.checkName("T3H");
                    System.out.println("Test với null (để xem có lỗi không):");
                    B9.checkName(null);
                    break;
                case 10:
                    B10.bai10();
                    break;
                case 11:
                    B8_11_15.bai11();
                    break;
                case 12:
                    B12.bai12();
                    break;
                case 13:
                    B13.bai13();
                    break;
                case 14:
                    B14.bai14();
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn lại!");
            }

            System.out.println("\n(Ấn Enter để tiếp tục...)");
            scanner.nextLine();
        }
    }
}