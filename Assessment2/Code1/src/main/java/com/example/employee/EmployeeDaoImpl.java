package com.example.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setDepartment(rs.getString("department"));
            return employee;
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO Employees (name, department) VALUES (?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment());
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM Employees";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM Employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        String sql = "UPDATE Employees SET name = ?, department = ? WHERE id = ?";
        return jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getId()) > 0;
    }

    @Override
    public boolean deleteEmployee(int id) {
        String sql = "DELETE FROM Employees WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}

