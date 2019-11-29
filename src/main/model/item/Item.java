package model.item;

import java.util.Objects;

public abstract class Item {

    protected boolean isEvent;
    protected String date;
    protected String activity;

    protected boolean isFlagged;

    //constructor
    //MODIFIES: this
    //EFFECTS: creates an Item Object
    public Item() {
        this.date = "Place holder";
        this.activity = "Place holder";
        this.isFlagged = false;
    }

    //EFFECTS: Returns the details of the Item as a string
    public abstract String returnItemDetails();

    //MODIFIES: this
    //EFFECTS: update isEvent status of this Item
    public void setIsEvent(boolean x) {
        this.isEvent = x;
    }

    //MODIFIES: this
    //EFFECTS: update date of this Item
    public void setDate(String x) {
        this.date = x;
    }

    //MODIFIES: this
    //EFFECTS: update name of this Item
    public void setActivity(String x) {
        this.activity = x;
    }

    //EFFECTS: returns isEvent
    public boolean getIsEvent() {
        return isEvent;
    }

    //EFFECTS: returns date
    public String getDate() {
        return date;
    }

    //EFFECTS: returns activity
    public String getActivity() {
        return activity;
    }

    //EFFECTS: returns true if this item is flagged
    public Boolean isFlagged() {
        return this.isFlagged;
    }

    //MODIFIES: this
    //EFFECTS: updates the isFlagged value of this Item
    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    //EFFECTS: overrides equals function of Item class, compares isEvent, activity, and date of items
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return isEvent == item.isEvent && activity.equals(item.activity) && date.equals(item.date);
    }

    //EFFECTS: overrides hashCode function of Item class
    @Override
    public int hashCode() {
        return Objects.hash(isEvent, date, activity);
    }
}


