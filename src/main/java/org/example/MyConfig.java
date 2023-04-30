package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.spy.memcached.MemcachedClient;
import org.example.model.Citizen;
import org.example.model.City;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyConfig {

    @Value("${databaseurl}")
    private String url;

    @Bean("employeeDataSource")
    public DataSource mariaDbDataSource() throws SQLException {
        MariaDbDataSource dbDataSource = new MariaDbDataSource();
        dbDataSource.setUrl(url);
        return dbDataSource;
    }

    @Value("classpath:citizen1000.json")
    private Resource resource;

    @Bean
    List<Citizen> allCitizensFromFile() {
        try (InputStream inputStream = resource.getInputStream()) {
            String json = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            final ObjectMapper objectMapper = new ObjectMapper();
            List<Citizen> allCitizens = objectMapper.readValue(json, new TypeReference<List<Citizen>>() {
            });
            return allCitizens.subList(0, 3);
        } catch (IOException e) {
            throw new RuntimeException("Initialization of list citizen failed:" + e.getMessage());
        }
    }

    @Bean
    public MemcachedClient memcachedClient() throws IOException {
        return new MemcachedClient(new InetSocketAddress("185.106.92.118", 11211));
    }

    @Bean
    List<City> initCitiesFroUrl() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://gist.githubusercontent.com/isicju/57f52dc77344eba300d6c6b051b29187/raw/1a2ff4fc5faa1ba58f7c3fcbb0d47dbd15baa340/cities";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        List<City> newCities = new ArrayList<>();
        for (String cityRecord : response.getBody().split("\n")) {
            String cityName = cityRecord.split("\t")[0];
            String latitude = cityRecord.split("\t")[2];
            String longitude = cityRecord.split("\t")[3];
            String countryName = cityRecord.split("\t")[4];
            newCities.add(new City(countryName, cityName, latitude, longitude));
        }
        return newCities;
    }

    @Bean
    File file() throws IOException {
        File file = new File("myRepository.txt");
        if (!file.exists()) file.createNewFile();
        return file;
    }

}
