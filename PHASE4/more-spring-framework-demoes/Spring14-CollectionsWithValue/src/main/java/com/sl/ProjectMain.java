package com.sl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Arrays;

public class ProjectMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = context.getBean(Student.class);
        System.out.println("Student Name: " + student.getName());
        System.out.println("Courses: " + student.getCourses());
        System.out.println("Grades: " + Arrays.toString(student.getGrades()));
        context.close();
    }
}