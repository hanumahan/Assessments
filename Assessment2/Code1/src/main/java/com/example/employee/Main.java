package com.example.employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService employeeService = context.getBean(EmployeeService.class);

        employeeService.addEmployee(new Employee(0, "harry", "HR"));
        employeeService.addEmployee(new Employee(1, "hari", "IT"));

        System.out.println("All Employees: " + employeeService.getAllEmployees());

    
        System.out.println("Employee with ID 1: " + employeeService.getEmployeeById(1));

        Employee updatedEmployee = new Employee(1, "hari", "Finance");
        employeeService.updateEmployee(updatedEmployee);
        System.out.println("Updated Employee with ID 1: " + employeeService.getEmployeeById(1));

      
        employeeService.deleteEmployee(2);
        System.out.println("All Employees after deletion: " + employeeService.getAllEmployees());

        context.close();
    }
}
