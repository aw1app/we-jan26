package com.sl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProjectMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car = context.getBean("car", Car.class);
        System.out.println("Car Model: " + car.getModel());
        System.out.println("Engine Type: " + car.getEngine().getType());
        context.close();
    }
}