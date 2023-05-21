package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class MariaDbRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> getCountries(){
        String sql = "SELECT country_name FROM hr.countries";
        List<String> countries = jdbcTemplate.queryForList(sql, String.class);
        return countries;
    }

}
