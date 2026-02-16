package com.mycompany.OOP_Project.ui;

import com.mycompany.OOP_Project.service.CourseManager;
import com.mycompany.OOP_Project.service.PersonService;
import com.mycompany.OOP_Project.service.ResourceManager;
import com.mycompany.OOP_Project.service.SchedulerUI;
import com.mycompany.OOP_Project.service.SystemManager;
import java.util.Scanner;

public class UserInterface {
    private  Scanner scanner = new Scanner(System.in);
    private  SystemManager systemManager = SystemManager.getInstance();
    public void start() {
        System.out.println("Welcome to Virtual Smart Campus Management System");        
        while (true) {
            showMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt(); scanner.nextLine(); 
            handleMenuChoice(choice);
        }
    }   
    private void showMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1) Register Person");
        System.out.println("2) Login");
        System.out.println("3) Create Course");
        System.out.println("4) Assign Instructor to Course");
        System.out.println("5) Add Student to Course");
        System.out.println("6) View Course Details");
        System.out.println("7) View People");
        System.out.println("8) Add Room");
        System.out.println("9) Add Lab");
        System.out.println("10) Schedule Course in Room");
        System.out.println("11) Schedule Room/Lab");
        System.out.println("12) Add Equipment to Lab");
        System.out.println("13) View Reservations");
        System.out.println("14) Manage Records");
        System.out.println("15) Unenroll/Reassign");
        System.out.println("16) Exit");
    }
    private void handleMenuChoice(int choice) {
        switch (choice) {
            case 1: PersonService.registerPerson(); break;
            case 2: PersonService.login(); break;
            case 3: CourseManager.createCourse(); break;
            case 4: CourseManager.assignInstructorToCourse(); break;
            case 5: CourseManager.addStudentToCourse(); break;
            case 6: CourseManager.viewCourses(); break;
            case 7: PersonService.viewPeople(); break;
            case 8: ResourceManager.addRoom(); break;
            case 9: ResourceManager.addLab(); break;
            case 10: SchedulerUI.scheduleCourseInRoom(); break;
            case 11: SchedulerUI.scheduleRoomOrLab(); break;
            case 12: ResourceManager.addEquipmentToLab(); break;
            case 13: ResourceManager.viewReservations(); break;
            case 14: manageRecords(); break;
            case 15: handleUnenrollReassign(); break;
            case 16: exitProgram(); break;
            default: System.out.println("Please choose one of the available options");
        }
    }
    
 
    private void manageRecords() {
        System.out.println("1) Edit Person");
        System.out.println("2) Delete Person");
        System.out.println("3) Edit Course");
        System.out.println("4) Delete Course");
        System.out.println("5) Back");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1: PersonService.editPerson(); break;
            case 2: PersonService.deletePerson(); break;
            case 3: CourseManager.editCourse(); break;
            case 4: CourseManager.deleteCourse(); break;
            case 5: return;
            default: System.out.println("Please choose one of the available options");
        }
    }
    private void handleUnenrollReassign() {
        System.out.println("1) Unenroll Student from Course");
        System.out.println("2) Reassign Course to Instructor");
        System.out.println("3) Back");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1: CourseManager.unenrollStudent(); break;
            case 2: CourseManager.reassignCourse(); break;
            case 3: return;
            default: System.out.println("Please choose one of the available options");
        }
    }
   
    private void exitProgram() {
        System.out.println("Log out ");
        System.exit(0);
    }
}
