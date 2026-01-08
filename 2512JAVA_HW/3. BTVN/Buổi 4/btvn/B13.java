package buoi4.btvn;

public class B13 {

    public static void bai13() {
        int[] arr = {10, 5, 20, 20, 8};
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }
        System.out.println("Số lớn thứ hai: " + secondMax);
    }

}
