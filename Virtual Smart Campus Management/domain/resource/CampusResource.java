package com.mycompany.OOP_Project.domain.resource;

import com.mycompany.OOP_Project.util.interfaces.Reservable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class CampusResource implements Reservable {
    protected String resourceId;
    protected String location;
    protected int capacity;
    protected List<TimeSlot> reservations; 

    public CampusResource(String resourceId, String location, int capacity) {
        this.resourceId = resourceId;
        this.location = location;
        this.capacity = capacity;
        this.reservations = new ArrayList<>();
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean reserve(Date startTime, Date endTime) {
        TimeSlot newReservation = new TimeSlot(startTime, endTime);
        for (TimeSlot existingReservation : reservations) {
            if (newReservation.overlaps(existingReservation)) {
                System.out.println("Reservation failed for " + resourceId + ": Time slot conflict.");
                return false; 
            }
        }
        
        reservations.add(newReservation);
        System.out.println("Reservation successful for " + resourceId + " from " + startTime + " to " + endTime);
        return true;
    }

    @Override
    public List<TimeSlot> getAvailability() {
        System.out.println("Fetching booked slots for " + resourceId + ". Note: This shows booked, not free slots.");
        return new ArrayList<>(reservations); 
    }
    
    @Override
    public String toString() {
        return "CampusResource{" +
               "resourceId='" + resourceId + "', location='" + location + "', capacity=" + capacity +
               ", reservations=" + reservations.size() +
               "}";
    }
}
