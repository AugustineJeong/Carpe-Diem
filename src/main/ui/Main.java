package ui;

import model.EventList;

public class Main {

    // Creates a EventList, 'events', that will be used to store all events through out the whole program
    public static void main(String[] args) {
        EventList events;
        UserInterface program;

        events = new EventList();
        program = new UserInterface();

        program.execute(events);
    }
}
