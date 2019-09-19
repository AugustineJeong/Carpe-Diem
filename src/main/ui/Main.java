package ui;

import java.util.*;

public class Main {

    // Asks for the first time if the user would like to schedule an event
    private static void welcome() {
        System.out.println("Hello!");
        System.out.println("Would you like to schedule an event into your calendar?");
    }

    // Asks another time if the user would like to schedule another event
    private static void askuser() {
        System.out.println("Would you like to schedule another event into your calendar?");
    }

    // receives EventList from setevent(), and pass it on to loop at main
    // passes on the updated EventList
    private static EventList userresponse(EventList events) {
        Scanner scan = new Scanner(System.in);
        String response;
        Event event1;
        event1 = new Event();

        response = scan.nextLine();

        if (response.equals("yes")) {
            events = event1.setevent(events);
        } else if (response.equals("no")) {
            goodbye();
        } else {
            System.out.println("response unrecognized. Please respond by 'yes' or 'no'.");
        }

        return events;
    }

    // Notifies the end of event schedule addition
    private static void goodbye() {
        System.out.println("Sure. No additional event will be scheduled");
    }

    // Creates a EventList, 'events', that will be used to store all events through out the whole program
    public static void main(String[] args) {
        EventList events;
        events = new EventList();

        welcome();
        //askuser();


        events = userresponse(events);

        Event x;
        x = events.first();

        String str;
        str = x.returnevent();

    }
}
