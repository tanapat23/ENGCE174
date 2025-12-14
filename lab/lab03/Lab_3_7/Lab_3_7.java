package Lab_3.Lab_3_7;

import java.util.Scanner;

class Employee {
    private String employeeId;
    private String department;

    public Employee(String employeeId, String department) {
        this.employeeId = employeeId;
        this.department = department;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String newDepartment) {
        this.department = newDepartment;
    }
}

public class Lab_3_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Employee ID : ");
        String empId = input.nextLine();

        System.out.print("Enter Initial Department : ");
        String initialDept = input.nextLine();

        System.out.print("Enter New Department : ");
        String newDept = input.nextLine();

        Employee emp = new Employee(empId, initialDept);

        emp.setDepartment(newDept);

        System.out.println(emp.getEmployeeId());
        System.out.println(emp.getDepartment());

        input.close();
    }
}