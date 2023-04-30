package org.example.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    private Long employeeId;
    private String firstName;
    private BigDecimal salary;
    private Integer department;

}
