package org.example;

import org.example.model.Citizen;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        for (int i = 0;i<20000;i++){
            (new  Thread(new Runnable() {
                @Override
                public void run() {
                    RestTemplate restTemplate = new RestTemplate();
                    String string =  restTemplate.getForObject("http://localhost:8080/citizens", String.class);
                    System.out.println(string);
                }
            })).start();
        }
    }
}
