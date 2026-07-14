package com.sl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProjectMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ServerConfig config = context.getBean(ServerConfig.class);
        System.out.println("Host: " + config.getHost());
        System.out.println("Port: " + config.getPort());
        System.out.println("Env: " + config.getEnv());
        System.out.println("Timeout: " + config.getTimeout());
        context.close();
    }
}