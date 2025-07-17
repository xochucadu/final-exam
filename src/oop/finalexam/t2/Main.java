package oop.finalexam.t2;

public class Main {
    public static void main(String[] args) {
        UMS ums = new UMS();

        // You as the student (name and ID)
        Student nikita = new Student("Nikita Bezhanovi", "NB2025");

        // STRICTLY ONLY YOUR 4 COURSES:
        nikita.addCourse(new LearningCourse(
                "Object-Oriented Programming",
                "",  // Leave empty or add real prerequisites from Argus
                ""   // Leave empty or add real topics from Argus
        ));

        nikita.addCourse(new LearningCourse(
                "Algorithms and Data Structures",
                "",  // Leave empty or add real prerequisites
                ""   // Leave empty or add real topics
        ));

        nikita.addCourse(new LearningCourse(
                "Computer Organization",
                "",  // Leave empty or add real prerequisites
                ""   // Leave empty or add real topics
        ));

        nikita.addCourse(new LearningCourse(
                "English Language Course C1-2",
                "",  // Leave empty or add real prerequisites
                ""   // Leave empty or add real topics
        ));

        ums.addStudent(nikita);
        ums.printStudentData(nikita);
    }
}