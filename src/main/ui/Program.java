package ui;

import java.util.*;

import model.EventList;
import file.*;

class Program implements Savable, Loadable {

    private EventList events;

    public Program(EventList events) {
        this.events = events;
    }

    //MODIFIES: The passed EventList parameter
    //EFFECTS: Launches the entire program
    void program() {
        String response;

        System.out.println("______________________________________");

        this.events = this.mainMenu(this.events);

        System.out.println("______________________________________");

        System.out.println("Press any key to return to main menu.");
        anyKey();

        program();
    }

    //MODIFIES: The passed EventList parameter
    //EFFECTS: Prints user options and executes chosen task, returns updated EventList
    private EventList mainMenu(EventList events) {
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

    //MODIFIES: The passed EventList parameter
    //EFFECTS: Executes chosen option, returns updated EventList
    private EventList selection(EventList events) {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if (choice == 1) {
            events = events.setEvents();
        } else if (choice == 2) {
            events.print();
        } else if (choice == 3) {
            System.out.println("This feature is not available yet. Suck it up.");
        } else {
            System.out.println("You have made an invalid selection.");
        }
        return events;
    }

    private void anyKey() {
        Scanner scan = new Scanner(System.in);
        String response;
        response = scan.nextLine();
    }

    /*private String validResponse() {

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
*/
}
