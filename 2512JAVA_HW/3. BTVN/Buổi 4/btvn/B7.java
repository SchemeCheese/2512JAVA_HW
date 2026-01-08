package buoi4.btvn;

public class B7 {

    public static void bai7() {
        String s1 = "t3h";
        String s2 = new String("t3h");

        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("So sánh không phân biệt hoa thường: " + "JAVA".equalsIgnoreCase("java"));
    }

}
