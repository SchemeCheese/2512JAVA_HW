package buoi3;

import java.util.Scanner;

public class B2 {

    public static void checkPrimeNumber(int n) {
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime == true) System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");

        int n = sc.nextInt();

        checkPrimeNumber(n);
    }
}
