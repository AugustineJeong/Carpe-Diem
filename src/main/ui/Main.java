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

    // receives EventList from setevent(), and asks if the user wants to add an event
    // checks for user response, keeps asking user to add event(s) until user responds 'no'
    // returns the updated EventList
    private static EventList userresponse(EventList events) {
        String response;
        Event event1;


        while (true) {
            event1 = new Event();
            response = response();

            if (response.equals("yes")) {
                events = event1.setevent(events);
            } else if (response.equals("no")) {
                goodbye();
                return events;
            }

            askuser();
        }
    }

    // Notifies the end of event schedule addition
    private static void goodbye() {
        System.out.println("Sure. No additional event will be scheduled");
    }

    // checks if the user response is valid (i.e. checks if it is 'yes' or 'no')
    // loops until user inputs a valid response
    private static String response() {
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

    // Creates a EventList, 'events', that will be used to store all events through out the whole program
    public static void main(String[] args) {
        EventList events;
        events = new EventList();

        welcome();
        events = userresponse(events);

        events.print();
    }
}
