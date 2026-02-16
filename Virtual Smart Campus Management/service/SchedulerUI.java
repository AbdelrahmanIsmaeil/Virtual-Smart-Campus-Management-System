package com.mycompany.OOP_Project.service;
import com.mycompany.OOP_Project.domain.academic.Course;
import com.mycompany.OOP_Project.domain.resource.Lab;
import com.mycompany.OOP_Project.domain.resource.Room;
import java.util.Date;
import java.util.Scanner;
public class SchedulerUI {
    private static Scanner scanner = new Scanner(System.in);
    private static SystemManager systemManager = SystemManager.getInstance();
    
    public static void scheduleCourseInRoom() {
        System.out.println("Enter course code:");
        String cCode = scanner.nextLine();
        Course course = systemManager.findCourse(cCode);
        if (course == null) {
            return;
        }

        System.out.println("Enter room ID:");
        String rId = scanner.nextLine();
        Room room = systemManager.findRoom(rId);
        if (room == null) {
            return;
        }

        System.out.println("Enter start time (in milliseconds):");
        long start = scanner.nextLong();
        System.out.println("Enter end time (in milliseconds):");
        long end = scanner.nextLong();

        Date startTime = new Date(start);
        Date endTime = new Date(end);

        Scheduler.scheduleCourse(course, room, startTime, endTime);
    }
    public static void scheduleRoomOrLab() {
        System.out.println("Enter room or lab:");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.println("Enter resource ID:");
        String id = scanner.nextLine();

        System.out.println("Enter purpose:");
        String purpose = scanner.nextLine();

        System.out.println("Enter start time (in milliseconds):");
        long start = scanner.nextLong();
        System.out.println("Enter end time (in milliseconds):");
        long end = scanner.nextLong();
        Date startTime = new Date(start);
        Date endTime = new Date(end);

        if (type.equals("room")) {
            Room room = systemManager.findRoom(id);
            if (room != null) {
                Scheduler.scheduleRoom(room, startTime, endTime, purpose);
            }
        } else if (type.equals("lab")) {
            Lab lab = systemManager.findLab(id);
            if (lab != null) {
                Scheduler.scheduleLab(lab, startTime, endTime, purpose);
            }
        } else {
            System.out.println("Wrong input type");
        }
    }
}
