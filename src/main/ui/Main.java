package ui;

import event.EventList;

import javax.jws.soap.SOAPBinding;

public class Main {

    // Creates a EventList, 'events', that will be used to store all events through out the whole program
    public static void main(String[] args) {
        EventList events;
        UserInterface program;

        events = new EventList();
        program = new UserInterface();

        events = program.mainMenu(events);

        events.print();
    }
}
