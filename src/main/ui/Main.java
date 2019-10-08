package ui;

import model.EventList;
import model.ToDoList;

import java.io.IOException;

public class Main {

    // Creates a EventList, 'events', that will be used to store all events through out the whole program
    public static void main(String[] args) throws IOException {
        EventList eventlist;
        ToDoList todolist;

        eventlist = new EventList();
        todolist = new ToDoList();

        eventlist.load();
        todolist.load();

        //instantiation of implementation
        UserInterface program1 = new InterfaceVersion1(eventlist);
        program1.execute();
    }
}
