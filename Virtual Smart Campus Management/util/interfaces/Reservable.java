package com.mycompany.OOP_Project.util.interfaces;

import java.util.Date; 
import java.util.List;
import com.mycompany.OOP_Project.domain.resource.TimeSlot;

public interface Reservable {
    boolean reserve(Date startTime, Date endTime);
    List<TimeSlot> getAvailability();
}
