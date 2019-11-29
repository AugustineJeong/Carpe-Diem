package model.data;

public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;

    //EFFECTS: returns the description field
    public String getDescription() {
        return description;
    }
}
