package model;

import java.util.*;

public class Event {

    // fields
    private String date;
    private String activity;
    private int time;
    private int duration;
    private int end;

    // constructor
    public Event() {
        date = "Monday";
        activity = "interview";
        time = 1400;
        duration = 60;
        end = 1500;
    }

    // return the details of event as a string
    public String returnEvent() {
        String message;
        message = "'" + this.activity + "'" +  " scheduled from " + this.time + " to " + this.end;
        return message;
    }

    // creates new configured class and stores it to EventList
    public EventList setEvent(EventList events) {
        Event event1;

        event1 = this.questions();

        events.addEvent(event1);

        System.out.println();
        System.out.println("Event '" + event1.activity + "' " + "has been scheduled.");
        System.out.println();

        return events;
    }

    // questions to be used for setevent
    // question to configure new Event
    private Event questions() {
        Scanner scan = new Scanner(System.in);

        String response1;
        int response2;

        System.out.println("What would you like to name the event?");
        response1 = scan.nextLine();
        this.updateActivity(response1);

        System.out.println("What day is this event on?");
        response1 = scan.nextLine();
        this.updateDate(response1);

        System.out.println("What time does this event start");
        response2 = scan.nextInt();
        this.updateTime(response2);

        System.out.println("How long is this event?");
        response2 = scan.nextInt();
        this.updateDuration(response2);

        return this;
    }

    // update date of event
    private void updateDate(String x) {
        this.date = x;
    }

    // update name of event
    private void updateActivity(String x) {
        this.activity = x;
    }

    // update the start time of event
    private void updateTime(int x) {
        this.time = x;
    }

    // update the duration of event
    private void updateDuration(int x) {
        this.duration = x;
    }

    // update the end time of event
    private void updateEnd(int x) {
        this.end = x;
    }
}
