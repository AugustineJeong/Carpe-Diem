package ui.program.components;

import model.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Interface {

    private InputManagement inputManagement;

    public Interface() {
    }

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

    public void invalidInput() {
        System.out.println("Error: invalid input");
    }

    public void endProgramMessage() {
        System.out.println("Exiting program...");
    }

    public void pleaseSelectItemToFlag() {
        System.out.println("Please enter the name of the item that you would like to flag.");
    }

    public void pleaseSelectItemToUnFlag() {
        System.out.println("Please enter the name of the item that you would like to un-flag.");
    }

    public void whatColourFlagWouldYouLikeToAdd() {
        System.out.println("What colour flag would you like to add?");
    }

    public void whatColourFlagWouldYouLikeToView() {
        System.out.println("Which colour of flag would you like to view?");
    }

    public void itemFlagged() {
        System.out.println("Item has been flagged!");
    }

    public void itemUnFlagged() {
        System.out.println("Item has been un-flagged!");
    }

    public void noMatchFound() {
        System.out.println("Error: no match found");
    }

    public void addOrRemoveFlag() {
        System.out.println("Would you like to add or remove a flag?");
    }
}
