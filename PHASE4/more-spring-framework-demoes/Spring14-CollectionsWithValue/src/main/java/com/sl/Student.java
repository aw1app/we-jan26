package com.sl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Student {
    @Value("${student.name}")
    private String name;

    @Value("#{'${student.courses}'.split(',')}")
    private List<String> courses;

    @Value("${student.grades}")
    private String[] grades;

    public String getName() { return name; }
    public List<String> getCourses() { return courses; }
    public String[] getGrades() { return grades; }
}