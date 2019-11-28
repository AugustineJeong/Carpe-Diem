package ui.gui.observer;

import java.util.ArrayList;
import java.util.List;

public interface Observable {

    void addObserver(Observer observer);

    public void notifyObserver(int i, Object o);
}
