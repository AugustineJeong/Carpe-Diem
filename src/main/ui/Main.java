package ui;

import model.EventList;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    // Creates a EventList, 'events', that will be used to store all events through out the whole program
    public static void main(String[] args) throws IOException {
        EventList events;
        Program program1;

        events = new EventList();
        events.load();

        program1 = new Program(events);
        program1.program();
    }
}
