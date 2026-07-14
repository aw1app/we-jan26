package com.sl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProjectMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        FileService fs = context.getBean("fileService", FileService.class);
        System.out.println("Writing to: " + fs.getFileName());
        context.close();
    }
}