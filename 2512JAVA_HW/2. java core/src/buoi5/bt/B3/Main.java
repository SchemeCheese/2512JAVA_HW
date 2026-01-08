package buoi5.bt.B3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student[] list = new Student[100];
        int n = 0;
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Hiển thị bảng điểm");
            System.out.println("3. Tìm sinh viên theo ID");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Nhập số sinh viên: ");
                    int m = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < m; i++) {
                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        System.out.print("Tên: ");
                        String name = sc.nextLine();

                        System.out.print("Điểm chuyên cần: ");
                        double att = sc.nextDouble();

                        System.out.print("Điểm thi: ");
                        double exam = sc.nextDouble();
                        sc.nextLine();

                        list[n] = new Student(id, name, att, exam);
                        n++;
                    }
                    break;

                case 2:
                    System.out.println("ID | Tên | Điểm cuối | Xếp loại");
                    for (int i = 0; i < n; i++) {
                        Student s = list[i];
                        System.out.println(
                                s.id + " | " +
                                        s.name + " | " +
                                        s.calculateFinalScore() + " | " +
                                        s.getGrade()
                        );
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID cần tìm: ");
                    String findId = sc.nextLine();
                    boolean found = false;

                    for (int i = 0; i < n; i++) {
                        if (list[i].id.equals(findId)) {
                            Student s = list[i];
                            System.out.println(
                                    s.id + " | " +
                                            s.name + " | " +
                                            s.calculateFinalScore() + " | " +
                                            s.getGrade()
                            );
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy sinh viên!");
                    }
                    break;
            }

        } while (choice != 0);
    }

}
