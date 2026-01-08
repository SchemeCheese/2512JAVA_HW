package buoi6.bai1;

public class EmployeeSales extends Employee {
    private double salesAmount;

    public EmployeeSales() {
        super();
    }

    public EmployeeSales(String employeeId, String fullName, String address, double phoneNumber, double salesAmount) {
        super(employeeId, fullName, address, phoneNumber);
        this.salesAmount = salesAmount;
    }

    @Override
    public int calculateSalary() {

        return (int) (salesAmount * 0.10);
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("Sales Amount: %.0f VNĐ\n", salesAmount);
        System.out.printf("Salary: %,d VNĐ\n", calculateSalary());
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }
}