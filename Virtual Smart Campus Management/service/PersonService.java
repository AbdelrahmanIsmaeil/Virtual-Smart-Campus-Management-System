package com.mycompany.OOP_Project.service;

import com.mycompany.OOP_Project.domain.person.Instructor;
import com.mycompany.OOP_Project.domain.person.Person;
import com.mycompany.OOP_Project.domain.person.Staff;
import com.mycompany.OOP_Project.domain.person.Student;
import com.mycompany.OOP_Project.domain.academic.Course;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonService {
    private static Scanner scanner = new Scanner(System.in);
    private static SystemManager systemManager = SystemManager.getInstance();
    
    public static Person createPerson(String type) {
        System.out.println("Registration..."); 
        System.out.println("Enter your Id");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter Middle Name Optional :");
        String middleName = scanner.nextLine();
        System.out.println("Enter Address:");
        String address = scanner.nextLine();
        System.out.println("Enter Age:");
        int age = scanner.nextInt(); scanner.nextLine();
        System.out.println("Enter your Email");
        String email = scanner.nextLine();
        if (!isValidEmail(email)) {
            System.out.println("The email address format is incorrect");
            return null;
        }
        System.out.println("Enter your password");
        String pass = scanner.nextLine();
       
        if (type.equalsIgnoreCase("student")) {
            if (age < 18) {
                System.out.println("Age must be at least 18 for students");
                return null;
            }
            System.out.println("Enter GPA:");
            double gpa = scanner.nextDouble(); scanner.nextLine();
            System.out.println("Enter Level:");
            int level = scanner.nextInt(); scanner.nextLine();
            return new Student(id, firstName, lastName, middleName, address, age, email, pass, gpa, level);
        } else if (type.equalsIgnoreCase("instructor")) {
            if (age < 24) {
                System.out.println("Age must be at least 24 for instructors");
                return null;
            }
            System.out.println("Enter Department:");
            String depart = scanner.nextLine();
            return new Instructor(id, firstName, lastName, middleName, address, age, email, pass, depart);
        } else if (type.equalsIgnoreCase("staff")) {
            if (age < 24) {
                System.out.println("Age must be at least 24 for staff");
                return null;
            }
            System.out.println("Enter Department:");
            String depart = scanner.nextLine();
            System.out.println("Enter Job Title:");
            String jobTitle = scanner.nextLine();
            return new Staff(id, firstName, lastName, middleName, address, age, email, pass, depart, jobTitle);
        }
        System.out.println("Unknown person type. Please enter student, instructor, or staff");
        return null;   
    }
    
    public static boolean registerPerson() {
        System.out.println("Enter person type student or instructor or staff : ");
        String type = scanner.nextLine().trim();
        Person p = createPerson(type);
        if (p != null) {
            if (systemManager.addPerson(p)) {
                System.out.println(type + " registered successfully");
                p.sendNotification("Welcome to the system, " + p.getFirstName() + " " + p.getLastName() + "!");
                return true;
            }
        }
        return false;
    }
    
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        if (!email.contains("@") || !email.contains(".")) {
            return false;
        }
        if (email.indexOf('@') <= 0 || email.indexOf('@') >= email.length() - 1) {
            return false;
        }
        int dotIndex = email.indexOf('.', email.indexOf('@'));
        if (dotIndex < email.indexOf('@') + 2 || dotIndex >= email.length() - 1) {
            return false;
        }
        return true;
    }

    public static Person login() {
        System.out.println("Enter Email:");
        String email = scanner.nextLine();
        if (!isValidEmail(email)) {
            System.out.println("The email address format is incorrect");
            return null;
        }
        System.out.println("Enter Password:");
        String pass = scanner.nextLine();

        for (Person person : systemManager.getPeople()) {
            if (person.getEmail().equals(email) && person.getPass().equals(pass)) {
                System.out.println("Login successful");
                person.viewProfile();
                return person;
            }
        }
        System.out.println("Invalid email or password");
        return null;
    }

    public static void viewPeople() {
        ArrayList<Person> people = systemManager.getPeople();
        if (people.isEmpty()) {
            System.out.println("No people registered");
        } else {
            for (Person person : people) {
                System.out.println(person);
                if (person instanceof Student) {
                    Student student = (Student) person;
                    System.out.println("Enrolled Courses:");
                    if (student.getEnrolledCourses().isEmpty()) {
                        System.out.println("  None");
                    } else {
                        for (Course course : student.getEnrolledCourses()) {
                            System.out.println("  - " + course.getCourseName());
                        }
                    }
                } else if (person instanceof Instructor) {
                    Instructor instructor = (Instructor) person;
                    System.out.println("Teaching Courses:");
                    if (instructor.getTeachingCourses().isEmpty()) {
                        System.out.println("  None");
                    } else {
                        for (Course course : instructor.getTeachingCourses()) {
                            System.out.println("  - " + course.getCourseName());
                        }
                    }
                }
            }
        }
    }
    
    public static void editPerson() {
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        Person person = systemManager.findPerson(email);
        if (person == null) {
            return;
        }
        
        if (person instanceof Student) {
            editStudent((Student) person);
        } else if (person instanceof Instructor) {
            editInstructor((Instructor) person);
        } else if (person instanceof Staff) {
            editStaff((Staff) person);
        }
    }

    private static void editStudent(Student student) {
        System.out.println("Enter new First Name:");
        student.setFirstName(scanner.nextLine());
        System.out.println("Enter new Last Name:");
        student.setLastName(scanner.nextLine());
        System.out.println("Enter new Middle Name (Optional):");
        student.setMiddleName(scanner.nextLine());
        System.out.println("Enter new Address:");
        student.setAddress(scanner.nextLine());
        System.out.println("Enter new Age (minimum 18):");
        int age = scanner.nextInt();
        scanner.nextLine();
        if (age >= 18) {
            student.setAge(age);
        } else {
            System.out.println("Age must be at least 18");
            return;
        }
        System.out.println("Enter new Email:");
        String newEmail = scanner.nextLine();
        if (isValidEmail(newEmail)) {
            student.setEmail(newEmail);
        }
        System.out.println("Enter new GPA:");
        student.setGpa(scanner.nextDouble());
        scanner.nextLine();
        System.out.println("Enter new Level:");
        student.setLevel(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Student updated successfully");
    }
    
   
    private static void editInstructor(Instructor instructor) {
        System.out.println("Enter new First Name:");
        instructor.setFirstName(scanner.nextLine());
        System.out.println("Enter new Last Name:");
        instructor.setLastName(scanner.nextLine());
        System.out.println("Enter new Middle Name (Optional):");
        instructor.setMiddleName(scanner.nextLine());
        System.out.println("Enter new Address:");
        instructor.setAddress(scanner.nextLine());
        System.out.println("Enter new Age (minimum 24):");
        int age = scanner.nextInt();
        scanner.nextLine();
        if (age >= 24) {
            instructor.setAge(age);
        } else {
            System.out.println("Age must be at least 24");
            return;
        }
        System.out.println("Enter new Email:");
        String newEmail = scanner.nextLine();
        if (isValidEmail(newEmail)) {
            instructor.setEmail(newEmail);
        }
        System.out.println("Enter new Department:");
        instructor.setDepart(scanner.nextLine());
        System.out.println("Instructor updated successfully");
    }
    
    
    private static void editStaff(Staff staff) {
        System.out.println("Enter new First Name:");
        staff.setFirstName(scanner.nextLine());
        System.out.println("Enter new Last Name:");
        staff.setLastName(scanner.nextLine());
        System.out.println("Enter new Middle Name (Optional):");
        staff.setMiddleName(scanner.nextLine());
        System.out.println("Enter new Address:");
        staff.setAddress(scanner.nextLine());
        System.out.println("Enter new Age (minimum 24):");
        int age = scanner.nextInt();
        scanner.nextLine();
        if (age >= 24) {
            staff.setAge(age);
        } else {
            System.out.println("Age must be at least 24");
            return;
        }
        System.out.println("Enter new Email:");
        String newEmail = scanner.nextLine();
        if (isValidEmail(newEmail)) {
            staff.setEmail(newEmail);
        }
        System.out.println("Enter new Department:");
        staff.setDepartment(scanner.nextLine());
        System.out.println("Enter new Job Title:");
        staff.setJobTitle(scanner.nextLine());
        System.out.println("Staff updated successfully");
    }
    
 
    public static void deletePerson() {
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        Person person = systemManager.findPerson(email);
        if (person == null) {
            return;
        }
        
        if (person instanceof Student) {
            Student student = (Student) person;
            for (Course course : student.getEnrolledCourses()) {
                course.getStudents().remove(student);
            }
        } else if (person instanceof Instructor) {
            Instructor instructor = (Instructor) person;
            for (Course course : instructor.getTeachingCourses()) {
                course.setInstructor(null);
            }
        }
        
        systemManager.removePerson(person);
        System.out.println("Person deleted successfully");
        person.sendNotification("Your account has been deleted");
    }
}
