package model.observer;

import model.item.Item;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Birb implements Observer {

    private List<Item> seenItemList = new ArrayList<>();

    @Override
    public void update(Item item) {
        System.out.println("Birb says: khyeeeee have fun doing " + item.getActivity());
        seenItemList.add(item);
    }

    public List<Item> getSeenItemList() {
        return seenItemList;
    }
}
