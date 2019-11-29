package ui.gui;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderRepeat;
import model.data.TextSaveLoad;
import model.item.Event;
import model.item.Item;
import model.marker.Flag;
import ui.gui.center.*;
import ui.gui.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//CITATION: Class referenced / modified from youtube "Advanced Java: Swing (GUI) Programming" tutorial series
// by "Cave of Programming" Part 2.
//i.e. Class built based on details regarding "adding components" copied / learned from the tutorial series
// Part 2: https://www.youtube.com/watch?v=svM0SBFqp4s
//ATTENTION: Actual implementation of action lister functions, observer pattern, program specific functions and designs
// in this project are all my original work.

//this is a FRAME
public class MainFrame extends JFrame implements Observer {

    private List<Item> itemList;
    private Map<Flag, List<Item>> flagMap;

    //this is a PANEL
    private ItemListPanel itemListPanel;
    private OptionsPanel optionsPanel;
    private CenterPanelDefault centerPanelDefault;
    private DisplayItemsCenter displayItemsCenter;
    private FlagCenter flagCenter;
    private NewItemConfigureCenter newItemConfigureCenter;
    private DeleteItemCenter deleteItemCenter;

    private Container container = getContentPane();

    MainFrame(String title) {
        super(title);

        try {
            TextSaveLoad textSaveLoad = new TextSaveLoad();
            this.itemList = textSaveLoad.load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        flagMap = new HashMap<>();

        //layout
        setLayout(new BorderLayout());

        //swing component
        this.itemListPanel = new ItemListPanel(this.itemList);
        this.optionsPanel = new OptionsPanel();
        this.newItemConfigureCenter = new NewItemConfigureCenter();
        this.deleteItemCenter = new DeleteItemCenter(this.itemList);

        this.itemListPanel.addObserver(this);
        this.optionsPanel.addObserver(this);
        this.newItemConfigureCenter.addObserver(this);

        this.centerPanelDefault = new CenterPanelDefault();
        this.displayItemsCenter = new DisplayItemsCenter(this.itemList);
        this.flagCenter = new FlagCenter(this.itemList);


        this.flagCenter.addObserver(this);

        //add swing component to content pane
        container.add(itemListPanel, BorderLayout.WEST);
        container.add(optionsPanel, BorderLayout.EAST);
        container.add(centerPanelDefault, BorderLayout.CENTER);
    }

    @Override
    public void update(int i, Object o) {
        if (i == 1) {
            updateHelper();
            this.displayItemsCenter = new DisplayItemsCenter(this.itemList);
            container.add(displayItemsCenter);
            repaintAndValidate();
        } else if (i == 2) {
            updateHelper();
            this.flagCenter = new FlagCenter(this.itemList);
            container.add(flagCenter);
            repaintAndValidate();
        } else if (i == 7) {
            updateHelper();
            container.add(newItemConfigureCenter);
            repaintAndValidate();

        }
        updateExtender(i, o);
        updateExtender2(i, o);
    }

    private void updateExtender(int i, Object o) {
        if (i == 10) {
            container.removeAll();
            this.itemList.add((Item) o);
            container.add(new ItemListPanel(this.itemList), BorderLayout.WEST);
            container.add(optionsPanel, BorderLayout.EAST);
            container.add(newItemConfigureCenter);
            repaintAndValidate();
        } else if (i == 3) {
            TextSaveLoad textSaveLoad = new TextSaveLoad();
            try {
                textSaveLoad.save(this.itemList);
                //CITATION: Copied the following line from
                // https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
                JOptionPane.showMessageDialog(new JFrame(), "Program saved!");
            } catch (IOException e) {
                e.printStackTrace();
                //CITATION: Copied the following line from
                // https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
                JOptionPane.showMessageDialog(new JFrame(), "Error: Program not saved. Exception thrown.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateExtender2(int i, Object o) {
        if (i == 4) {
            updateHelper();
            this.deleteItemCenter = new DeleteItemCenter(this.itemList);
            container.add(deleteItemCenter);
            repaintAndValidate();
        }
    }

    private void updateHelper() {
        container.removeAll();
        this.itemListPanel = new ItemListPanel(this.itemList);
        container.add(itemListPanel, BorderLayout.WEST);
        itemListPanel.addObserver(this);
        container.add(optionsPanel, BorderLayout.EAST);
    }

    private void repaintAndValidate() {
        container.repaint();
        container.revalidate();
    }


}

