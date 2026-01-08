package buoi4.btvn;

public class B10 {

    public static void bai10() {
        String s = "Start";

        StringBuilder sb = new StringBuilder("Start");
        for (int i = 0; i < 10000; i++) {
            sb.append("A");
        }
        System.out.println("Độ dài chuỗi: " + sb.length());
    }

}
