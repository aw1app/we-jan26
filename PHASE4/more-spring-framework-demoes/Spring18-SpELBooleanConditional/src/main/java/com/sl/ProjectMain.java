package com.sl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProjectMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SpELConditionalDemo demo = context.getBean(SpELConditionalDemo.class);
        System.out.println("Is Greater: " + demo.isGreater());
        System.out.println("Ternary: " + demo.getTernaryResult());
        System.out.println("Elvis: " + demo.getElvisResult());
        context.close();
    }
}