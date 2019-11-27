package ui.gui.center;

import model.item.Item;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DisplayItemsCenter extends CenterPanelDefault {

    private List<Item> itemList;

    public DisplayItemsCenter(List<Item> list) {
        super();

        this.itemList = list;

        JLabel eventLabel = new JLabel("Events: ");
        JLabel taskLabel = new JLabel("Tasks: ");
        JLabel heading = new JLabel("YOU HAVE THE FOLLOWING SCHEDULED ITEMS:");

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        int n = 0;

        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridy = n;
        add(heading, gridBagConstraints);
        n++;

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
    }
}
