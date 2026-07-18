package org.example.sprintrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.sl"})
@EnableJpaRepositories({"com.sl"})
public class SprintRestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprintRestDemoApplication.class, args);
    }

}
