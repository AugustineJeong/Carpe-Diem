package ui;

import org.json.JSONException;
import ui.program.Program;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, JSONException {
        Program program1 = new Program();
        program1.runProgram();
    }
}
