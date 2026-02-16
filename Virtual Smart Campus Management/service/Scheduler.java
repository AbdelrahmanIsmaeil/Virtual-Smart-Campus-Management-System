package com.mycompany.OOP_Project.service;

import com.mycompany.OOP_Project.domain.academic.Course;
import com.mycompany.OOP_Project.domain.person.Student;
import com.mycompany.OOP_Project.domain.resource.Lab;
import com.mycompany.OOP_Project.domain.resource.Room;
import java.util.Date;

public class Scheduler {

    private Scheduler() {
    }

    public static boolean scheduleCourse(Course course, Room room, Date startTime, Date endTime) {
        if (course == null || room == null) {
            System.out.println("Error: Course or room is null");
            return false;
        }

        boolean reserved = room.reserve(startTime, endTime);
        if (reserved) {
            System.out.println("Course " + course.getCourseName() + " scheduled in room "
                    + room.getResourceId() + " from " + startTime + " to " + endTime);

            if (course.getInstructor() != null) {
                course.getInstructor().sendNotification("Your course " + course.getCourseName()
                        + " has been scheduled in room " + room.getResourceId()
                        + " from " + startTime + " to " + endTime);
            }

            for (Student student : course.getStudents()) {
                student.sendNotification("Your course " + course.getCourseName()
                        + " has been scheduled in room " + room.getResourceId()
                        + " from " + startTime + " to " + endTime);
            }

            return true;
        } else {
            System.out.println("Failed to schedule course " + course.getCourseName()
                    + ": Room " + room.getResourceId() + " is not available at the requested time");
            return false;
        }
    }

    public static boolean scheduleRoom(Room room, Date startTime, Date endTime, String purpose) {
        if (room == null) {
            System.out.println("Error: Room is null");
            return false;
        }

        boolean reserved = room.reserve(startTime, endTime);
        if (reserved) {
            System.out.println("Room " + room.getResourceId() + " scheduled from "
                    + startTime + " to " + endTime + " for: " + purpose);
            return true;
        } else {
            System.out.println("Failed to schedule room " + room.getResourceId()
                    + " from " + startTime + " to " + endTime);
            return false;
        }
    }

    public static boolean scheduleLab(Lab lab, Date startTime, Date endTime, String purpose) {
        if (lab == null) {
            System.out.println("Error: Lab is null");
            return false;
        }

        boolean reserved = lab.reserve(startTime, endTime);
        if (reserved) {
            System.out.println("Lab " + lab.getResourceId() + " scheduled from "
                    + startTime + " to " + endTime + " for: " + purpose);
            return true;
        } else {
            System.out.println("Failed to schedule lab " + lab.getResourceId()
                    + " from " + startTime + " to " + endTime);
            return false;
        }
    }
}
