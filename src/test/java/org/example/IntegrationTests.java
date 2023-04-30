package org.example;

import org.example.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(classes = MyTestConfiguration.class, properties = "spring.main.allow-bean-definition-overriding=true", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class IntegrationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    EmployeeRepository repository;

    @Test
    void contextLoads() {
        assertThat(applicationContext, is(notNullValue()));
    }

    @Test
    void testRepository() throws SQLException {
        assertThat(repository, is(notNullValue()));
        assertThat(repository.getEmployeeById(10211111), is(notNullValue()));

    }

    @Test
    void empoyeeTest() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/employees/10211111";
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
    }

}
