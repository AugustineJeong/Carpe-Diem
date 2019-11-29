package ui.tui;

import model.data.WeatherData;
import model.item.Item;
import network.WebDataLoad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Interface {

    private WebDataLoad webDataLoad = new WebDataLoad();
    private WeatherData weatherData;

    //constructor
    public Interface() {
        {
            try {
                weatherData = webDataLoad.dataLoad();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //EFFECTS: prints a straight line
    public void drawLine() {
        System.out.println("_______________________________________________________");
    }

    //EFFECTS: displays the menu options of this interface
    public void mainMenuOptions() {
        drawLine();
        System.out.println("PLEASE MAKE A SELECTION FROM THE FOLLOWING MENU OPTIONS");
        System.out.println();
        System.out.println("[1] Add Event(s)");
        System.out.println("[2] Add ToDo(s)");
        System.out.println("[3] View All Items");
        System.out.println("[4] Flag / un-flag Event");
        System.out.println("[5] View Flagged Items");
        System.out.println("[6] Check Today's Weather");
        System.out.println("[7] Exit Program");
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
        drawLine();
        printList(eventList, true);
        System.out.println();
        printList(taskList, false);
        drawLine();
    }

    //EFFECTS: prints all the items in the itemList parameter, under Event or Task header accordingly
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

    //EFFECTS: prints a message asking user what they would like to name the item as
    public void askItemName(String itemType) {
        System.out.println("What would you like to name the " + itemType + " ?");
    }

    //EFFECTS: prints a message asking user what day the item is on
    public void askItemDate(String itemType) {
        System.out.println("What day is this " + itemType + " on?");
    }

    //EFFECTS: prints a message asking user what time the Event is on
    public void askItemTime() {
        System.out.println("What time, in military hours, does this event start? (ex. 12:30PM = 1230, 7:30AM = 0730)");
    }

    //EFFECTS: prints a message asking user what the duration of the Event is
    public void askItemDuration() {
        System.out.println("How many hours, in integer, is the duration of this event? (ex. 1 hour = 1)");
    }

    //EFFECTS: prints a message asking to press enter to continue
    public void pressEnterToContinue() {
        System.out.println("Press enter to continue.");
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

    //EFFECTS: prints weather information
    public void printWeatherInformation() {
        System.out.println("It is currently " + weatherData.getMain().getTempInCelsius()
                + " degrees celsius with " + weatherData.getWeather().get(0).getDescription() + " in Vancouver");
    }
}
