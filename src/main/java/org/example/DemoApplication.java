package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("before!");
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        System.out.println("started!");

//        MyService myService1  = context.getBean("myService", MyService.class)
//        context.put(MyService.class, myService);


    }

}
