package ui.gui;

import model.data.TextSaveLoad;
import model.item.Item;
import ui.gui.observer.Observable;
import ui.gui.observer.Observer;

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
public class MainFrame extends JFrame implements Observer {

    private List<Item> itemList;

    //this is a PANEL
    private ItemListPanel itemListPanel;
    private OptionsPanel optionsPanel;
    private CenterPanel centerPanel;


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
        this.itemListPanel = new ItemListPanel(this.itemList);
        this.optionsPanel = new OptionsPanel();
        this.optionsPanel.addObserver(this);
        this.centerPanel = new CenterPanel();

        //add swing component to content pane
        Container container = getContentPane();
        container.add(itemListPanel, BorderLayout.WEST);
        container.add(optionsPanel, BorderLayout.EAST);
        container.add(centerPanel, BorderLayout.CENTER);


    }

    @Override
    public void update(int i) {

    }
}

