package com.sl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProjectMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Restaurant restaurant = context.getBean("restaurant", Restaurant.class);
        System.out.println("Restaurant: " + restaurant.getName());
        System.out.println("Menu Items: " + restaurant.getMenuItems());
        System.out.println("Prices: " + restaurant.getPrices());
    }
}