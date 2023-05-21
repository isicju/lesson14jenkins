package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class DemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);


    public static void main(String[] args) throws InterruptedException {
        logger.info("info!");
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        System.out.println("started!");
        logger.warn("warnings!");
        logger.error("errors!");
        while (true){
            Thread.sleep(1000);
            logger.info("info: " + System.currentTimeMillis());
            logger.error("error: " + System.currentTimeMillis());
        }
//        MyService myService1  = context.getBean("myService", MyService.class)
//        context.put(MyService.class, myService);
    }

}
