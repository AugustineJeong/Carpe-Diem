package ui.gui;

import model.item.Event;
import model.item.Item;
import ui.gui.observer.Observable;
import ui.gui.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//CITATION: Class modified / added on from youtube "Advanced Java: Swing (GUI) Programming"
// tutorial series by "Cave of Programming" Part 3 and Part 4.
//i.e. Class built based on details regarding "Panels and Forms" and "GridBagLayout" learned / copied from the tutorial
// series.
//Part 3: https://www.youtube.com/watch?v=DJqlT1d67jI
//Part 4: https://www.youtube.com/watch?v=YKaea4ezQQE
//ATTENTION: Actual implementation of action lister functions, observer pattern, program specific functions and designs
// project are all my original work.

//this is a PANEL
public class ItemListPanel extends JPanel implements Observable {

    private List<Item> itemList;
    private List<Observer> observerList;

    public ItemListPanel(List<Item> itemList) {

        this.itemList = itemList;
        this.observerList = new ArrayList<>();

        //CITATION: Learned how to reverse an ArrayList as seen on following line on stack overflow by Shankar Agarwal's
        // answer that had been edited by Ryan Emerle
        // https://stackoverflow.com/questions/10766492/what-is-the-simplest-way-to-reverse-an-arraylist
        Collections.reverse(this.itemList);

        Dimension size = getPreferredSize();
        size.width = 350;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Recently Added Items"));

        JLabel eventLabel = new JLabel("Events: ");
        JLabel taskLabel = new JLabel("Tasks: ");
        JButton addItemButton = new JButton("Add new Item");


        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();


        int n = 0;


        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.gridy = n;
        add(new JLabel(" "), gridBagConstraints);
        n++;

        gridBagConstraints.gridy = n;
        add(eventLabel, gridBagConstraints);
        n++;

        gridBagConstraints.gridy = n;
        add(new JLabel(" "), gridBagConstraints);
        n++;

        int counter = 0;
        for (Item item : this.itemList) {
            if (counter >= 10) {
                break;
            }
            if (item.getIsEvent()) {
                JLabel eventDetail = new JLabel(item.returnItemDetails());
                gridBagConstraints.gridy = n;
                add(eventDetail, gridBagConstraints);
                n++;
                counter++;
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

        counter = 0;
        for (Item item : this.itemList) {
            if (counter >= 10) {
                break;
            }
            if (!item.getIsEvent()) {
                JLabel eventDetail = new JLabel(item.returnItemDetails());
                gridBagConstraints.gridy = n;
                add(eventDetail, gridBagConstraints);
                n++;
                counter++;
            }
        }

        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.anchor = GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new Insets(0, 0, 2, 0);
        gridBagConstraints.gridy = n;
        add(addItemButton, gridBagConstraints);

        setBackground(Color.white);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyObserver(7, null);
            }
        };

        addItemButton.addActionListener(actionListener);
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
