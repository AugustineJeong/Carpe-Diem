package event;

import ui.UserInterface;

import java.util.*;

public class EventList {

    // fields
    private ArrayList<Event> eventArrayList;

    // constructor
    public EventList() {
        eventArrayList = new ArrayList<>();
    }

    // adds an event to the current list of events
    public void addEvent(Event event) {
        eventArrayList.add(event);
    }

    // receives EventList from setevent(), and asks if the user wants to add an event
    // checks for user response, keeps asking user to add event(s) until user responds 'no'
    // returns the updated EventList
    public EventList setEvents() {
        String response;
        Event event1;
        EventList events;
        events = this;

        while (true) {
            event1 = new Event();

            events = event1.setevent(events);

            askUserAgain();
            response = validResponse();

            if (response.equals("no")) {
                goodbye();
                return events;
            }
        }
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
        int i = 1;

        eventslist = this.eventArrayList;

        System.out.println();
        System.out.println("YOU HAVE THE FOLLOWING SCHEDULED EVENTS:");

        while (eventslist.size() > 0) {
            event = eventslist.get(0);
            System.out.println("[" + i + "]" + event.returnevent());
            eventslist.remove(0);
            i++;
        }
    }

    // checks if the user response is valid (i.e. checks if it is 'yes' or 'no')
    // loops until user inputs a valid response
    private String validResponse() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            String response;
            response = scan.nextLine();

            if (!((response.equals("yes")) || (response.equals("no")))) {
                System.out.println("Response unrecognized. Please respond by 'yes' or 'no'.");
            } else {
                return response;
            }
        }
    }

    // Asks another time if the user would like to schedule another event
    private void askUserAgain() {
        System.out.println("Would you like to schedule another event into your calendar?");
    }

    // Notifies the end of event schedule addition
    private void goodbye() {
        System.out.println("Sure. No additional event will be scheduled");
    }
}
