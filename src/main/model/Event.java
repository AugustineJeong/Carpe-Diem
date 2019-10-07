package model;

import java.util.*;

public class Event {

    private String category;
    private String date;
    private String activity;
    private int time;
    private int duration;
    private int end;
    private boolean weatherSensitive;

    public Event() {
        category = "work";
        date = "Monday";
        activity = "interview";
        time = 1400;
        duration = 60;
        end = 1500;
        weatherSensitive = false;
    }

    //EFFECTS: Returns the details of the event
    public String returnEventDetails() {
        String message;
        message = " " + this.category + " | " + "'" + this.activity + "'" +  " scheduled on " + this.date + " from "
                + this.time + " to " + this.end;
        return message;
    }

    //MODIFIES: this
    //EFFECTS: update category of event
    public void setCategory(String x) {
        this.category = x;
    }

    //MODIFIES: this
    //EFFECTS: update date of event
    public void setDate(String x) {
        this.date = x;
    }

    //MODIFIES: this
    //EFFECTS: update name of event
    public void setActivity(String x) {
        this.activity = x;
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

    //EFFECTS: returns category
    public String getCategory() {
        return category;
    }

    //EFFECTS: returns date
    public String getDate() {
        return date;
    }

    //EFFECTS: returns activity

    public String getActivity() {
        return activity;
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
