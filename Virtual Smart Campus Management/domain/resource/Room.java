package com.mycompany.OOP_Project.domain.resource;

public class Room extends CampusResource {
    private String roomType; 
    
    public Room(String resourceId, String location, int capacity, String roomType) {
        super(resourceId, location, capacity);
        this.roomType = roomType;
    }
    
    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
    
    @Override
    public String toString() {
        return "Room{" +
               "resourceId= " + resourceId + ", location=" + location + ", capacity=" + capacity +
               ", type= " + roomType + ", reservations= " + reservations.size() + "}";
    }
}
