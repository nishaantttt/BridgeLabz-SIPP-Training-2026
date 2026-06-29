abstract class Employee {

    private int employeeId;
    private String employeeName;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public abstract double calculateSalary();

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
    }
}

class FullTimeEmployee extends Employee {

    private double monthlySalary;

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {

        FullTimeEmployee emp1 = new FullTimeEmployee();
        emp1.setEmployeeId(101);
        emp1.setEmployeeName("Mayank");
        emp1.setMonthlySalary(50000);

        PartTimeEmployee emp2 = new PartTimeEmployee();
        emp2.setEmployeeId(102);
        emp2.setEmployeeName("Ravi");
        emp2.setHoursWorked(80);
        emp2.setHourlyRate(300);

        emp1.displayEmployeeInfo();
        System.out.println("Salary: ₹" + emp1.calculateSalary());

        System.out.println();

        emp2.displayEmployeeInfo();
        System.out.println("Salary: ₹" + emp2.calculateSalary());
    }
}