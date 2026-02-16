package com.mycompany.OOP_Project.domain.resource;

import java.util.List;

public class Lab extends CampusResource {
    private String labType; 
    private List<String> equipment; 

    public Lab(String resourceId, String location, int capacity, String labType, List<String> equipment) {
        super(resourceId, location, capacity);
        this.labType = labType;
        this.equipment = equipment;
    }
    
    public String getLabType() {return labType;}
    public void setLabType(String labType) {this.labType = labType; }
    
    public List<String> getEquipment() {  return equipment; }
    public void setEquipment(List<String> equipment) {this.equipment = equipment; }

    public void addEquipment(String equipmentItem) {
        if (equipmentItem != null && !equipmentItem.isEmpty()) {
            equipment.add(equipmentItem);
            System.out.println("Added equipment " + equipmentItem + " to lab " + resourceId);
        }
    }
    
    @Override
    public String toString() {
        return "Lab{" +
               "resourceId= " + resourceId + " , location= " + location + " , capacity= " + capacity +
               " , type= " + labType + " , equipment= " + equipment.size() +
               ", reservations= " + reservations.size() + "}";
    }
}
