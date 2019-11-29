package ui;

import ui.tui.Program;

import java.io.IOException;

public class RunTextInterface {
    //EFFECTS: runs the text interface of the program
    public static void main(String[] args) throws IOException {
        Program program1 = new Program();

        program1.runProgram();
    }
}
