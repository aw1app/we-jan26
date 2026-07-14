package com.sl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProjectMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService service = context.getBean(ProductService.class);
        System.out.println("Product: " + service.getProduct());
        context.close();
    }
}