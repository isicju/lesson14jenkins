package org.example.repository;

import org.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class EmployeeRepository {

    @Autowired
    @Qualifier("employeeDataSource")
    private DataSource mariaDbDataSource;

    public Employee getEmployeeById(Integer employeeId) throws SQLException {
        Connection connection = mariaDbDataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  hr.employees WHERE employee_id = ?");
        preparedStatement.setInt(1, employeeId);

        ResultSet resultSet = preparedStatement.executeQuery();

        Employee employee = null;

        while (resultSet.next()) {
            employee = Employee.builder()
                    .employeeId(resultSet.getLong("employee_id"))
                    .firstName(resultSet.getString("first_name"))
                    .salary(resultSet.getBigDecimal("salary"))
                    .department(resultSet.getInt("department_id"))
                    .build();
        }
        return employee;
    }

}
