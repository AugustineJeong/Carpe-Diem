package model;

public class ToDo extends Item {

    public ToDo() {
        super();
        this.isEvent = false;
    }

    //EFFECTS: Returns a string of details of this item
    @Override
    public String returnItemDetails() {
        String message;
        message = " '" + this.activity + "'" +  " by " + this.date;
        return message;
    }
}
