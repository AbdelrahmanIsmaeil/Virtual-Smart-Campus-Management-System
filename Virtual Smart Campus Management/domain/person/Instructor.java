package com.mycompany.OOP_Project.domain.person;

import com.mycompany.OOP_Project.domain.academic.Course;
import java.util.ArrayList;
import java.util.List;

public class Instructor extends Person {
    private List<Course> teachingCourses;
    private String depart;
    
    public Instructor(int id, String firstName, String lastName, String middleName, String address, int age, String email, String pass, String depart) {
        super(id, firstName, lastName, middleName, address, age, email, pass);
        this.teachingCourses = new ArrayList<>();
        this.depart = depart;
    }
    
    public String getDepart() { return depart; }
    public void setDepart(String depart) { this.depart = depart; }

    public List<Course> getTeachingCourses() {
        return new ArrayList<>(teachingCourses);
    }

    public void gradeStudent(Student student, Course course, String grade) {
        if (!teachingCourses.contains(course)) {
            System.out.println("Error: " + getFirstName() + " " + getLastName() + " does not teach " + course.getCourseName());
            return;
        }
        if (!course.getStudents().contains(student)) {
            System.out.println("Error: " + student.getFirstName() + " " + student.getLastName() + " is not enrolled in " + course.getCourseName());
            return;
        }
        System.out.println("Instructor " + getFirstName() + " " + getLastName() + " assigned grade " + grade +
                " to student " + student.getFirstName() + " " + student.getLastName() +
                " for course " + course.getCourseName());
    }

    public void createAssignment(Course course, String assignmentDetails) {
        if (!teachingCourses.contains(course)) {
            System.out.println("Error: " + getFirstName() + " " + getLastName() + " does not teach " + course.getCourseName());
            return;
        }
        System.out.println("Instructor " + getFirstName() + " " + getLastName() + " created assignment for " +
                course.getCourseName() + ": " + assignmentDetails);

        for (Student student : course.getStudents()) {
            student.sendNotification("New assignment in " + course.getCourseName() +
                    ": " + assignmentDetails);
        }
    }

    public void addCourseInternal(Course course) {
        if (course != null && !teachingCourses.contains(course)) {
            teachingCourses.add(course);
        }
    }

    @Override
    public void viewProfile() {
        System.out.println("Instructor Profile");
        System.out.println("  ID: " + getId());
        System.out.println("  First Name: " + getFirstName());
        System.out.println("  Last Name: " + getLastName());
        System.out.println("  Middle Name: " + (getMiddleName().isEmpty() ? "N/A" : getMiddleName()));
        System.out.println("  Address: " + getAddress());
        System.out.println("  Age: " + getAge());
        System.out.println("  Email: " + getEmail());
        System.out.println("  Department: " + depart);
    }

    @Override
    public String toString() {
        return super.toString() + ", department=" + depart;
    }
}
