package model;

import java.util.*;

public class Event extends Item {

    private int time;
    private int duration;
    private int end;
    private boolean weatherSensitive;

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
        message = " | " + "'" + this.activity + "'" +  " scheduled on " + this.date + " from "
                + this.time + " to " + this.end;
        return message;
    }

    //MODIFIES: this
    //EFFECTS: update the start time of event
    public void setTime(int x) {
        this.time = x;
    }

    //MODIFIES: this
    //EFFECTS: update the duration of event
    public void setDuration(int x) {
        this.duration = x;
    }

    //MODIFIES: this
    //EFFECTS: update the end time of event
    public void setEnd(int x) {
        this.end = x;
    }

    //MODIFIES: this
    //EFFECTS: update category of event
    public void setWeatherSensitive(Boolean x) {
        this.weatherSensitive = x;
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

    public Boolean getWeatherSensitive() {
        return weatherSensitive;
    }
}
