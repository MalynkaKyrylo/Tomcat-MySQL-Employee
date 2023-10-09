package org.example.app.repository;

import org.example.app.database.DBConn;
import org.example.app.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeRepository {

    private static final Logger LOGGER =
            Logger.getLogger(EmployeeRepository.class.getName());

    public void createEmployee(Employee employee) {
        String sql = "INSERT INTO employees (name, position, phone) VALUES (?, ?, ?)";
        // try-with-resources statement for automatic disconnect from DB
        try (Connection conn = DBConn.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getPosition());
            pstmt.setString(3, employee.getPhone());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
    }

    public List<Employee> readEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        // try-with-resources statement for automatic disconnect from DB
        try (Connection conn = DBConn.connect();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Employee(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("position"),
                                rs.getString("phone")
                        )
                );
            }
            // Повертаємо колекцію даних
            return list;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            // Якщо помилка – повертаємо порожню колекцію
            return Collections.emptyList();
        }
    }

    public Employee getEmployeeById(int id) {
        Employee employee = null;
        String sql = "SELECT * FROM employees WHERE id = ?";
        // try-with-resources statement for automatic disconnect from DB
        try (Connection conn = DBConn.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                employee = new Employee(id, rs.getString("name"),
                        rs.getString("position"),
                        rs.getString("phone")
                );
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
        return employee;
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET name = ?, position = ?, phone = ? WHERE id = ?";
        // try-with-resources statement for automatic disconnect from DB
        try (Connection conn = DBConn.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getPosition());
            pstmt.setString(3, employee.getPhone());
            pstmt.setInt(4, employee.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
    }

    public void deleteEmployee(Employee employee) {
        String sql = "DELETE FROM employees where id = ?";
        // try-with-resources statement for automatic disconnect from DB
        try (Connection conn = DBConn.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, employee.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
    }
}
