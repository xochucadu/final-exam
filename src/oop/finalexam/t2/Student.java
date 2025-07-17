package oop.finalexam.t2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String id;
    private List<LearningCourse> courses;

    // Constructor
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
    }

    // Add a course to the student's list
    public void addCourse(LearningCourse course) {
        courses.add(course);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<LearningCourse> getCourses() {
        return courses;
    }

    public void setCourses(List<LearningCourse> courses) {
        this.courses = courses;
    }
}