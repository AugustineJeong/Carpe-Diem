package ui.gui;

import model.item.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsPanel extends JPanel {

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
    }
}
