package org.example;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@AllArgsConstructor
public class CreditCalcController {

    @GetMapping(value = "/credit/{salary}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer getAllEmployees(@PathVariable Integer salary) throws SQLException {
        if (salary > 20000) return salary * 4;
        if (salary > 10000) return salary * 2;
        return -1;
    }

}