package ui;

import model.EventList;

import java.io.IOException;

public class Main {

    // Creates a EventList, 'events', that will be used to store all events through out the whole program
    public static void main(String[] args) throws IOException {
        EventList prevEvents;

        prevEvents = new EventList();
        prevEvents.load();

        //instantiation of implementation
        UserInterface program1 = new InterfaceVersion1(prevEvents);
        program1.execute();
    }
}
