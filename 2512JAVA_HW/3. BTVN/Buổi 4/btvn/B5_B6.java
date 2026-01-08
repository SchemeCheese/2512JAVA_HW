package buoi4.btvn;

public class B5_B6 {

    public static void bai5va6() {
        String data = "Java,Python,C++,PHP,JavaScript";
        String[] languages = data.split(",");
        for (String lang : languages) {
            if (lang.startsWith("Java")) {
                System.out.println("Tìm thấy: " + lang);
            }
        }
        System.out.println("Vị trí chữ 'P' đầu tiên: " + data.indexOf('P'));

        String sentence = "Học viện công nghệ thông tin T3H";
        int index = sentence.indexOf("T3H");
        System.out.println("Từ cắt được: " + sentence.substring(index));
        System.out.println("Ký tự tại index 5: " + sentence.charAt(5));
    }

}
