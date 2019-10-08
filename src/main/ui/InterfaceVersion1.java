package ui;

import java.io.IOException;
import java.util.*;

import model.Event;
import model.EventList;

public class InterfaceVersion1 implements UserInterface {

    private EventList events;

    public InterfaceVersion1(EventList events) {
        this.events = events;
    }

    //MODIFIES: The passed EventList parameter
    //EFFECTS: Launches the entire program
    public void execute() throws IOException {
        System.out.println("______________________________________");

        this.events = this.mainMenu(this.events);

        System.out.println("______________________________________");

        System.out.println("Press any key to return to main menu.");
        anyKey();

        execute();
    }

    //MODIFIES: The passed EventList parameter
    //EFFECTS: Prints user options and executes chosen task, returns updated EventList
    private EventList mainMenu(EventList events) throws IOException {
        System.out.println("[Simple Scheduler alpha 1.1 - Interface 1]");
        System.out.println("PLEASE MAKE A SELECTION FROM THE FOLLOWING MENU");
        System.out.println();
        System.out.println("[1] Add Events");
        System.out.println("[2] View All Events");
        System.out.println("[3] View Events by Category");
        System.out.println("[4] Delete Event");
        System.out.println();

        events = selection(events);

        return events;
    }

    //MODIFIES: The passed EventList parameter
    //EFFECTS: Executes chosen option, returns updated EventList
    private EventList selection(EventList events) throws IOException {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if (choice == 1) {
            events = this.setEvents(events);
        } else if (choice == 2) {
            events.print();
        } else if (choice == 3 || choice == 4) {
            System.out.println("This feature is not available yet. Suck it up.");
        } else {
            System.out.println("You have made an invalid selection.");
        }

        events.save();

        return events;
    }

    private void anyKey() {
        Scanner scan = new Scanner(System.in);
        String response;
        response = scan.nextLine();
    }

    //MODIFIES: EventList parameter
    //EFFECTS: Adds new configured event(s) to EventList parameter
    private EventList setEvents(EventList events) {
        String response;
        Event event1;

        while (true) {
            events = this.addNewEvent(events);

            //ask user again
            System.out.println("Would you like to schedule another event into your calendar?");
            response = validResponse();

            if (response.equals("no")) {
                //say goodbye
                System.out.println("Sure. No additional event will be scheduled");
                return events;
            }
        }
    }

    //MODIFIES: this and the EventList parameter
    //EFFECTS: configures new event and stores it to EventList parameter
    private EventList addNewEvent(EventList events) {
        Event event;
        event = new Event();

        event = this.configureEventMain(event);

        events.addEvent(event);

        System.out.println();
        System.out.println("Event '" + event.getActivity() + "' " + "has been scheduled.");
        System.out.println();

        return events;
    }

    //MODIFIES: Event parameter
    //EFFECTS: configures the details of the passed Event parameter
    private Event configureEventMain(Event event) {
        Scanner scan = new Scanner(System.in);

        String responseString;

        System.out.println("What would you like to name the event?");
        responseString = scan.nextLine();
        event.setActivity(responseString);

        System.out.println("What day is this event on?");
        responseString = scan.nextLine();
        event.setDate(responseString);

        int responseInt;

        System.out.println("What time, in hours, does this event start?");
        responseInt = scan.nextInt();
        event.setTime(responseInt);

        System.out.println("How long, in hours, is this event?");
        responseInt = scan.nextInt();
        event.setDuration(responseInt);

        event.setCalculatedEnd();

        return event;
    }

    //EFFECTS: Returns scanner string only if it is either 'yes' or 'no'
    private static String validResponse() {
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
}
