package com.sl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProjectMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SpELStaticDemo demo = context.getBean(SpELStaticDemo.class);
        System.out.println("PI: " + demo.getPiVal());
        System.out.println("Abs: " + demo.getAbsVal());
        context.close();
    }
}