package buoi4.btvn;

public class B12 {

    public static void bai12() {
        String s = "madam";
        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();

        if (s.equals(reversed)) System.out.println(s + " là Palindrome");
        else System.out.println(s + " không phải Palindrome");
    }

}
