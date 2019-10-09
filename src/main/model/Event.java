package model;

import java.util.*;

public class Event extends Item {

    public Event() {
        super();
        this.isEvent = true;
        this.time = 10;
        this.duration = 5;
        this.end = 15;
        this.weatherSensitive = false;
    }

    //EFFECTS: Returns the details of the Event
    @Override
    public String returnItemDetails() {
        String message;
        message = " '" + this.activity + "'" +  " scheduled on " + this.date + " from "
                + this.time + " to " + this.end;
        return message;
    }

    //MODIFIES: this
    //EFFECTS: update the end time of event
    public void setCalculatedEnd() {
        int endTime;
        endTime = this.time + this.duration;
        if (endTime > 24) {
            this.end = endTime - ((endTime / 24) * 24);
        } else {
            this.end = endTime;
        }
    }
}
