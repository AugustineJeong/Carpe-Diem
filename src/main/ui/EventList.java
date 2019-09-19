package ui;

import java.util.*;

public class EventList {

    // fields
    public ArrayList<Event> eventArrayList;

    // constructor
    public EventList() {
        eventArrayList = new ArrayList<>();
    }

    // adds an event to the current list of events
    public void addEvent(Event event) {
        eventArrayList.add(event);
    }

    // returns first event of EventList
    public Event first() {
        ArrayList<Event> eventslist;
        Event event;

        eventslist = this.eventArrayList;
        event = eventslist.get(0);
        return event;
    }

    // prints details of all events in EventList
    public void print() {
        ArrayList<Event> eventslist;
        Event event;

        eventslist = this.eventArrayList;

        while (eventslist.size() > 0) {
            event = eventslist.get(0);
            System.out.println(event.returnevent());
            eventslist.remove(0);
        }
    }
}
