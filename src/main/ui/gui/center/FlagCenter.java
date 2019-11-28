package ui.gui.center;

import model.item.Item;
import ui.gui.observer.Observable;
import ui.gui.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

//CITATION: Class modified / added on from youtube "Advanced Java: Swing (GUI) Programming"
// tutorial series by "Cave of Programming" Part 3 and Part 4.
//i.e. Class built based on details regarding "Panels and Forms" and "GridBagLayout" learned / copied from the tutorial
// series.
//Part 3: https://www.youtube.com/watch?v=DJqlT1d67jI
//Part 4: https://www.youtube.com/watch?v=YKaea4ezQQE
//ATTENTION: Actual implementation of action lister functions, observer pattern, program specific functions and designs
// project are all my original work.

public class FlagCenter extends CenterPanelDefault implements Observable {

    private List<Item> itemList;
    private List<Observer> observerList;

    public FlagCenter(List<Item> list) {
        super();

        this.itemList = list;

        JLabel eventLabel = new JLabel("Events: ");
        JLabel taskLabel = new JLabel("Tasks: ");
        JLabel activityLabel = new JLabel("WHAT ACTIVITY WOULD YOU LIKE TO FLAG?");
        JTextField itemChoice = new JTextField("ENTER ACTIVITY NAME");
        JButton flag = new JButton("FLAG");
        JButton unFlag = new JButton("UN-FLAG");

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        int n = 0;

        int counter = 0;
        while (counter < 2) {
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.gridy = n;
            add(new JLabel(" "), gridBagConstraints);
            n++;
            counter++;
        }

        gridBagConstraints.gridy = n;
        add(eventLabel, gridBagConstraints);
        n++;

        gridBagConstraints.gridy = n;
        add(new JLabel(" "), gridBagConstraints);
        n++;


        for (Item item : this.itemList) {
            if (item.getIsEvent()) {
                JLabel eventDetail = new JLabel(item.returnItemDetails());
                gridBagConstraints.gridy = n;
                add(eventDetail, gridBagConstraints);
                n++;
            }
        }

        int y = 0;
        while (y < 2) {
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.gridy = n;
            add(new JLabel(" "), gridBagConstraints);
            y++;
            n++;
        }

        gridBagConstraints.insets = new Insets(0, 0, 0, 185);
        gridBagConstraints.gridy = n;
        add(taskLabel, gridBagConstraints);
        n++;

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.gridy = n;
        add(new JLabel(" "), gridBagConstraints);
        n++;

        for (Item item : this.itemList) {
            if (!item.getIsEvent()) {
                JLabel eventDetail = new JLabel(item.returnItemDetails());
                gridBagConstraints.gridy = n;
                add(eventDetail, gridBagConstraints);
                n++;
            }
        }

        counter = 0;
        while (counter < 2) {
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.gridy = n;
            add(new JLabel(" "), gridBagConstraints);
            n++;
            counter++;
        }

        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridy = n;
        add(activityLabel, gridBagConstraints);
        n++;

        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridy = n;
        add(itemChoice, gridBagConstraints);
        n++;

        gridBagConstraints.gridy = n;
        add(flag, gridBagConstraints);
        n++;

        gridBagConstraints.gridy = n;
        add(unFlag, gridBagConstraints);

        setBackground(Color.white);
    }

    @Override
    public void addObserver(Observer observer) {
        if (!this.observerList.contains(observer)) {
            this.observerList.add(observer);
        }
    }

    @Override
    public void notifyObserver(int i, Object o) {
        for (Observer observer : this.observerList) {
            observer.update(i, o);
        }
    }
}
