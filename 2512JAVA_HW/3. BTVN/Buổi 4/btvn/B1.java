package buoi4.btvn;

public class B1 {

    public static void bai1() {
        int[] arr = new int[10];

        System.out.print("Mảng: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nTổng số phần tử (length): " + arr.length);
    }

}
