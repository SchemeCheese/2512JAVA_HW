package buoi4.btvn;

import java.util.Arrays;

public class B4 {

    public static void bai4() {
        int[] arr = {5, 2, 9, 1, 6};

        int min = arr[0], max = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        System.out.println("Min: " + min + " | Max: " + max);

        Arrays.sort(arr);
        System.out.println("Đã sắp xếp: " + Arrays.toString(arr));
    }

}
