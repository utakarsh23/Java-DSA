package AssignmentOne;

//39
public class Employee {
    private String salaryCode;
    private String designation;
    private double salary;
    private String department;

    public Employee(String salaryCode, String designation, double salary, String department) {
        this.salaryCode = salaryCode;
        this.designation = designation;
        this.salary = salary;
        this.department = department;
    }

    public void displayDetails() {
        System.out.println("----- Employee Details -----");
        System.out.println("Salary Code  : " + salaryCode);
        System.out.println("Designation  : " + designation);
        System.out.println("Salary       : " + salary);
        System.out.println("Department   : " + department);
    }

}

class mainClass4 {
    public static void main(String[] args) {
        Employee emp1 = new Employee("SC101", "Software Engineer", 75000.0, "Development");
        Employee emp2 = new Employee("SC102", "QA Analyst", 60000.0, "Testing");

        emp1.displayDetails();
        emp2.displayDetails();
    }
}