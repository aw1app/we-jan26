package org.example.sprintrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.sl"})
public class SprintRestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprintRestDemoApplication.class, args);
    }

}
