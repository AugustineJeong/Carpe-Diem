package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//CITATION: RunTextInterface details of Class copied / modified from youtube "Advanced Java: Swing (GUI) Programming"
// tutorial series by "Cave of Programming" Part 3 and Part 4.
//i.e. RunTextInterface details regarding "Panels and Forms" and "GridBagLayout" learned / copied from the tutorial
// series.
//Part 3: https://www.youtube.com/watch?v=DJqlT1d67jI
//Part 4: https://www.youtube.com/watch?v=YKaea4ezQQE

public class ItemListPanel extends JPanel {
    public ItemListPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Items"));

        JLabel eventLabel = new JLabel("Events: ", JLabel.LEFT);
        JLabel taskLabel = new JLabel("Tasks: ");

        JTextArea eventField = new JTextArea();
        JTextArea taskField = new JTextArea();



        JButton addItemButton = new JButton("Add new Item");

        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.insets = new Insets(0,0,0, 180);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        add(eventLabel, gridBagConstraints);

        gridBagConstraints.insets = new Insets(0,0,0, 185);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(taskLabel, gridBagConstraints);

        gridBagConstraints.insets = new Insets(0,0,0, 0);
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(addItemButton, gridBagConstraints);

        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
