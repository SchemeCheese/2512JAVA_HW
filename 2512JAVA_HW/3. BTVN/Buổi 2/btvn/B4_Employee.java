package buoi2.btvn;

public class B4_Employee {

    String name;

    public void calculateNetSalary(double grossSalary) {

        if (grossSalary < 0) {
            System.out.println("Lương không hợp lệ!");
            return;
        }

        double taxRate;

        if (grossSalary > 20000000) {
            taxRate = 0.2;
        } else if (grossSalary >= 10000000) {
            taxRate = 0.1;
        } else {
            taxRate = 0;
        }

        double taxAmount = grossSalary * taxRate;
        double netSalary = grossSalary;
        netSalary -= taxAmount;

        System.out.println("Lương gộp: " + (long)grossSalary);
        System.out.println("Thuế phải đóng: " + taxAmount);
        System.out.println("Lương thực nhận: " + (long)netSalary);
    }

    public static void main(String[] args) {
        B4_Employee e = new B4_Employee();
        e.calculateNetSalary(25000000);
    }

}
