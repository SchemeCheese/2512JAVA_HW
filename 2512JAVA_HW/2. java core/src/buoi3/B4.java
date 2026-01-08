package buoi3;

import java.util.Scanner;

public class B4 {

    public static long tinhGiaiThua(int n) {

        if (n == 0 || n == 1) return 1;

        return n*tinhGiaiThua(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap n: ");
        int n = sc.nextInt();
        long result = tinhGiaiThua(n);
        System.out.println(n + "! = " +result);
    }

}
