package model;

import file.*;

import java.io.*;
import java.util.*;

public abstract class ItemList implements Loadable, Saveable {

    protected ArrayList<Item> itemArrayList;

    public ItemList() {
        itemArrayList = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: adds the Item parameter to this ItemList's ArrayList
    public void addItem(Item item) {
        this.itemArrayList.add(item);
    }

    //REQUIRES: This ItemList's ArrayList must not be empty
    //EFFECTS: returns 'i'th item of this ItemList
    public Item get(int i) {
        ArrayList<Item> itemlist;
        Item item;

        itemlist = this.itemArrayList;
        item = itemlist.get(i - 1);
        return item;
    }

    //EFFECTS: Prints all items in this EventList
    public abstract void print();

    public abstract void save() throws IOException;

    public abstract void load() throws FileNotFoundException;
}

