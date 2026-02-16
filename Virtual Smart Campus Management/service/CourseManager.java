package com.mycompany.OOP_Project.service;

import com.mycompany.OOP_Project.domain.academic.Course;
import com.mycompany.OOP_Project.domain.person.Instructor;
import com.mycompany.OOP_Project.domain.person.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseManager {
    private static Scanner scanner = new Scanner(System.in);
    private static SystemManager systemManager = SystemManager.getInstance();
    
    public static Course createCourse() {
        System.out.println("Enter course code: ");
        String code = scanner.nextLine();
        System.out.println("Enter course Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter course description: ");
        String description = scanner.nextLine();
        
        Course course = new Course(code, name, description);
        systemManager.addCourse(course);
        System.out.println("Course created successfully");
        return course;
    }
 
    public static void assignInstructorToCourse() {
        System.out.println("Enter course code: ");
        String courseCode = scanner.nextLine();
        Course selectedCourse = systemManager.findCourse(courseCode);
        if (selectedCourse == null) {
            return;
        }
        
        System.out.println("Enter instructor email:");
        String instructorEmail = scanner.nextLine();
        if (!PersonService.isValidEmail(instructorEmail)) {
            System.out.println("The email address format is incorrect");
            return;
        }

        Instructor selectedInstructor = systemManager.findInstructor(instructorEmail);
        if (selectedInstructor != null) {
            selectedCourse.assignInstructor(selectedInstructor);
            System.out.println("Instructor assigned successfully");
            selectedInstructor.sendNotification("You have been assigned to teach " + selectedCourse.getCourseName());
        } else {
            System.out.println("Instructor not found");
        }
    }
    
    public static void addStudentToCourse() {
        System.out.println("Enter course code:");
        String cCode = scanner.nextLine();
        Course targetCourse = systemManager.findCourse(cCode);
        if (targetCourse == null) {
            return;
        }
        
        System.out.println("Enter student email:");
        String studentEmail = scanner.nextLine();
        if (!PersonService.isValidEmail(studentEmail)) {
            System.out.println("The email address format is incorrect");
            return;
        }
        
        Student targetStudent = systemManager.findStudent(studentEmail);
        if (targetStudent != null) {
            targetStudent.registerCourse(targetCourse);
            System.out.println("Student added successfully");
            targetStudent.sendNotification("You have been added to the course: " + targetCourse.getCourseName());
        } else {
            System.out.println("Student not found");
        }
    }
    
    public static void viewCourses() {
        List<Course> courses = systemManager.getCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses available");
        } else {
            for (Course course : courses) {
                System.out.println(course);
                System.out.println("Enrolled Students:");
                List<Student> students = course.getStudents();
                if (students.isEmpty()) {
                    System.out.println("  None");
                } else {
                    for (Student student : students) {
                        System.out.println("  - " + student.getFirstName() + " " + student.getLastName());
                    }
                }
            }
        }
    }
    
    public static void editCourse() {
        System.out.println("Enter course code:");
        String code = scanner.nextLine();
        Course course = systemManager.findCourse(code);
        if (course == null) {
            return;
        }
        
        System.out.println("Enter new course code:");
        course.setCourseCode(scanner.nextLine());
        System.out.println("Enter new course name:");
        course.setCourseName(scanner.nextLine());
        System.out.println("Enter new course description:");
        course.setDescription(scanner.nextLine());
        System.out.println("Course updated successfully");
    }
    

    public static void deleteCourse() {
        System.out.println("Enter course code:");
        String code = scanner.nextLine();
        Course course = systemManager.findCourse(code);
        if (course == null) {
            return;
        }
        
        for (Student student : course.getStudents()) {
            student.getEnrolledCourses().remove(course);
            student.sendNotification("Course " + course.getCourseName() + " has been deleted");
        }
        
        if (course.getInstructor() != null) {
            course.getInstructor().getTeachingCourses().remove(course);
            course.getInstructor().sendNotification("Course " + course.getCourseName() + " has been deleted");
        }
        
        systemManager.removeCourse(course);
        System.out.println("Course deleted successfully");
    }
    
    public static void unenrollStudent() {
        System.out.println("Enter student email:");
        String studentEmail = scanner.nextLine();
        Student student = systemManager.findStudent(studentEmail);
        if (student == null) return;
        
        System.out.println("Enter course code:");
        String courseCode = scanner.nextLine();
        Course course = systemManager.findCourse(courseCode);
        if (course == null) return;
        
        if (course.getStudents().contains(student)) {
            student.getEnrolledCourses().remove(course);
            course.getStudents().remove(student);
            student.sendNotification("You have been unenrolled from " + course.getCourseName());
            System.out.println("Student unenrolled successfully");
        } else {
            System.out.println("Student not enrolled in this course");
        }
    }
    
    public static void reassignCourse() {
        System.out.println("Enter course code:");
        String courseCode = scanner.nextLine();
        Course course = systemManager.findCourse(courseCode);
        if (course == null) return;
        
        System.out.println("Enter new instructor email:");
        String instructorEmail = scanner.nextLine();
        Instructor newInstructor = systemManager.findInstructor(instructorEmail);
        if (newInstructor == null) return;
        
        Instructor oldInstructor = course.getInstructor();
        course.setInstructor(newInstructor);
        
        if (oldInstructor != null) {
            oldInstructor.getTeachingCourses().remove(course);
            oldInstructor.sendNotification("You have been removed from teaching " + course.getCourseName());
        }
        
        newInstructor.addCourseInternal(course);
        newInstructor.sendNotification("You have been assigned to teach " + course.getCourseName());
        System.out.println("Course reassigned successfully");
    }
}
