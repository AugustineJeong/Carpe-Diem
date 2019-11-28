package ui.components;

import exceptions.IntExpectedDuration;
import exceptions.IntExpectedTime;
import exceptions.InvalidTimeFormat;
import model.item.Event;
import model.item.Item;
import model.item.Task;
import ui.tui.InputManagement;
import ui.tui.Interface;

public class Configurer {

    private InputManagement inputManagement = new InputManagement();
    private Interface interface1 = new Interface();

    //EFFECTS: creates, configures, and returns a new Item, new Event if isEvent is true, new Task otherwise
    public Item setItem(Boolean isEvent) throws IntExpectedDuration, IntExpectedTime, InvalidTimeFormat {
        Item item = new Event();
        String itemType = "Event";

        if (!isEvent) {
            item = new Task();
            itemType = "Task";
        }

        interface1.askItemName(itemType);
        item.setActivity(inputManagement.anyStringResponse());

        interface1.askItemDate(itemType);
        item.setDate(inputManagement.anyStringResponse());

        if (isEvent) {
            item = configureItemHelper1((Event) item);
        }
        return item;
    }

    //EFFECTS: configures the details of an Event
    private Item configureItemHelper1(Event item) throws IntExpectedTime, IntExpectedDuration, InvalidTimeFormat {
        interface1.askItemTime();

        String response = inputManagement.anyStringResponse();
        if (response.matches("[.]*[^0-9]*[.]*")) {
            throw new IntExpectedTime();
        } else if (response.length() != 4) {
            throw new InvalidTimeFormat();
        }
        int responseInt = Integer.parseInt(response);
        if (responseInt > 2400) {
            throw new InvalidTimeFormat();
        }
        item.setTime(responseInt);

        return configureItemHelper2(item);
    }

    //EFFECTS: configures the details of an Event
    private Item configureItemHelper2(Event item) throws IntExpectedDuration {
        interface1.askItemDuration();
        String response = inputManagement.anyStringResponse();

        if (response.matches("[^0-9]*")) {
            throw new IntExpectedDuration();
        }

        int responseInt = Integer.parseInt(response);
        item.setDuration(responseInt);

        item.setCalculatedEnd();

        return item;
    }

}

