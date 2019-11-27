package ui.gui;

import model.item.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

//CITATION: RunTextInterface details of Class copied / modified from youtube "Advanced Java: Swing (GUI) Programming"
// tutorial series by "Cave of Programming" Part 3 and Part 4.
//i.e. RunTextInterface details regarding "Panels and Forms" and "GridBagLayout" learned / copied from the tutorial
// series.
//Part 3: https://www.youtube.com/watch?v=DJqlT1d67jI
//Part 4: https://www.youtube.com/watch?v=YKaea4ezQQE

//this is a PANEL
public class ItemListPanel extends JPanel {

    private List<Item> itemList;

    public ItemListPanel(List<Item> itemList) {
        this.itemList = itemList;

        Dimension size = getPreferredSize();
        size.width = 400;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Upcoming Items"));

        JLabel eventLabel = new JLabel("Events: ");
        JLabel taskLabel = new JLabel("Tasks: ");
        JButton addItemButton = new JButton("Add new Item");




        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();




        gridBagConstraints.insets = new Insets(0,0,0, 180);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        add(eventLabel, gridBagConstraints);

        int n = 1;
        while (n < 11) {
            gridBagConstraints.insets = new Insets(0, 0, 0, 0);
            gridBagConstraints.gridy = n;

            if (itemList.isEmpty()) {
                break;
            }

            for (Item item : this.itemList) {
                if (item.getIsEvent()) {
                    JLabel eventDetail = new JLabel(item.returnItemDetails());
                    add(eventDetail, gridBagConstraints);
                    n++;
                    this.itemList.remove(item);
                    break;
                } else {
                    this.itemList.remove(item);
                }
            }
        }

        gridBagConstraints.insets = new Insets(0,0,0, 185);
        gridBagConstraints.gridy = n;
        add(taskLabel, gridBagConstraints);
        n++;

        gridBagConstraints.insets = new Insets(0,0,0, 0);
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.gridy = n;
        add(addItemButton, gridBagConstraints);



        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
