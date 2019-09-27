package model;

import java.util.*;

public class Event {

    private String date;
    private String activity;
    private int time;
    private int duration;
    private int end;

    public Event() {
        date = "Monday";
        activity = "interview";
        time = 1400;
        duration = 60;
        end = 1500;
    }

    //EFFECTS: Returns the details of the event
    public String returnEvent() {
        String message;
        message = "'" + this.activity + "'" +  " scheduled on " + this.date + " from " + this.time + " to " + this.end;
        return message;
    }

    //MODIFIES: this and the EventList parameter
    //EFFECTS: configures event and stores it to EventList
    public EventList setEvent(EventList events) {
        Event event1;

        event1 = this.configureEvent();

        events.addEvent(event1);

        System.out.println();
        System.out.println("Event '" + event1.activity + "' " + "has been scheduled.");
        System.out.println();

        return events;
    }

    //MODIFIES: this
    //EFFECTS: configures the details of the event
    private Event configureEvent() {
        Scanner scan = new Scanner(System.in);

        String response1;
        int response2;

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

        return this;
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
}
