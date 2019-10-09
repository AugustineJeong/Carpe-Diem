package model;

public class ToDo extends Item {

    public ToDo() {
        super();
        this.isEvent = false;
    }

    // Returns the value of the item
    @Override
    public String returnItemDetails() {
        String message;
        message = " '" + this.activity + "'" +  " by " + this.date;
        return message;
    }
}
