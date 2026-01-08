package buoi3;

import java.util.Scanner;

public class B1 {

    public static void checkLeapYear(int year) {

        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println(year + " là năm nhuận");
        } else {
            System.out.println(year + " là năm thường");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập năm: ");
        int year = sc.nextInt();

        checkLeapYear(year);
    }
}
