package org.example.functional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class User {
    private String guid;
    private String lastName;
    private String firstName;
    private String city;
    private String country;
    private long salary;
}
