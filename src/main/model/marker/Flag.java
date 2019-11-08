package model.marker;

import model.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flag implements Marker {
    private String colour;

    private List<Item> items = new ArrayList<>();

    //constructor: creates a flag object with parameter colour
    public Flag(String s) {
        this.colour = s;
    }

    //EFFECTS: returns the colour of this flag
    public String getColour() {
        return this.colour;
    }

    //MODIFIES: this and item parameter
    //EFFECTS: adds item to the flag's item list and adds this flag to item's flag list
    public void addItem(Item i) {
        if (!items.contains(i)) {
            this.items.add(i);
            i.addFlag(this);
        }
    }

    //MODIFIES: this and item parameter
    //EFFECTS: removes item from the flag's item list and removes this flag from item's flag list
    public void removeItem(Item i) {
        if (items.contains(i)) {
            items.remove(i);
            i.removeFlag();
        }
    }

    //EFFECTS: returns true if item list already contains item parameter
    public boolean containsSameItem(Item i) {
        for (Item item : items) {
            if (item.getActivity().equals(i.getActivity()) && (item.getDate().equals(i.getDate()))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Flag flag = (Flag) o;
        return colour.equals(flag.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour);
    }
}
