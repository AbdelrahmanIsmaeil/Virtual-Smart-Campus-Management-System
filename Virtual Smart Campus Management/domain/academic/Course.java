 package com.mycompany.OOP_Project.domain.academic;

import com.mycompany.OOP_Project.domain.person.Instructor;
import com.mycompany.OOP_Project.domain.person.Student;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String CourseCode;
    private String CourseName;
    private String description;
    private Instructor instructor;
    private List<Student> students;

    public Course(String CourseCode, String CourseName, String description) {
        this.CourseCode = CourseCode;
        this.CourseName = CourseName;
        this.description = description != null ? description : "No description provided";
        this.students = new ArrayList<>();
    }

    public String getCourseCode() { return CourseCode;}
    public void setCourseCode(String CourseCode) {this.CourseCode = CourseCode; }

    public String getCourseName() {return CourseName;}
    public void setCourseName(String CourseName) {this.CourseName = CourseName;}

    public String getDescription() {return description;}
    public void setDescription(String description) { this.description = description;}
    
    public Instructor getInstructor() {return instructor;}
    public void setInstructor(Instructor instructor) {this.instructor = instructor;}

    public List<Student> getStudents() { return new ArrayList<>(students);}

    public void addStudent(Student student) {
        if (student != null && !students.contains(student)) {
            students.add(student);
            System.out.println("Added student " + student.getFirstName() + " " + student.getLastName() + " to course " + CourseName);
        }
    }

    public void addStudentInternal(Student student) {
        if (student != null && !students.contains(student)) {
            students.add(student);
        }
    }

    public void assignInstructor(Instructor instructor) {
        if (instructor != null) {
            this.instructor = instructor;
            instructor.addCourseInternal(this);
            System.out.println("Assigned instructor " + instructor.getFirstName() + " " + instructor.getLastName() + " to course " + CourseName);
        }
    }
    
    @Override
    public String toString() {
        return "Course Code: " + CourseCode +
               "\nCourse Name: " + CourseName +
               "\nDescription: " + description +
               "\nInstructor: " + (instructor != null ? instructor.getFirstName() + " " + instructor.getLastName() : "Not Assigned") +
               "\nNumber of Students: " + students.size();
    }
}
