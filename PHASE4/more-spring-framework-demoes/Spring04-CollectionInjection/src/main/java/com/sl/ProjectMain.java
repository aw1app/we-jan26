package com.sl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProjectMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        College college = context.getBean("college", College.class);
        System.out.println("College Name: " + college.getName());
        System.out.println("Departments: " + college.getDepartments());
        System.out.println("Courses: " + college.getCourses());
        System.out.println("Faculty: " + college.getFacultyMapping());
        // For properties, to avoid random ordering printing issues, print key values directly
        System.out.println("Contact Phone: " + college.getContactInfo().getProperty("phone"));
        System.out.println("Contact Email: " + college.getContactInfo().getProperty("email"));
    }
}