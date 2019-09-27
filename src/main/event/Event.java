package event;

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

    // update date of event
    public void updatedate(String x) {
        this.date = x;
    }

    // update name of event
    public void updateactivity(String x) {
        this.activity = x;
    }

    // update the start time of event
    public void updatetime(int x) {
        this.time = x;
    }

    // update the duration of event
    public void updateduration(int x) {
        this.duration = x;
    }

    // update the end time of event
    public void updateend(int x) {
        this.end = x;
    }

    // return the details of event as a string
    public String returnevent() {
        String message;
        message = "'" + this.activity + "'" +  " scheduled from " + this.time + " to " + this.end;
        return message;
    }

    // creates new configured class and stores it to EventList
    public EventList setevent(EventList events) {
        Event event1;

        event1 = this.questions();

        events.addEvent(event1);
        return events;
    }

    // questions to be used for setevent
    // question to configure new Event
    public Event questions() {
        Scanner scan = new Scanner(System.in);

        String response1;
        int response2;

        System.out.println("What would you like to name the event?");
        response1 = scan.nextLine();
        this.updateactivity(response1);

        System.out.println("What day is this event on?");
        response1 = scan.nextLine();
        this.updatedate(response1);

        System.out.println("What time does this event start");
        response2 = scan.nextInt();
        this.updatetime(response2);

        System.out.println("How long is this event?");
        response2 = scan.nextInt();
        this.updateduration(response2);

        return this;
    }
}
