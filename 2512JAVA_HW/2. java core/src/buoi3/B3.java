package buoi3;

import java.util.Scanner;

public class B3 {

    public static int sum1To100() {
        int sum = 0;

        for (int i = 1; i <=100; i++) {
            sum += i;
        }
        return sum;
    }

    public static void  printAlphabet() {
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.println( c + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("MENU");
            System.out.println("1. Tính tổng các số từ 1 đến 100");
            System.out.println("2. In bảng chữ cái A-Z");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Tổng = " + sum1To100());
                    break;
                case 2:
                    printAlphabet();
                    break;
                case 3:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }while(choice != 0);

        sc.close();
    }

}
