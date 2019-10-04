package model;

import com.sun.org.apache.xpath.internal.operations.Bool;

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

    //MODIFIES: this and the EventList parameter
    //EFFECTS: configures event and stores it to EventList parameter
    public EventList setEvent(EventList events) {
        this.configureEvent();

        events.addEvent(this);

        System.out.println();
        System.out.println("Event '" + this.activity + "' " + "has been scheduled.");
        System.out.println();

        return events;
    }

    //MODIFIES: this
    //EFFECTS: configures the details of the event
    private void configureEvent() {
        Scanner scan = new Scanner(System.in);

        String response1;
        int response2;

        System.out.println("What would you like to categorize the event as?");
        response1 = scan.nextLine();
        this.setCategory(response1);

        System.out.println("What would you like to name the event?");
        response1 = scan.nextLine();
        this.setActivity(response1);

        System.out.println("What day is this event on?");
        response1 = scan.nextLine();
        this.setDate(response1);

        System.out.println("What time does this event start");
        response2 = scan.nextInt();
        this.setTime(response2);

        System.out.println("How long is this event?");
        response2 = scan.nextInt();
        this.setDuration(response2);
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
