package com.sl;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Properties;

public class College {
    private String name;
    private List<String> departments;
    private Set<String> courses;
    private Map<String, String> facultyMapping;
    private Properties contactInfo;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getDepartments() { return departments; }
    public void setDepartments(List<String> departments) { this.departments = departments; }

    public Set<String> getCourses() { return courses; }
    public void setCourses(Set<String> courses) { this.courses = courses; }

    public Map<String, String> getFacultyMapping() { return facultyMapping; }
    public void setFacultyMapping(Map<String, String> facultyMapping) { this.facultyMapping = facultyMapping; }

    public Properties getContactInfo() { return contactInfo; }
    public void setContactInfo(Properties contactInfo) { this.contactInfo = contactInfo; }
}