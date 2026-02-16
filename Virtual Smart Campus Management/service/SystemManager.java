package com.mycompany.OOP_Project.service;

import com.mycompany.OOP_Project.domain.person.Instructor;
import com.mycompany.OOP_Project.domain.person.Person;
import com.mycompany.OOP_Project.domain.person.Student;
import com.mycompany.OOP_Project.domain.person.Staff;
import com.mycompany.OOP_Project.domain.academic.Course;
import com.mycompany.OOP_Project.domain.resource.Room;
import com.mycompany.OOP_Project.domain.resource.Lab;
import java.util.ArrayList;

public class SystemManager {
    private static SystemManager instance;
    private ArrayList<Person> people;
    private ArrayList<Course> courses;
    private ArrayList<Room> rooms;
    private ArrayList<Lab> labs;
    

    private SystemManager() {
        people = new ArrayList<>();
        courses = new ArrayList<>();
        rooms = new ArrayList<>();
        labs = new ArrayList<>();
    }
    
  
    public static SystemManager getInstance() {
        if (instance == null) {
            instance = new SystemManager();
        }
        return instance;
    }
    

    public ArrayList<Person> getPeople() { return people; }
    public ArrayList<Course> getCourses() { return courses; }
    public ArrayList<Room> getRooms() { return rooms; }
    public ArrayList<Lab> getLabs() { return labs; }
    

    public Person findPerson(String email) {
        for (Person person : people) {
            if (person.getEmail().equals(email)) {
                return person;
            }
        }
        System.out.println("Person not found");
        return null;
    }
    

    public Student findStudent(String email) {
        for (Person person : people) {
            if (person instanceof Student && person.getEmail().equals(email)) {
                return (Student) person;
            }
        }
        System.out.println("Student not found");
        return null;
    }
    

    public Instructor findInstructor(String email) {
        for (Person person : people) {
            if (person instanceof Instructor && person.getEmail().equals(email)) {
                return (Instructor) person;
            }
        }
        System.out.println("Instructor not found");
        return null;
    }
    

    public Course findCourse(String code) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(code)) {
                return course;
            }
        }
        System.out.println("Course not found");
        return null;
    }
    

    public Room findRoom(String id) {
        for (Room room : rooms) {
            if (room.getResourceId().equals(id)) {
                return room;
            }
        }
        System.out.println("Room not found");
        return null;
    }
    
  
    public Lab findLab(String id) {
        for (Lab lab : labs) {
            if (lab.getResourceId().equals(id)) {
                return lab;
            }
        }
        System.out.println("Lab not found");
        return null;
    }

    public boolean personExists(String email) {
        for (Person person : people) {
            if (person.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    

    public boolean addPerson(Person person) {
        if (person == null) return false;
        
        if (!personExists(person.getEmail())) {
            people.add(person);
            return true;
        } else {
            System.out.println("This email is already registered");
            return false;
        }
    }
    

    public void addCourse(Course course) {
        if (course != null) {
            courses.add(course);
        }
    }
    
 
    public void addRoom(Room room) {
        if (room != null) {
            rooms.add(room);
        }
    }
    

    public void addLab(Lab lab) {
        if (lab != null) {
            labs.add(lab);
        }
    }
    
  
    public void removePerson(Person person) {
        if (person != null) {
            people.remove(person);
        }
    }

    public void removeCourse(Course course) {
        if (course != null) {
            courses.remove(course);
        }
    }
}
