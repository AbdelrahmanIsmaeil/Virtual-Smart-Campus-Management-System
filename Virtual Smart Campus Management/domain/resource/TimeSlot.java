package com.mycompany.OOP_Project.domain.resource;

import java.util.Date;

public class TimeSlot {
    private Date startTime;
    private Date endTime;

    public TimeSlot(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Date getStartTime() { return startTime;}
    public Date getEndTime() {return endTime; }

    public boolean overlaps(TimeSlot other) {
        if (other == null) {
            return false;
        }
        return this.startTime.before(other.endTime) && this.endTime.after(other.startTime);
    }

    @Override
    public String toString() {
        return "TimeSlot{" + "startTime=" + startTime + ", endTime=" + endTime + '}';
    }
}
