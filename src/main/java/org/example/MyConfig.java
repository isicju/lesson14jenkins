package org.example;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class MyConfig {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration("91.105.196.213", 6379);
        redisConfig.setPassword("MY_SECRET_PASSWORD_123");
        return new LettuceConnectionFactory(redisConfig);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public DataSource mariaDbDataSource() throws SQLException {
        MariaDbDataSource dbDataSource = new MariaDbDataSource();
        dbDataSource.setUrl("jdbc:mariadb://91.105.196.213:3310/hr?user=root&password=passwordkeke");
        return dbDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource mariaDbDataSource){
        return new JdbcTemplate(mariaDbDataSource);
    }


}
