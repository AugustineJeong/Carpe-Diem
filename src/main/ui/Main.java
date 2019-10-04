package ui;

import file.Loadable;
import model.Event;
import model.EventList;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    // Creates a EventList, 'events', that will be used to store all events through out the whole program
    public static void main(String[] args) throws IOException {
        EventList prevEvents;
        Program program1;

        prevEvents = new EventList();
        prevEvents.load();

        program1 = new Program(prevEvents);
        program1.program();

        Loadable x = new EventList();
        x.
    }
}
