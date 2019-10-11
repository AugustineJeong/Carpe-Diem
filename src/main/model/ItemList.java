package model;

import file.*;

import java.io.*;
import java.util.*;

public abstract class ItemList implements Loadable, Saveable {

    protected ArrayList<Item> itemArrayList;

    public ItemList() {
        itemArrayList = new ArrayList<>();
    }

    //MODIFIES: This
    //EFFECTS: Adds the Item parameter to this ItemList's ArrayList
    public void addItem(Item item) {
        this.itemArrayList.add(item);
    }

    //REQUIRES: This ItemList's ArrayList must not be empty
    //EFFECTS: Returns 'i'th item of this ItemList
    public Item get(int i) {
        ArrayList<Item> itemlist;
        Item item;

        itemlist = this.itemArrayList;
        item = itemlist.get(i - 1);
        return item;
    }

    //EFFECTS: Returns the number of items in this itemArrayList
    public int length() {
        return this.itemArrayList.size();
    }

    //EFFECTS: saves the ItemList as a text file
    public abstract void save() throws IOException;

    //EFFECTS: loads the details of ItemList from a text file
    public abstract void load() throws FileNotFoundException;
}

