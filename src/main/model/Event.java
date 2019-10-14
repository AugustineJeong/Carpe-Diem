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
}
