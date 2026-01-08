package buoi4.btvn;

public class B14 {

    public static void bai14() {
        String s = "hello java";
        int[] freq = new int[256];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0 && (char)i != ' ') {
                System.out.println("Ký tự '" + (char)i + "': " + freq[i] + " lần");
            }
        }
    }

}
