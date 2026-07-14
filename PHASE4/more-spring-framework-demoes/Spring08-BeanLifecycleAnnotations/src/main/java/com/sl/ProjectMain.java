package com.sl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProjectMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageService ms = context.getBean(MessageService.class);
        System.out.println("Service message: " + ms.getMessage());
        context.close();
    }
}