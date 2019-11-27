package ui.gui;

import model.data.TextSaveLoad;
import model.item.Item;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

//CITATION: Class copied / modified from youtube "Advanced Java: Swing (GUI) Programming" tutorial series by
//"Cave of Programming" Part 2.
// Part 2: https://www.youtube.com/watch?v=svM0SBFqp4s

//this is a FRAME
public class MainFrame extends JFrame {

    private List<Item> itemList;

    //this is a PANEL
    private ItemListPanel itemListPanel;

    public MainFrame(String title) {
        super(title);

        try {
            TextSaveLoad textSaveLoad = new TextSaveLoad();
            this.itemList = textSaveLoad.load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //layout
        setLayout(new BorderLayout());

        //swing component
        JTextArea textArea = new JTextArea();
        JButton button = new JButton("Name of button");
        this.itemListPanel = new ItemListPanel(this.itemList);

        //add swing component to content pane
        Container container = getContentPane();
        container.add(textArea, BorderLayout.CENTER);
        container.add(button, BorderLayout.SOUTH);
        container.add(itemListPanel, BorderLayout.WEST);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        button.addActionListener(actionListener);
    }
}
