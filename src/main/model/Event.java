package model;

import java.util.*;

public class Event extends Item {

    public Event() {
        super();
    }

    //MODIFIES: this
    //EFFECTS: update the start time of item
    public void setTime(int x) {
        this.time = x;
    }

    //MODIFIES: this
    //EFFECTS: update the duration of item
    public void setDuration(int x) {
        this.duration = x;
    }

    //MODIFIES: this
    //EFFECTS: update the end time of item
    public void setEnd(int x) {
        this.end = x;
    }

    //MODIFIES: this
    //EFFECTS: update category of item
    public void setWeatherSensitive(Boolean x) {
        this.weatherSensitive = x;
    }

    //EFFECTS: returns time
    public int getTime() {
        return time;
    }

    //EFFECTS: returns duration
    public int getDuration() {
        return duration;
    }

    //EFFECTS: returns end time
    public int getEnd() {
        return end;
    }

    //EFFECTS: returns the boolean value of whether the item is weather sensitive
    public Boolean getWeatherSensitive() {
        return weatherSensitive;
    }

    //EFFECTS: Returns the details of the Event
    @Override
    public String returnItemDetails() {
        String message;
        message = " '" + this.activity + "'" + " scheduled on " + this.date + " from "
                + this.time + " to " + this.end;
        return message;
    }
}
