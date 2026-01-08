package buoi2.btvn;

import java.util.Scanner;

public class Account {
    static String bankName = "T3H Bank";
    String customerName;
    double balance;

    public Account(String customerName, double balance) {
        this.customerName = customerName;
        this.balance = balance;
    }

    public void showInfo() {
        System.out.println("Thong tin khach hang");
        System.out.println("Ngan hang: " + bankName);
        System.out.println("Khach hang: " + customerName);
        System.out.println("So du: " + balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien khong hop le");
            return;
        }


        double newBalance = balance + amount;
        balance = newBalance;
    }

    public double calculateCompoundInterest(double currentBalance, int months) {
        if (months == 0)
            return currentBalance;

        return calculateCompoundInterest(currentBalance * 1.01, months - 1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account acc = new Account("Hoang Kim Chi", 0);

        double amount;

        do {

            System.out.println("Nhap so tien nap: ");
            amount = sc.nextDouble();

            if (amount > 0) {
                acc.deposit(amount);
                acc.showInfo();
            }

        }while (amount != 0);

        System.out.println("Nhap so thang gui: ");
        int months = sc.nextInt();

        double finalbalance = acc.calculateCompoundInterest(acc.balance, months);
        System.out.println("So du sau " +months+ " thang " +finalbalance);

        sc.close();
    }
}
