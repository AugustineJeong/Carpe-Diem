package ui.gui.center;

import model.item.Item;
import ui.gui.observer.Observable;
import ui.gui.observer.Observer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;

//CITATION: Class referenced / modified from youtube "Advanced Java: Swing (GUI) Programming"
// tutorial series by "Cave of Programming" Part 3 and Part 4.
//i.e. Class built based on details regarding "Panels and Forms" and "GridBagLayout" learned / copied from the tutorial
// series.
//Part 3: https://www.youtube.com/watch?v=DJqlT1d67jI
//Part 4: https://www.youtube.com/watch?v=YKaea4ezQQE
//ATTENTION: Actual implementation of action lister functions, observer pattern, program specific functions and designs
// in this project are all my original work.

public class DisplayItemsCenter extends CenterPanelDefault implements Observable {

    private List<Item> itemList;
    private List<Observer> observerList;

    //constructor
    public DisplayItemsCenter(List<Item> list) {
        super();

        this.itemList = list;
        this.observerList = new ArrayList<>();

        Border border = BorderFactory.createLineBorder(Color.white, 1);

        //CITATION: Copied / modified Lines 39-41 from Xiaoerge's answer on
        //https://stackoverflow.com/questions/4564755/java-setting-fonts-color-in-setborder
        Border titledBorder = BorderFactory.createTitledBorder(border, "View All Items", 0,
                0, new Font("Comic Sans MS", Font.PLAIN, 17), Color.black);
        setBorder(titledBorder);

        JLabel eventLabel = new JLabel("Events: ");
        JLabel taskLabel = new JLabel("Tasks: ");

        //CITATION: copied / modified Lines 49-50 of 'setFont' code from Asaf David's answer on
        // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
        // the-maximum-size
        eventLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        taskLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        int n = 0;

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 0, 0);
        gridBagConstraints.gridy = n;
        add(eventLabel, gridBagConstraints);
        n++;

        gridBagConstraints.gridy = n;
        add(new JLabel(" "), gridBagConstraints);
        n++;

        for (Item item : this.itemList) {
            if (item.getIsEvent()) {
                JButton eventDetail = new JButton(item.returnItemDetails());
                gridBagConstraints.gridy = n;

                //CITATION: copied / modified Line 75 'setFont' code from Asaf David's answer on
                // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
                // the-maximum-size
                eventDetail.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));

                if (item.isFlagged()) {
                    eventDetail.setBackground(Color.pink);
                    eventDetail.setOpaque(true);
                }

                eventDetail.setBorderPainted(false);

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

        gridBagConstraints.insets = new Insets(0, 5, 0, 0);
        gridBagConstraints.gridy = n;
        add(taskLabel, gridBagConstraints);
        n++;

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.gridy = n;
        add(new JLabel(" "), gridBagConstraints);
        n++;

        for (Item item : this.itemList) {
            if (!item.getIsEvent()) {
                JButton taskDetail = new JButton(item.returnItemDetails());
                gridBagConstraints.gridy = n;

                //CITATION: copied / modified Line 116 of 'setFont' code from Asaf David's answer on
                // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
                // the-maximum-size
                taskDetail.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));

                if (item.isFlagged()) {
                    taskDetail.setBackground(Color.pink);
                    taskDetail.setOpaque(true);
                }

                taskDetail.setBorderPainted(false);

                add(taskDetail, gridBagConstraints);
                n++;
            }
        }

        setBackground(new Color(173, 216, 230));
    }

    //MODIFIES: this
    //EFFECTS: adds observer parameter to this.observerList if not already contained in the list
    @Override
    public void addObserver(Observer observer) {
        if (!this.itemList.contains(observer)) {
            this.observerList.add(observer);
        }
    }

    //EFFECTS: calls update method on all Observers in this.observerList
    @Override
    public void notifyObserver(int i, Object o) {
        for (Observer observer : this.observerList) {
            observer.update(i, o);
        }
    }
}
