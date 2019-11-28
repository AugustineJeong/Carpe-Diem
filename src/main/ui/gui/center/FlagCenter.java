package ui.gui.center;

import model.item.Item;
import ui.gui.observer.Observable;
import ui.gui.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//CITATION: Class modified / added on from youtube "Advanced Java: Swing (GUI) Programming"
// tutorial series by "Cave of Programming" Part 3 and Part 4.
//i.e. Class built based on details regarding "Panels and Forms" and "GridBagLayout" learned / copied from the tutorial
// series.
//Part 3: https://www.youtube.com/watch?v=DJqlT1d67jI
//Part 4: https://www.youtube.com/watch?v=YKaea4ezQQE
//ATTENTION: Actual implementation of action lister functions, observer pattern, program specific functions and designs
// in this project are all my original work.

public class FlagCenter extends CenterPanelDefault implements Observable {

    private List<Item> itemList;
    private List<Observer> observerList;
    private GridBagConstraints gridBagConstraints;
    int spacer = 0;

    public FlagCenter(List<Item> list) {
        super();

        this.itemList = list;
        this.observerList = new ArrayList<>();

        JLabel eventLabel = new JLabel("Events: ");
        JLabel taskLabel = new JLabel("Tasks: ");
        JLabel activityLabel = new JLabel("WHAT ACTIVITY WOULD YOU LIKE TO FLAG?");
        JTextField itemChoice = new JTextField("ENTER ACTIVITY NAME");
        JButton flag = new JButton("FLAG");
        JButton unFlag = new JButton("UN-FLAG");

        flag.setBorderPainted(false);
        unFlag.setBorderPainted(false);
        flag.setOpaque(true);
        unFlag.setOpaque(true);

        setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();

        emptySpace();
        emptySpace();

        gridBagConstraints.gridy = spacer;
        add(eventLabel, gridBagConstraints);
        spacer++;

        gridBagConstraints.gridy = spacer;
        add(new JLabel(" "), gridBagConstraints);
        spacer++;


        for (Item item : this.itemList) {
            if (item.getIsEvent()) {
                JLabel eventDetail = new JLabel(item.returnItemDetails());
                gridBagConstraints.gridy = spacer;
                add(eventDetail, gridBagConstraints);
                spacer++;
            }
        }

        emptySpace();
        emptySpace();

        gridBagConstraints.insets = new Insets(0, 0, 0, 185);
        gridBagConstraints.gridy = spacer;
        add(taskLabel, gridBagConstraints);
        spacer++;

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.gridy = spacer;
        add(new JLabel(" "), gridBagConstraints);
        spacer++;

        for (Item item : this.itemList) {
            if (!item.getIsEvent()) {
                JLabel eventDetail = new JLabel(item.returnItemDetails());
                gridBagConstraints.gridy = spacer;
                add(eventDetail, gridBagConstraints);
                spacer++;
            }
        }

        emptySpace();
        emptySpace();

        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridy = spacer;
        add(activityLabel, gridBagConstraints);
        spacer++;

        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridy = spacer;
        add(itemChoice, gridBagConstraints);
        spacer++;

        gridBagConstraints.gridy = spacer;
        add(flag, gridBagConstraints);
        spacer++;

        gridBagConstraints.gridy = spacer;
        add(unFlag, gridBagConstraints);

        setBackground(new Color(173, 216, 230));

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        flag.addActionListener(actionListener);
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

    private void emptySpace() {
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.gridy = spacer;
        add(new JLabel(" "), gridBagConstraints);
        spacer++;
    }
}
