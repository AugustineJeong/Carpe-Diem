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

public class DisplayItemsByDayCenter extends CenterPanelDefault implements Observable {

    private List<Item> itemList;
    private List<Observer> observerList;

    GridBagConstraints gridBagConstraints;

    int spacer = 0;

    //constructor
    public DisplayItemsByDayCenter(List<Item> list) {
        super();

        this.itemList = list;
        this.observerList = new ArrayList<>();

        Border border = BorderFactory.createLineBorder(Color.white, 1);

        //CITATION: Copied / modified Lines 43-45 from Xiaoerge's answer on
        //https://stackoverflow.com/questions/4564755/java-setting-fonts-color-in-setborder
        Border titledBorder = BorderFactory.createTitledBorder(border, "View Items by Day", 0,
                0, new Font("Comic Sans MS", Font.PLAIN, 17), Color.black);
        setBorder(titledBorder);

        JLabel mondayLabel = new JLabel("Monday");
        JLabel tuesdayLabel = new JLabel("Tuesday");
        JLabel wednesdayLabel = new JLabel("Wednesday");
        JLabel thursdayLabel = new JLabel("Thursday");
        JLabel fridayLabel = new JLabel("Friday");
        JLabel saturdayLabel = new JLabel("Saturday");
        JLabel sundayLabel = new JLabel("Sunday");

        //CITATION: copied / modified Lines 58-64 of 'setFont' code from Asaf David's answer on
        // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
        // the-maximum-size
        mondayLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        tuesdayLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        wednesdayLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        thursdayLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        fridayLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        saturdayLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        sundayLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));

        setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();

        //Monday

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 0, 0);
        gridBagConstraints.gridy = spacer;
        add(mondayLabel, gridBagConstraints);
        spacer++;

        for (Item item : this.itemList) {
            if (item.getDate().equals("Monday")) {
                JButton eventDetail = new JButton(item.returnItemDetails());
                gridBagConstraints.gridy = spacer;

                //CITATION: copied / modified Line 85 of 'setFont' code from Asaf David's answer on
                // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
                // the-maximum-size
                eventDetail.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));

                if (item.isFlagged()) {
                    eventDetail.setBackground(Color.pink);
                    eventDetail.setOpaque(true);
                }

                eventDetail.setBorderPainted(false);

                add(eventDetail, gridBagConstraints);
                spacer++;
            }
        }

        //Tuesday

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 0, 0);
        gridBagConstraints.gridy = spacer;
        add(tuesdayLabel, gridBagConstraints);
        spacer++;

        for (Item item : this.itemList) {
            if (item.getDate().equals("Tuesday")) {
                JButton eventDetail = new JButton(item.returnItemDetails());
                gridBagConstraints.gridy = spacer;

                //CITATION: copied / modified Line 115 of 'setFont' code from Asaf David's answer on
                // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
                // the-maximum-size
                eventDetail.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));

                if (item.isFlagged()) {
                    eventDetail.setBackground(Color.pink);
                    eventDetail.setOpaque(true);
                }

                eventDetail.setBorderPainted(false);

                add(eventDetail, gridBagConstraints);
                spacer++;
            }
        }

        //Wednesday

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 0, 0);
        gridBagConstraints.gridy = spacer;
        add(wednesdayLabel, gridBagConstraints);
        spacer++;

        for (Item item : this.itemList) {
            if (item.getDate().equals("Wednesday")) {
                JButton eventDetail = new JButton(item.returnItemDetails());
                gridBagConstraints.gridy = spacer;

                //CITATION: copied / modified Line 145 of 'setFont' code from Asaf David's answer on
                // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
                // the-maximum-size
                eventDetail.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));

                if (item.isFlagged()) {
                    eventDetail.setBackground(Color.pink);
                    eventDetail.setOpaque(true);
                }

                eventDetail.setBorderPainted(false);

                add(eventDetail, gridBagConstraints);
                spacer++;
            }
        }

        //Thursday

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 0, 0);
        gridBagConstraints.gridy = spacer;
        add(thursdayLabel, gridBagConstraints);
        spacer++;

        for (Item item : this.itemList) {
            if (item.getDate().equals("Thursday")) {
                JButton eventDetail = new JButton(item.returnItemDetails());
                gridBagConstraints.gridy = spacer;

                //CITATION: copied / modified Line 175 of 'setFont' code from Asaf David's answer on
                // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
                // the-maximum-size
                eventDetail.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));

                if (item.isFlagged()) {
                    eventDetail.setBackground(Color.pink);
                    eventDetail.setOpaque(true);
                }

                eventDetail.setBorderPainted(false);

                add(eventDetail, gridBagConstraints);
                spacer++;
            }
        }

        //Friday

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 0, 0);
        gridBagConstraints.gridy = spacer;
        add(fridayLabel, gridBagConstraints);
        spacer++;

        for (Item item : this.itemList) {
            if (item.getDate().equals("Friday")) {
                JButton eventDetail = new JButton(item.returnItemDetails());
                gridBagConstraints.gridy = spacer;

                //CITATION: copied / modified Line 205 of 'setFont' code from Asaf David's answer on
                // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
                // the-maximum-size
                eventDetail.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));

                if (item.isFlagged()) {
                    eventDetail.setBackground(Color.pink);
                    eventDetail.setOpaque(true);
                }

                eventDetail.setBorderPainted(false);

                add(eventDetail, gridBagConstraints);
                spacer++;
            }
        }

        //Saturday

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 0, 0);
        gridBagConstraints.gridy = spacer;
        add(saturdayLabel, gridBagConstraints);
        spacer++;

        for (Item item : this.itemList) {
            if (item.getDate().equals("Saturday")) {
                JButton eventDetail = new JButton(item.returnItemDetails());
                gridBagConstraints.gridy = spacer;

                //CITATION: copied / modified Line 235 of 'setFont' code from Asaf David's answer on
                // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
                // the-maximum-size
                eventDetail.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));

                if (item.isFlagged()) {
                    eventDetail.setBackground(Color.pink);
                    eventDetail.setOpaque(true);
                }

                eventDetail.setBorderPainted(false);

                add(eventDetail, gridBagConstraints);
                spacer++;
            }
        }

        //Sunday

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 5, 0, 0);
        gridBagConstraints.gridy = spacer;
        add(sundayLabel, gridBagConstraints);
        spacer++;

        for (Item item : this.itemList) {
            if (item.getDate().equals("Sunday")) {
                JButton eventDetail = new JButton(item.returnItemDetails());
                gridBagConstraints.gridy = spacer;

                //CITATION: copied / modified the following line 265 of 'setFont' code from Asaf David's answer on
                // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
                // the-maximum-size
                eventDetail.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));

                if (item.isFlagged()) {
                    eventDetail.setBackground(Color.pink);
                    eventDetail.setOpaque(true);
                }

                eventDetail.setBorderPainted(false);

                add(eventDetail, gridBagConstraints);
                spacer++;
            }
        }

        setBackground(new Color(173, 216, 230));
    }

    //MODIFIES: this
    //EFFECTS: adds observer parameter to this.observerList of observers if not already contained in the list
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
