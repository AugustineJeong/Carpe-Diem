package ui;

import model.EventList;
import model.ToDoList;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //instantiation of implementation
        UserInterface program1 = new InterfaceVersion1();
        program1.execute();
    }
}
