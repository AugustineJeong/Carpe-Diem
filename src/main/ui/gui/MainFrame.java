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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//CITATION: Class modified / added on from youtube "Advanced Java: Swing (GUI) Programming" tutorial series
// by "Cave of Programming" Part 2.
//i.e. Class built based on details regarding "adding components" copied / learned from the tutorial series
// Part 2: https://www.youtube.com/watch?v=svM0SBFqp4s
//ATTENTION: Actual implementation of action lister functions, observer pattern, program specific functions and designs
// project are all my original work.

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
            container.add(displayItemsCenter);
            container.revalidate();
            container.repaint();
        } else if (i == 2) {
            updateHelper();
            container.add(flagCenter);
            container.revalidate();
            container.repaint();
        } else if (i == 7) {
            updateHelper();
            container.add(newItemConfigureCenter);
            container.revalidate();
            container.repaint();
        }
        updateExtender(i, o);
    }

    private void updateExtender(int i, Object o) {
        if (i == 10) {
            container.removeAll();
            this.itemList.add((Item) o);
            container.add(new ItemListPanel(this.itemList), BorderLayout.WEST);
            container.add(optionsPanel, BorderLayout.EAST);
            container.add(newItemConfigureCenter);
            container.revalidate();
            container.repaint();
        }
    }

    private void updateHelper() {
        container.removeAll();
        this.itemListPanel = new ItemListPanel(this.itemList);
        container.add(itemListPanel, BorderLayout.WEST);
        itemListPanel.addObserver(this);
        container.add(optionsPanel, BorderLayout.EAST);
    }


}

