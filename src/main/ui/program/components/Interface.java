package ui.program.components;

import model.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Interface {

    private InputManagement inputManagement;

    //constructor: constructs new Interface object
    public Interface() {
    }

    //EFFECTS: displays menu options of this interface
    public void mainMenuOptions() {
        System.out.println("______________________________________");
        System.out.println("PLEASE MAKE A SELECTION FROM THE FOLLOWING MENU");
        System.out.println();
        System.out.println("[1] Add Event(s)");
        System.out.println("[2] Add ToDo(s)");
        System.out.println("[3] View All Items");
        System.out.println("[4] Flag / un-flag Event");
        System.out.println("[5] View Flagged Items");
        System.out.println("[6] Exit Program");
        System.out.println();
    }

    //EFFECTS: prints all the items in the itemList parameter
    public void print(List<Item> itemList) {
        List<Item> eventList = new ArrayList<>();
        List<Item> taskList = new ArrayList<>();
        for (Item i : itemList) {
            if (i.getIsEvent()) {
                eventList.add(i);
            } else {
                taskList.add(i);
            }
        }
        System.out.println("______________________________________");
        printList(eventList, true);
        System.out.println();
        printList(taskList, false);
        System.out.println("______________________________________");
    }

    //EFFECTS: prints all the items in the itemList parameter, under Event if isEventList parameter is true,
    //under Task if isEventList parameter is false
    private void printList(List<Item> list, boolean isEventList) {
        if (isEventList) {
            if (list.isEmpty()) {
                System.out.println("You have no events.");
            } else {
                System.out.println("Events:");

            }
        } else {
            if (list.isEmpty()) {
                System.out.println("You have no tasks.");
            } else {
                System.out.println("Tasks:");

            }
        }
        int n = 1;
        for (Item i : list) {
            System.out.println("[" + n + "] " + i.returnItemDetails());
            n++;
        }
    }

    //EFFECTS: prints message to notify user of invalid input
    public void invalidInput() {
        System.out.println("Error: invalid input");
    }

    //EFFECTS: prints message to notify user of program exit
    public void endProgramMessage() {
        System.out.println("Exiting program...");
    }

    //EFFECTS: prints message asking user the name of item to flag
    public void pleaseSelectItemToFlag() {
        System.out.println("Please enter the name of the item that you would like to flag.");
    }

    //EFFECTS: prints message asking user the name of item to un-flag
    public void pleaseSelectItemToUnFlag() {
        System.out.println("Please enter the name of the item that you would like to un-flag.");
    }

    //EFFECTS: prints message asking what colour of flag the user would like to add
    public void whatColourFlagWouldYouLikeToAdd() {
        System.out.println("What colour flag would you like to add?");
    }

    //EFFECTS: prints message asking what colour of flag the user would like to vie
    public void whatColourFlagWouldYouLikeToView() {
        System.out.println("Which colour of flag would you like to view?");
    }

    //EFFECTS: prints message notifying the user that item has been flagged
    public void itemFlagged() {
        System.out.println("Item has been flagged!");
    }

    //EFFECTS: prints message notifying the user that item has been un-flagged
    public void itemUnFlagged() {
        System.out.println("Item has been un-flagged!");
    }

    //EFFECTS: prints message notifying the user that no match has been found to the user's query input
    public void noMatchFound() {
        System.out.println("Error: no match found");
    }

    //EFFECTS: prints message asking user if whether the user would like to add or remove a flag
    public void addOrRemoveFlag() {
        System.out.println("Would you like to add or remove a flag?");
    }
}
