package com.mycompany.OOP_Project.service;

import com.mycompany.OOP_Project.domain.resource.Lab;
import com.mycompany.OOP_Project.domain.resource.Room;
import java.util.ArrayList;
import java.util.Scanner;

public class ResourceManager {
    private static Scanner scanner = new Scanner(System.in);
    private static SystemManager systemManager = SystemManager.getInstance();
    
    public static Room addRoom() {
        System.out.println("Enter room ID:");
        String id = scanner.nextLine();
        System.out.println("Enter location:");
        String loc = scanner.nextLine();
        System.out.println("Enter capacity:");
        int cap = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter room type:");
        String type = scanner.nextLine();

        Room room = new Room(id, loc, cap, type);
        systemManager.addRoom(room);
        System.out.println("Room added successfully");
        return room;
    }
    
    public static Lab addLab() {
        System.out.println("Enter lab ID:");
        String id = scanner.nextLine();
        System.out.println("Enter location:");
        String loc = scanner.nextLine();
        System.out.println("Enter capacity:");
        int cap = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter lab type:");
        String type = scanner.nextLine();

        Lab lab = new Lab(id, loc, cap, type, new ArrayList<>());
        systemManager.addLab(lab);
        System.out.println("Lab added successfully");
        return lab;
    }

    public static void addEquipmentToLab() {
        System.out.println("Enter lab ID:");
        String id = scanner.nextLine();
        Lab lab = systemManager.findLab(id);
        if (lab == null) {
            return;
        }

        System.out.println("Enter equipment name:");
        String eq = scanner.nextLine();
        lab.addEquipment(eq);
    }
    
    public static void viewReservations() {
        System.out.println("Enter room or lab:");
        String type = scanner.nextLine().trim().toLowerCase();
        System.out.println("Enter resource ID:");
        String id = scanner.nextLine();

        if (type.equals("room")) {
            Room room = systemManager.findRoom(id);
            if (room != null) {
                System.out.println("Booked slots for room " + id + ":");
                room.getAvailability().forEach(System.out::println);
            }
        } else if (type.equals("lab")) {
            Lab lab = systemManager.findLab(id);
            if (lab != null) {
                System.out.println("Booked slots for lab " + id + ":");
                lab.getAvailability().forEach(System.out::println);
            }
        } else {
            System.out.println("Wrong input type");
        }
    }
}
