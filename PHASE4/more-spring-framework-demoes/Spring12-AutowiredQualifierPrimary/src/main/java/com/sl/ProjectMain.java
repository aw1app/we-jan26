package com.sl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProjectMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderProcessor processor = context.getBean(OrderProcessor.class);
        processor.processOrder(250.0);
        context.close();
    }
}