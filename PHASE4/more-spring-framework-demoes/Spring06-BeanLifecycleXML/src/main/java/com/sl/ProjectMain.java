package com.sl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProjectMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DatabaseConnection db = context.getBean("dbConn", DatabaseConnection.class);
        System.out.println("Using DB: " + db.getDbName());
        context.close();
    }
}