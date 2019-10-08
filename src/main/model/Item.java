package model;

abstract class Item {

    protected boolean isEvent;
    protected String date;
    protected String activity;

    public Item() {
        date = "Monday";
        activity = "interview";
    }

    abstract String returnItemDetails();
    //EFFECTS: Returns the details of the event

    //MODIFIES: this
    //EFFECTS: update date of event
    public void setDate(String x) {
        this.date = x;
    }

    //MODIFIES: this
    //EFFECTS: update name of event
    public void setActivity(String x) {
        this.activity = x;
    }

    //EFFECTS: returns date
    public String getDate() {
        return date;
    }

    //EFFECTS: returns activity
    public String getActivity() {
        return activity;
    }
}

