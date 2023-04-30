package org.example.repository;

import org.example.MyRepository;
import org.example.model.Employee;

import java.math.BigDecimal;
import java.sql.SQLException;

public class MyEmployeeRepository extends EmployeeRepository {

    @Override
    public  Employee getEmployeeById(Integer employeeId) throws SQLException {
        return new Employee(123L,"vasya", new BigDecimal(1), 12);
    }
}
