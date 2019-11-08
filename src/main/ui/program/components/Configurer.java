package ui.program.components;

import exceptions.IntExpectedDuration;
import exceptions.IntExpectedTime;
import model.item.Event;
import model.item.Item;
import model.item.Task;

public class Configurer {

    private InputManagement inputManagement = new InputManagement();

    //EFFECTS: creates, configures, and returns a new Item, new Event if isEvent is true, new Task otherwise
    public Item setItem(Boolean isEvent) throws IntExpectedDuration, IntExpectedTime {
        Item item = new Event();
        String itemType = "Event";

        if (!isEvent) {
            item = new Task();
            itemType = "Task";
        }

        System.out.println("What would you like to name the " + itemType + " ?");
        item.setActivity(inputManagement.anyStringResponse());

        System.out.println("What day is this " + itemType + " on?");
        item.setDate(inputManagement.anyStringResponse());

        if (isEvent) {
            item = configureItemHelper1(item);
        }
        return item;
    }

    //EFFECTS: configures the details of an Event
    private Item configureItemHelper1(Item item) throws IntExpectedTime, IntExpectedDuration {
        System.out.println("What time, in hours, does this event start?");

        String response = inputManagement.anyStringResponse();
        if (response.matches("[.]*[^0-9]*[.]*")) {
            throw new IntExpectedTime();
        }
        int responseInt = Integer.parseInt(response);
        item.setTime(responseInt);

        return configureItemHelper2(item);
    }

    //EFFECTS: configures the details of an Event
    private Item configureItemHelper2(Item item) throws IntExpectedDuration {
        System.out.println("How long, in hours, is this event?");
        String response = inputManagement.anyStringResponse();

        if (response.matches("[.]*[^0-9]*[.]*")) {
            throw new IntExpectedDuration();
        }

        int responseInt = Integer.parseInt(response);
        item.setDuration(responseInt);

        item.setCalculatedEnd();

        return item;
    }

}

