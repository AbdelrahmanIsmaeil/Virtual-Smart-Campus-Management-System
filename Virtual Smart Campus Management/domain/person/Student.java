package com.mycompany.OOP_Project.domain.person;

import com.mycompany.OOP_Project.domain.academic.Course;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private List<Course> enrolledCourses;
    private double gpa;
    private int level;
 
    public Student(int id, String firstName, String lastName, String middleName, String address, int age, String email, String pass, double gpa, int level) {
        super(id, firstName, lastName, middleName, address, age, email, pass);
        this.gpa = gpa;
        this.level = level;
        this.enrolledCourses = new ArrayList<>();
    }

    public double getGpa() {return gpa;}
    public void setGpa(double gpa) {
        if(gpa <= 4.0 && gpa >= 0.0) {
            this.gpa = gpa;
        } else {
            System.out.println("In correct GPA Must be between 0.0 and 4.0");
        }
    }
    public int getLevel() {return level;}
    public void setLevel(int level) {
        if(level<=4&&level>=1){
            this.level = level;
        } else { 
            System.out.println("In correct LEVEL Must be between 1 and 4 "); 
        }
    }

    public List<Course> getEnrolledCourses() {return new ArrayList<>(enrolledCourses);}
    public void setEnrolledCourses(List<Course> enrolledCourses) {this.enrolledCourses = new ArrayList<>(enrolledCourses);}

    public void viewGrades() {
        System.out.println("Viewing grades for " + getFirstName() + " " + getLastName() + ":");
        if (enrolledCourses.isEmpty()) {
            System.out.println("  No courses enrolled ");
            return;
        }
        for (Course course : enrolledCourses) {
            System.out.println("  - " + course.getCourseName() + ": Grade Not Available (Placeholder)");
        }
    }
    
    public void registerCourse(Course course) {
        if (course != null && !enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudentInternal(this);
            System.out.println(getFirstName() + " " + getLastName() + " registered for course: " + course.getCourseName());
        } else {
            System.out.println("Failed to register " + getFirstName() + " " + getLastName() + " for course: " + (course != null ? course.getCourseName() : "null"));
        }
    }
    @Override
    public void viewProfile(){
        System.out.println("Student Profile ");
        System.out.println(" Id : " + getId());
        System.out.println(" First Name: " + getFirstName());
        System.out.println(" Last Name: " + getLastName());
        System.out.println(" Middle Name: " + (getMiddleName().isEmpty() ? "N/A" : getMiddleName()));
        System.out.println(" Address: " + getAddress());
        System.out.println(" Age: " + getAge());
        System.out.println(" Email : " + getEmail());
        System.out.println(" GPA : " + gpa);
        System.out.println(" Level : " + level);
    }

    @Override
    public String toString() {
        return "Student {"+ super.toString()+ ", gpa=" + gpa + ", level=" + level ; 
    }  
}
