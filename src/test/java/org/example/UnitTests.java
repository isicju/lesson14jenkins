package org.example;

import net.spy.memcached.MemcachedClient;
import org.example.controller.EmployeeController;
import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = MyTestConfigurationUnit.class, properties = "spring.main.allow-bean-definition-overriding=true")
class UnitTests {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeController employeeController;

    @Autowired
    MemcachedClient memcachedClient;

    @Test
    void contextLoads() {
        assertThat(applicationContext, is(notNullValue()));
    }

    @Test
    void testRepository() throws SQLException {
        Employee employee = new Employee(11123L, "fromCache", new BigDecimal(1), 12);
        when(memcachedClient.get(anyString())).thenReturn(employee);

        Employee employeerepo = new Employee(11123L, "mocknamerepo", new BigDecimal(1), 12);
        when(employeeRepository.getEmployeeById(anyInt())).thenReturn(employeerepo);

        assertThat(employeeController.getAllEmployees(124), equalTo(employee));
    }

    @Test
    void testRepository1() throws SQLException {
        when(memcachedClient.get(anyString())).thenReturn(null);

        Employee employeerepo = new Employee(11123L, "mocknamerepo", new BigDecimal(1), 12);
        when(employeeRepository.getEmployeeById(anyInt())).thenReturn(employeerepo);
    }

}
