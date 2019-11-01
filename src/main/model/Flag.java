package model;

import java.util.ArrayList;
import java.util.List;

public class Flag {
    private String colour;

    private List<Item> items = new ArrayList<>();

    public Flag(String s) {
        this.colour = s;
    }

    public void addItem(Item i) {
        if (!items.contains(i)) {
            items.add(i);
            i.addFlag(this);
            System.out.println("You now have " + this.items.size() + " marked items.");
        }
    }

    public void removeItem(Item i) {
        if (items.contains(i)) {
            items.remove(i);
            i.removeFlag(this);
            System.out.println("You now have " + this.items.size() + " flagged items.");
        }
    }


}
