package ui;

import java.util.*;
import model.EventList;

public class UserInterface {

    public EventList mainMenu(EventList events) {
        System.out.println("[Simple Scheduler beta 1.01]");
        System.out.println("PLEASE MAKE A SELECTION FROM THE FOLLOWING MENU");
        System.out.println();
        System.out.println("[1] Add Events");
        System.out.println("[2] View Events");
        System.out.println("[3] Delete Event");
        System.out.println();

        events = selection(events);

        return events;
    }

    public EventList execute(EventList events) {
        String response;

        while (true) {
            System.out.println("______________________________________");
            events = this.mainMenu(events);
            System.out.println("______________________________________");

            System.out.println("Return to main menu?");
            response = validResponse();
            if (response.equals("no")) {
                System.out.println("Exiting program...");
                return events;
            }
            System.out.println();
        }
    }

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

    private EventList selection(EventList events) {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if (choice == 1) {
            events = events.setEvents();
            return events;
        } else if (choice == 2) {
            events.print();
        } else if (choice == 3) {
            System.out.println("This feature is not available yet. Suck it up.");
        }   else {
            System.out.println("You have make an invalid selection.");
        }

        return events;
    }
}
