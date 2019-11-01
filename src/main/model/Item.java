package model;

import exceptions.NotSameDay;

import java.util.ArrayList;
import java.util.List;

public abstract class Item {

    protected boolean isEvent;
    protected String date;
    protected String activity;
    protected int time;
    protected int duration;
    protected int end;
    protected boolean weatherSensitive;

    private List<Flag> flags = new ArrayList<>();

    public Item() {
        date = "Monday";
        activity = "interview";
        this.isEvent = true;
        this.time = 10;
        this.duration = 5;
        this.end = 15;
        this.weatherSensitive = false;
    }

    //EFFECTS: Returns the details of the item
    public abstract String returnItemDetails();

    //MODIFIES: this
    //EFFECTS: update isEvent status of item
    public void setIsEvent(boolean x) {
        this.isEvent = x;
    }

    //MODIFIES: this
    //EFFECTS: update date of item
    public void setDate(String x) {
        this.date = x;
    }

    //MODIFIES: this
    //EFFECTS: update name of item
    public void setActivity(String x) {
        this.activity = x;
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

    //EFFECTS: returns isEvent
    public boolean getIsEvent() {
        return isEvent;
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

    //EFFECTS: returns the boolean value of whether the item is weather sensitive
    public Boolean getWeatherSensitive() {
        return weatherSensitive;
    }

    //MODIFIES: This
    //EFFECTS: Update the end time of event
    public void setCalculatedEnd() throws NotSameDay {
        int endTime;
        endTime = this.time + this.duration;
        if (endTime > 24) {
            this.end = endTime - ((endTime / 24) * 24);
            throw new NotSameDay();
        } else {
            this.end = endTime;
        }
    }

    public void addFlag(Flag f) {
        if (!flags.contains(f)) {
            flags.add(f);
            f.addItem(this);
        }
    }

    public void removeFlag(Flag f) {
        if (flags.contains(f)) {
            flags.remove(f);
            f.removeItem(this);
        }
    }
}

