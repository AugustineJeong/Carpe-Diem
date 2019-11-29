package model.item;


//import model.marker.Flag;

import java.util.Objects;

public abstract class Item {

    protected boolean isEvent;
    protected String date;
    protected String activity;

//    private Flag flag;
    protected boolean isFlagged;

    //constructor
    //MODIFIES: this
    //EFFECTS: creates an Item Object
    public Item() {
        this.date = "Place holder";
        this.activity = "Place holder";
//        this.flag = null;
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


//    public Flag getFlag() {
//        return this.flag;
//    }
//
//    //MODIFIES: this and flag parameter
//    //EFFECTS: adds flag to the item
//    public void addFlag(Flag f) {
//        if (!this.isFlagged || !this.flag.equals(f)) {
//            if (!this.isFlagged) {
//                this.flag = f;
//                f.addItem(this);
//                this.isFlagged = true;
//            } else {
//                this.flag.removeItem(this);
//                this.isFlagged = false;
//                this.flag = f;
//                this.isFlagged = true;
//                f.addItem(this);
//            }
//        }
//    }
//
//    //MODIFIES: this and flag parameter
//    //EFFECTS: removes flag from item and removes this item from flag's item list
//    public void removeFlag() {
//        if (this.isFlagged) {
//            this.flag.removeItem(this);
//            flag = null;
//            this.isFlagged = false;
//        }
//    }

    //EFFECTS: returns true if this item is flagged
    public Boolean isFlagged() {
        return this.isFlagged;
    }

//    //EFFECTS: returns true if item is flagged by the passed flag parameter
//    public Boolean containsFlag(Flag f) {
//        if (!this.isFlagged) {
//            return false;
//        }
//        return (this.flag.equals(f));
//    }

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


