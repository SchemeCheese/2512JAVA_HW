package buoi3;

import java.util.Scanner;

public class BT5 {

    public static boolean isPrime(int x) {

        if (x < 2) return false;

        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDuplicate(int[] arr, int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i] == arr[index]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        System.out.println("Tổng các phần tử trong mảng = " + sum);

        System.out.print("Các số nguyên tố trong mảng: ");
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (isPrime(arr[i]) && !isDuplicate(arr, i)) {
                System.out.print(arr[i] + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.print("Không có");
        }

        sc.close();
    }
}
