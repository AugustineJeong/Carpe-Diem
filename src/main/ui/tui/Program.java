package ui.tui;

import exceptions.*;
import model.data.TextSaveLoad;
import model.item.Item;

import java.io.*;
import java.util.*;


public class Program {
    private TextSaveLoad textSaveLoad;
    private List<Item> itemList;
    private Interface interface1;
    private InputManagement inputManagement;
    private Configurer configurer;

    //constructor: creates an instance of a program
    public Program() throws IOException {
        textSaveLoad = new TextSaveLoad();
        itemList = new ArrayList<>();
        interface1 = new Interface();
        inputManagement = new InputManagement();
        configurer = new Configurer();
    }

    //MODIFIES: this
    //EFFECTS: starts program
    public void runProgram() {
        try {
            itemList = textSaveLoad.load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                execute();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UserEndProgram userEndProgram) {
                interface1.endProgramMessage();
                break;
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: executes main entry point into program's features
    public void execute() throws IOException, UserEndProgram {
        interface1.mainMenuOptions();
        int optionSelection = inputManagement.mainMenuOptionSelection();
        try {
            runOptionSelection(optionSelection);
        } catch (IntExpectedDuration | IntExpectedTime | InvalidTimeFormat i) {
            interface1.invalidInput();
        }
        inputManagement.enterAnyKeyToContinue();
    }

    //MODIFIES: this, ./data/saveEvents.txt and ./data/saveTasks.txt
    //EFFECTS: runs selected feature of program
    private void runOptionSelection(int optionSelection) throws IntExpectedDuration, IntExpectedTime, IOException,
            UserEndProgram, InvalidTimeFormat {
        if (optionSelection == 1) {
            Item item = configurer.setItem(true);
            this.itemList.add(item);
        } else if (optionSelection == 2) {
            Item item = configurer.setItem(false);
            this.itemList.add(item);
        } else if (optionSelection == 3) {
            interface1.print(itemList);
        } else {
            runOptionSelection2(optionSelection);
        }
    }

    //MODIFIES: ./data/saveEvents.txt and ./data/saveTasks.txt
    //EFFECTS: runs selected feature of program
    private void runOptionSelection2(int optionSelection) throws UserEndProgram, IOException {
        if (optionSelection == 4) {
            //
        } else if (optionSelection == 5) {
            //
        } else if (optionSelection == 6) {
            interface1.printWeatherInformation();
        } else {
            textSaveLoad.save(this.itemList);
            throw new UserEndProgram();
        }
    }
}