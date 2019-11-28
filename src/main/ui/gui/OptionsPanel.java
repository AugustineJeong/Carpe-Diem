package ui.gui;

import ui.gui.observer.Observable;
import ui.gui.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//CITATION: Class copied / modified from youtube "Advanced Java: Swing (GUI) Programming"
// tutorial series by "Cave of Programming" Part 3 and Part 4.
//i.e. Class built based on details regarding "Panels and Forms" and "GridBagLayout" learned / copied from the tutorial
// series.
//Part 3: https://www.youtube.com/watch?v=DJqlT1d67jI
//Part 4: https://www.youtube.com/watch?v=YKaea4ezQQE
//ATTENTION: Actual implementation of action lister functions, observer pattern, program specific functions and designs
// project are all my original work.

public class OptionsPanel extends JPanel implements Observable {

    List<Observer> observerList = new ArrayList<>();

    public OptionsPanel() {
        Dimension size = getPreferredSize();
        size.width = 350;
        size.height = 350;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Options Menu"));

        JButton viewAllItems = new JButton("View All Items");
        JButton flagUnFlagItem = new JButton("Flag / un-flag Item");
        JButton viewAllFlaggedItem = new JButton("View Flagged Items");
        JButton saveProgram = new JButton("Save Changes");

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        int n = 0;

        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(25, 10, 25,10);
        gridBagConstraints.gridy = n;
        add(viewAllItems, gridBagConstraints);
        n++;

        gridBagConstraints.gridy = n;
        add(flagUnFlagItem, gridBagConstraints);
        n++;

        gridBagConstraints.gridy = n;
        add(viewAllFlaggedItem, gridBagConstraints);
        n++;

        gridBagConstraints.gridy = n;
        add(saveProgram, gridBagConstraints);

        setBackground(Color.white);

        ActionListener showAllItems = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyObserver(1, null);
            }
        };

        ActionListener flagger = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyObserver(2, null);
            }
        };

        viewAllItems.addActionListener(showAllItems);
        flagUnFlagItem.addActionListener(flagger);
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
