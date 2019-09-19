package ui;

import java.util.*;

public class EventList {

    // fields
    ArrayList<Event> eventArrayList;

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
}
