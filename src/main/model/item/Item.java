package model.item;


import model.marker.Flag;

import javax.swing.*;
import java.util.Objects;

public abstract class Item {

    protected boolean isEvent;
    protected String date;
    protected String activity;
    protected int time;
    protected int duration;
    protected int end;
    protected boolean weatherSensitive;

    private Flag flag;
    private boolean isFlagged;

    //MODIFIES: this
    public Item() {
        this.weatherSensitive = false;
    }

    //EFFECTS: Returns the details of the item
    public String returnItemDetails() {
        String message;

        if (this.isEvent) {
            message = " '" + this.activity + "'" + " on " + this.date;
        } else {
            message = " '" + this.activity + "'" + " by " + this.date;
        }

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
    public void setCalculatedEnd() {
        int endTime;
        endTime = this.time + (this.duration * 100);
        if (endTime > 2400) {
            int overTime = endTime / 2400;
            this.end = endTime - overTime % 2400;
            setCalculatedEndDateHelper(overTime);
            System.out.println("Warning: Your activity does not end on the day it starts.");
        } else {
            this.end = endTime;
        }
    }

    private void setCalculatedEndDateHelper(int overTime) {
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
        int overDays = overTime / 2400;
        setCalculatedEndDateHelpersHelper((dayNum + overDays) % 7, overTime);
    }

    private void setCalculatedEndDateHelpersHelper(int dayNum, int overTime) {
        String endDay = "Monday";
        if (dayNum == 1) {
            endDay = "Tuesday";
        } else if (dayNum == 2) {
            endDay = "Wednesday";
        } else if (dayNum == 3) {
            endDay = "Thursday";
        } else if (dayNum == 4) {
            endDay = "Friday";
        } else if (dayNum == 5) {
            endDay = "Saturday";
        } else if (dayNum == 6) {
            endDay = "Sunday";
        }
        //CITATION: Copied the following line from
        // https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
        JOptionPane.showMessageDialog(new JFrame(), "Warning: Your event does not end on the same day as "
                + "it starts. It ends on: " + endDay,  "WARNING", JOptionPane.WARNING_MESSAGE);
    }

    public Flag getFlag() {
        return this.flag;
    }

    //MODIFIES: this and flag parameter
    //EFFECTS: adds flag to the item
    public void addFlag(Flag f) {
        if (!this.isFlagged || !this.flag.equals(f)) {
            if (!this.isFlagged) {
                this.flag = f;
                f.addItem(this);
                this.isFlagged = true;
            } else {
                this.flag.removeItem(this);
                this.isFlagged = false;
                this.flag = f;
                this.isFlagged = true;
                f.addItem(this);
            }
        }
    }

    //MODIFIES: this and flag parameter
    //EFFECTS: removes flag from item and removes this item from flag's item list
    public void removeFlag() {
        if (this.isFlagged) {
            this.flag.removeItem(this);
            flag = null;
            this.isFlagged = false;
        }
    }

    //EFFECTS: returns true if the item is already flagged
    public Boolean isFlagged() {
        return this.isFlagged;
    }

    //EFFECTS: returns true if item is flagged by the passed flag parameter
    public Boolean containsFlag(Flag f) {
        if (!this.isFlagged) {
            return false;
        }
        return (this.flag.equals(f));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return isEvent == item.isEvent && time == item.time && date.equals(item.date)
                && activity.equals(item.activity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isEvent, date, activity, time);
    }
}


