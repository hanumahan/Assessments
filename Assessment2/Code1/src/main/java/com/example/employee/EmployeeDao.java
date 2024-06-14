package com.example.employee;
import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(int id);
}
