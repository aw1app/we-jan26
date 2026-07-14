package com.sl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProjectMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SpELDemo demo = context.getBean(SpELDemo.class);
        System.out.println("Add: " + demo.getAddResult());
        System.out.println("Concat: " + demo.getConcatResult());
        System.out.println("Mult: " + demo.getMultResult());
        context.close();
    }
}