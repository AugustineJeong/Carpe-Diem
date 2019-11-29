package ui.gui;

import model.item.Item;
import ui.gui.observer.Observable;
import ui.gui.observer.Observer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//CITATION: Class referenced / modified from youtube "Advanced Java: Swing (GUI) Programming"
// tutorial series by "Cave of Programming" Part 3 and Part 4.
//i.e. Class built based on details regarding "Panels and Forms" and "GridBagLayout" learned / copied from the tutorial
// series.
//Part 3: https://www.youtube.com/watch?v=DJqlT1d67jI
//Part 4: https://www.youtube.com/watch?v=YKaea4ezQQE
//ATTENTION: Actual implementation of action lister functions, observer pattern, program specific functions and designs
// in this project are all my original work.

//this is a PANEL
public class ItemListPanel extends JPanel implements Observable {

    private List<Item> itemList;
    private List<Observer> observerList;

    //constructor
    public ItemListPanel(List<Item> itemList) {

        //Made a copy of the itemList so that it doesn't mess with the original field in MainFrame...
        this.itemList = makeCopyOfItemList(itemList);

        this.observerList = new ArrayList<>();

        //CITATION: Learned how to reverse an ArrayList as seen on following line on stack overflow by Shankar Agarwal's
        // answer that had been edited by Ryan Emerle (Copied Line 42)
        // https://stackoverflow.com/questions/10766492/what-is-the-simplest-way-to-reverse-an-arraylist
        Collections.reverse(this.itemList);

        Dimension size = getPreferredSize();
        size.width = 350;
        setPreferredSize(size);

        Border titledBorder = BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),
                "Recently Added Items", 0, 0,
                new Font("Comic Sans MS", Font.PLAIN, 17), Color.black);
        setBorder(titledBorder);

        JLabel eventLabel = new JLabel("Events: ");
        JLabel taskLabel = new JLabel("Tasks: ");
        JButton addItemButton = new JButton("    Add new Item    ");

        //CITATION: copied / modified Line 60 'setFont' code from Asaf David's answer on
        // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
        // the-maximum-size
        addItemButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));

        addItemButton.setBackground(Color.ORANGE);
        addItemButton.setOpaque(true);
        addItemButton.setBorderPainted(false);

        //CITATION: Following Lines 68-71 from
        // http://www.nullpointer.at/2011/08/21/java-code-snippets-howto-resize-an-imageicon/#comment-11870
        ImageIcon itemIcon = new ImageIcon("./data/pencil.png");
        Image iconImage = itemIcon.getImage();
        iconImage = iconImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        itemIcon = new ImageIcon(iconImage);

        addItemButton.setIcon(itemIcon);

        //CITATION: copied / modified Lines 78-79 of 'setFont' code from Asaf David's answer on
        // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
        // the-maximum-size
        eventLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        taskLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        int n = 0;

        gridBagConstraints.gridy = n;
        add(new JLabel(" "), gridBagConstraints);
        n++;

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.gridy = n;
        add(eventLabel, gridBagConstraints);
        n++;

        gridBagConstraints.gridy = n;
        add(new JLabel(" "), gridBagConstraints);
        n++;

        int counter = 0;
        for (Item item : this.itemList) {
            if (counter >= 5) {
                break;
            }
            if (item.getIsEvent()) {
                JLabel eventDetail = new JLabel(item.returnItemDetails());
                //CITATION: copied / modified Line 109 of 'setFont' code from Asaf David's answer on
                // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
                // the-maximum-size
                eventDetail.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
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

        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.gridy = n;
        add(taskLabel, gridBagConstraints);
        n++;

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.gridy = n;
        add(new JLabel(" "), gridBagConstraints);
        n++;

        counter = 0;
        for (Item item : this.itemList) {
            if (counter >= 5) {
                break;
            }
            if (!item.getIsEvent()) {
                JLabel taskDetail = new JLabel(item.returnItemDetails());
                //CITATION: copied / modified Line 146 of 'setFont' code from Asaf David's answer on
                // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
                // the-maximum-size
                taskDetail.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
                gridBagConstraints.gridy = n;
                add(taskDetail, gridBagConstraints);
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

        setBackground(new Color(173, 216, 230));

        ActionListener actionListener = new ActionListener() {
            //EFFECTS: overrides actionPerformed method, notifies observers
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyObserver(7, null);
            }
        };

        addItemButton.addActionListener(actionListener);
    }

    //MODIFIES: this
    //EFFECTS: adds observer parameter to this object's List of observers if not already contained in the list
    @Override
    public void addObserver(Observer observer) {
        if (!this.observerList.contains(observer)) {
            this.observerList.add(observer);
        }
    }

    //EFFECTS: calls update method on all Observers in this object's List of observers
    @Override
    public void notifyObserver(int i, Object o) {
        for (Observer observer : this.observerList) {
            observer.update(i, o);
        }
    }

    //EFFECTS: creates and returns a copy of the itemList parameter
    private List<Item> makeCopyOfItemList(List<Item> itemList) {
        List<Item> newList = new ArrayList<>();
        for (Item item : itemList) {
            newList.add(item);
        }
        return newList;
    }
}
