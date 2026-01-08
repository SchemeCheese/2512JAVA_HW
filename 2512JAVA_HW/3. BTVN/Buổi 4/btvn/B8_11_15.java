package buoi4.btvn;


import java.util.Arrays;
import java.util.Scanner;

public class B8_11_15 {

    public static void xuLyMaTran() {
        int n = 3;
        int[][] matrix = new int[n][n];
        Scanner sc = new Scanner(System.in);
        int sumAll = 0, sumMain = 0, sumSub = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("Nhập a[%d][%d]: ", i, j);
                matrix[i][j] = sc.nextInt();
                sumAll += matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            sumMain += matrix[i][i];
            sumSub += matrix[i][n - 1 - i];
        }

        System.out.println("Tổng toàn bộ: " + sumAll);
        System.out.println("Tổng chéo chính: " + sumMain);
        System.out.println("Tổng chéo phụ: " + sumSub);
    }

    public static void bai11() {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        System.out.println("Mảng đảo ngược: " + Arrays.toString(arr));
    }

}
