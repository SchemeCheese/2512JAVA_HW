package buoi5.bt;

public class DataCleaner {

    public static String removeSpaceAtEnds(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end && s.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && s.charAt(end) == ' ') {
            end--;
        }

        return s.substring(start, end + 1);
    }

    public static String formatName(String name) {

        name = removeSpaceAtEnds(name);

        String temp = "";
        boolean space = false;

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            if (c != ' ') {
                temp += c;
                space = false;
            } else if (!space) {
                temp += ' ';
                space = true;
            }
        }

        String[] words = temp.split(" ");
        String result = "";

        for (String w : words) {
            result += Character.toUpperCase(w.charAt(0))
                    + w.substring(1).toLowerCase()
                    + " ";
        }

        return result.substring(0, result.length() - 1);
    }

    public static String generateID(String name, int index) {
        String[] words = name.split(" ");
        String id = "";

        for (String w : words) {
            id += Character.toUpperCase(w.charAt(0));
        }

        return id + index;
    }
}
