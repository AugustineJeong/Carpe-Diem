package ui;

import java.util.*;
import event.EventList;

public class UserInterface {

    public EventList mainMenu(EventList events) {
        System.out.println("[Simple Scheduler beta 1.01]");
        System.out.println("PLEASE MAKE A SELECTION FROM THE FOLLOWING MENU");
        System.out.println();
        System.out.println("[1] Add Events");
        System.out.println("[2] Delete Event");
        System.out.println();

        events = selection(events);

        return events;
    }

    private EventList selection(EventList events) {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if (choice == 1) {
            events = events.setEvents();
            return events;
        }

        return events;
    }
}
