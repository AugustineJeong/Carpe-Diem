package observer;

import model.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer observer) {
        if (!observerList.contains(observer)) {
            observerList.add(observer);
        }
    }

    public void notifyObservers(Item item) {
        for (Observer observer : observerList) {
            observer.update(item);
        }
    }


}
