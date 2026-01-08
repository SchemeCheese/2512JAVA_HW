package buoi6.bai1;

public class EmployeeTechnical extends Employee {
    private int completedProjects;

    public EmployeeTechnical(String employeeId, String fullName, String address, double phoneNumber, int completedProjects) {
        super(employeeId, fullName, address, phoneNumber);
        this.completedProjects = completedProjects;
    }

    @Override
    public int calculateSalary() {

        return completedProjects * 5000000;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Completed Projects: " + completedProjects);
        System.out.printf("Salary: %,d VNĐ\n", calculateSalary());
    }

    public int getCompletedProjects() {
        return completedProjects;
    }

    public void setCompletedProjects(int completedProjects) {
        this.completedProjects = completedProjects;
    }
}