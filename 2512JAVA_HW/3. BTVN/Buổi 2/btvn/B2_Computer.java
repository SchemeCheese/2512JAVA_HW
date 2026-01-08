package buoi2.btvn;

public class B2_Computer {


        String name;
        public static int totalComputersCreated = 0;

        public B2_Computer(String name) {
            this.name = name;
            totalComputersCreated++;
        }

        public static void changeDeviceName(B2_Computer computer, String newName) {
            computer.name = newName;
        }

        public static void main(String[] args) {
            B2_Computer c1 = new B2_Computer("Dell");
            B2_Computer c2 = new B2_Computer("HP");

            changeDeviceName(c1, "MacBook");
            changeDeviceName(c2, "MSI");

            System.out.println("Name after change: " + c1.name);
            System.out.println("Name after change: " + c2.name);
            System.out.println("Total computers created: " + totalComputersCreated);
        }


}
