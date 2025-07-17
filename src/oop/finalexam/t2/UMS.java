package oop.finalexam.t2;

import java.util.ArrayList;
import java.util.List;

public class UMS {
    private List<Student> students;

    // Constructor
    public UMS() {
        this.students = new ArrayList<>();
    }

    // Add a student to the system
    public void addStudent(Student student) {
        students.add(student);
    }

    // Print student data including courses
    public void printStudentData(Student student) {
        if (student == null) {
            System.out.println("Error: Student not found!");
            return;
        }

        System.out.println("\n--- Student Information ---");
        System.out.println("Name: " + student.getName());
        System.out.println("ID: " + student.getId());

        System.out.println("\n--- Enrolled Courses ---");
        if (student.getCourses().isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            for (LearningCourse course : student.getCourses()) {
                System.out.println("\nCourse Title: " + course.getTitle());
                System.out.println("Prerequisites: " + course.getAcceptancePrerequisites());
                System.out.println("Major Topics: " + course.getMajorTopics());
            }
        }
    }

    // Getter for students list (optional)
    public List<Student> getStudents() {
        return students;
    }
}