package model.item;

import ui.gui.observer.Observable;
import ui.gui.observer.Observer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Event extends Item implements Observable {

    private int time;
    private int duration;
    private int end;
    private boolean weatherSensitive;

    private List<Observer> observerList = new ArrayList<>();

    //constructor: creates an Event object
    //MODIFIES: this
    public Event() {
        super();
        this.isEvent = true;
        this.time = 0;
        this.end = 0;
        this.weatherSensitive = false;
    }

    //EFFECTS: Returns the details of the item
    public String returnItemDetails() {
        String message;

        message = " '" + this.activity + "'" + " on " + this.date;


        if (this.isEvent) {
            message = message + " from "
                    + timeFormatHelper(this.time) + " to " + timeFormatHelper(this.end);
        }
        return message;
    }

    private String timeFormatHelper(int time) {
        int hour = time / 100;
        int minute = time % 100;
        String hourString = "" + hour;
        String minuteString = "" + minute;
        if (hour < 10) {
            hourString = "0" + hour;
        }
        if (minute == 0) {
            minuteString = "0" + minute;
        }
        String formattedTime = hourString + ":" + minuteString;

        return formattedTime;
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

    //MODIFIES: This
    //EFFECTS: Update the end time of event
    public void setCalculatedEnd() {
        int endTime;
        endTime = this.time + (this.duration * 100);
        if (endTime >= 2400) {
            this.end = endTime % 2400;
            setCalculatedEndDateHelper(endTime);
            System.out.println("Warning: Your activity does not end on the day it starts.");
        } else {
            this.end = endTime;
        }
    }

    private void setCalculatedEndDateHelper(int endTime) {
        int dayNum = 0;
        if (this.date.equals("Monday")) {
            dayNum = 1;
        } else if (this.date.equals("Tuesday")) {
            dayNum = 2;
        } else if (this.date.equals("Wednesday")) {
            dayNum = 3;
        } else if (this.date.equals("Thursday")) {
            dayNum = 4;
        } else if (this.date.equals("Friday")) {
            dayNum = 5;
        } else if (this.date.equals("Saturday")) {
            dayNum = 6;
        } else if (this.date.equals("Sunday")) {
            dayNum = 7;
        }

        setCalculatedEndDateHelpersHelper(dayNum, endTime);
    }

    private void setCalculatedEndDateHelpersHelper(int dayNum, int endTime) {
        dayNum = (dayNum + (endTime / 2400)) % 7;

        String endDay = "Sunday";
        if (dayNum == 1) {
            endDay = "Monday";
        } else if (dayNum == 2) {
            endDay = "Tuesday";
        } else if (dayNum == 3) {
            endDay = "Wednesday";
        } else if (dayNum == 4) {
            endDay = "Thursday";
        } else if (dayNum == 5) {
            endDay = "Friday";
        } else if (dayNum == 6) {
            endDay = "Saturday";
        }

        notifyObserver(22, endDay);
    }


    @Override
    public void addObserver(Observer observer) {
        if (!this.observerList.contains(observer)) {
            this.observerList.add(observer);
        }
    }

    @Override
    public void notifyObserver(int i, Object o) {
        for (Observer observer : this.observerList) {
            observer.update(i, o);
        }
    }
}
