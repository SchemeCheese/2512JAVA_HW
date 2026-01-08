package buoi2.btvn;

import java.util.Scanner;

public class B3_PerformanceCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập RAM: ");
        int ram = sc.nextInt();

        System.out.print("Có SSD không (true/false): ");
        boolean hasSSD = sc.nextBoolean();

        if (ram >= 16 && hasSSD) {
            System.out.println("Loại VIP");
        } else if (ram >= 8 && ram < 16 && hasSSD) {
            System.out.println("Loại Khá");
        } else if (ram >= 8 && !hasSSD) {
            System.out.println("Loại Trung bình");
        } else {
            System.out.println("Loại Yếu");
        }
    }

}
