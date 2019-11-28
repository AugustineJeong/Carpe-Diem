package model.item;

public class Task extends Item {

    //constructor: creates a task object
    //MODIFIES: this
    public Task() {
        super();
        this.isEvent = false;
    }

    //EFFECTS: Returns the details of the item
    public String returnItemDetails() {
        String message;

        message = " '" + this.activity + "'" + " by " + this.date;

        return message;
    }
}
