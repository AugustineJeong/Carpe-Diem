package ui.program;

import exceptions.*;
import model.data.TextSaveLoad;
import model.item.Item;
import model.marker.Flag;
import ui.program.components.*;

import java.io.*;
import java.util.*;


public class Program {
    private TextSaveLoad textSaveLoad;
    private List<Item> itemList;
    private Map<Flag, List<Item>> flagMap;
    private Interface interface1;
    private InputManagement inputManagement;
    private Configurer configurer;

    //constructor: creates an instance of a program
    //MODIFIES: this
    public Program() {
        textSaveLoad = new TextSaveLoad();
        itemList = new ArrayList<>();
        interface1 = new Interface();
        inputManagement = new InputManagement();
        configurer = new Configurer();
        flagMap = new HashMap<>();
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
        } catch (IntExpectedDuration | IntExpectedTime i) {
            interface1.invalidInput();
        }
        inputManagement.enterAnyKeyToContinue();
    }

    //MODIFIES: this
    //EFFECTS: runs selected feature of program
    private void runOptionSelection(int optionSelection) throws IntExpectedDuration, IntExpectedTime, IOException,
            UserEndProgram {
        if (optionSelection == 1) {
            this.itemList.add(configurer.setItem(true));
        } else if (optionSelection == 2) {
            this.itemList.add(configurer.setItem(false));
        } else if (optionSelection == 3) {
            interface1.print(itemList);
        } else if (optionSelection == 4) {
            interface1.print(itemList);
            itemFlagger();
        } else if (optionSelection == 5) {
            getFlaggedItems();
        } else {
            textSaveLoad.save(this.itemList);
            throw new UserEndProgram();
        }
    }

    //MODIFIES: this
    //EFFECTS: adds or removes a flag from an item
    private void itemFlagger() {
        interface1.addOrRemoveFlag();
        if (inputManagement.addOrRemoveSelection()) {
            interface1.pleaseSelectItemToFlag();
            inputManagement.flagSelectedItemWithGivenActivityName(this.flagMap, this.itemList,
                    inputManagement.anyStringResponse());
        } else {
            interface1.pleaseSelectItemToUnFlag();
            inputManagement.unFlagSelectedItemWithGivenActivityName(this.flagMap, this.itemList,
                    inputManagement.anyStringResponse());
        }

    }

    //EFFECTS: prints all flagged items
    private void getFlaggedItems() {
        interface1.whatColourFlagWouldYouLikeToView();
        interface1.print(inputManagement.getItemsWithSameColourAsParameter(this.flagMap,
                inputManagement.anyStringResponse()));
    }
}
