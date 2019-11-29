package model.item;

public class Task extends Item {

    //constructor
    //MODIFIES: this
    //EFFECTS: creates a task object
    public Task() {
        super();
        this.isEvent = false;
    }

    //EFFECTS: Returns the details of this Task as a string
    public String returnItemDetails() {
        String message;

        message = " '" + this.activity + "'" + " by " + this.date;

        return message;
    }
}
