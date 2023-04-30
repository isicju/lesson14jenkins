package org.example.controller;

import lombok.AllArgsConstructor;
import net.spy.memcached.MemcachedClient;
import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private EmployeeRepository employeeRepository;
    private MemcachedClient memcachedClient;

    @GetMapping(value = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getAllEmployees(@PathVariable Integer id) throws SQLException {
        Object cachedValue = memcachedClient.get(String.valueOf(id));
        if (cachedValue != null) {
            return (Employee) cachedValue;
        }
        Employee employee = employeeRepository.getEmployeeById(id);

        memcachedClient.set(String.valueOf(id), 3600, employee);

        return employee;
    }

}
