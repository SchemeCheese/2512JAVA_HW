package buoi4.btvn;

public class B2 {

    public static void bai2() {
        String s = "   Hello Java   ";
        System.out.println("Độ dài ban đầu: " + s.length());
        System.out.println("Chữ hoa: " + s.toUpperCase());
        System.out.println("Chữ thường: " + s.toLowerCase());

        String trimmed = s.trim();
        System.out.println("Sau khi trim(): '" + trimmed + "' (Độ dài: " + trimmed.length() + ")");
    }

}
