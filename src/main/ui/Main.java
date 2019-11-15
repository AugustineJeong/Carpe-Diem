package ui;

import model.observer.Birb;
import ui.program.Program;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Program program1 = new Program();

        Birb birb = new Birb();
        program1.addObserver(birb);

        program1.runProgram();
    }
}
