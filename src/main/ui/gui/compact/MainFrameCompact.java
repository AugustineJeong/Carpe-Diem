package ui.gui.compact;

import model.data.TextSaveLoad;
import model.item.Item;
//import model.marker.Flag;
import ui.gui.OptionsPanelCompact;
import ui.gui.center.*;
import ui.gui.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

//CITATION: Class referenced / modified from youtube "Advanced Java: Swing (GUI) Programming" tutorial series
// by "Cave of Programming" Part 2.
//i.e. Class built based on details regarding "adding components" copied / learned from the tutorial series
// Part 2: https://www.youtube.com/watch?v=svM0SBFqp4s
//ATTENTION: Actual implementation of action lister functions, observer pattern, program specific functions and designs
// in this project are all my original work.

//this is a FRAME
public class MainFrameCompact extends JFrame implements Observer {

    private List<Item> itemList;

    //this is a PANEL
    private OptionsPanelCompact optionsPanelCompact;
    private CenterPanelWeather centerPanelWeather;
    private DisplayItemsCenter displayItemsCenter;
    private FlagCenter flagCenter;
    private NewItemConfigureCenter newItemConfigureCenter;
    private DeleteItemCenter deleteItemCenter;
    private DisplayItemsByDayCenter displayItemsByDayCenter;

    private Container container = getContentPane();

    //constructor
    public MainFrameCompact(String title) {
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
        this.optionsPanelCompact = new OptionsPanelCompact();
        this.newItemConfigureCenter = new NewItemConfigureCenter(this.itemList);
        this.deleteItemCenter = new DeleteItemCenter(this.itemList);

        this.optionsPanelCompact.addObserver(this);
        this.newItemConfigureCenter.addObserver(this);
        this.deleteItemCenter.addObserver(this);

        this.centerPanelWeather = new CenterPanelWeather();
        this.displayItemsCenter = new DisplayItemsCenter(this.itemList);
        this.flagCenter = new FlagCenter(this.itemList);
        this.displayItemsByDayCenter = new DisplayItemsByDayCenter(this.itemList);


        this.flagCenter.addObserver(this);

        //add swing component to content pane
        container.add(optionsPanelCompact, BorderLayout.EAST);
        container.add(centerPanelWeather, BorderLayout.CENTER);
    }

    //MODIFIES: this, ./data/saveEvents.txt and ./data/saveTasks.txt
    //EFFECTS: refreshes panels on this frame depending on value of i parameter and o parameter
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
            flagCenter.addObserver(this);
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

    //MODIFIES: ./data/saveEvents.txt and ./data/saveTasks.txt
    //EFFECTS: refreshes panels on this frame depending on value of i parameter and o parameter
    private void updateExtender(int i, Object o) {
        if (i == 10) {
            container.removeAll();
            container.add(optionsPanelCompact, BorderLayout.EAST);
            container.add(newItemConfigureCenter);
            repaintAndValidate();
        } else if (i == 3) {
            TextSaveLoad textSaveLoad = new TextSaveLoad();
            try {
                textSaveLoad.save(this.itemList);
                //CITATION: Copied Line 111 from
                // https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
                JOptionPane.showMessageDialog(new JFrame(), "Program saved!");
            } catch (IOException e) {
                e.printStackTrace();
                //CITATION: Copied Lines 116-117 from
                // https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
                JOptionPane.showMessageDialog(new JFrame(), "Error: Program not saved. Exception thrown.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: refreshes panels on this frame depending on value of i parameter and o parameter
    private void updateExtender2(int i, Object o) {
        if (i == 4) {
            updateHelper();
            this.deleteItemCenter = new DeleteItemCenter(this.itemList);
            deleteItemCenter.addObserver(this);
            container.add(deleteItemCenter);
            repaintAndValidate();
        } else if (i == 9) {
            updateHelper();
            this.displayItemsByDayCenter = new DisplayItemsByDayCenter(this.itemList);
            container.add(displayItemsByDayCenter);
            repaintAndValidate();
        } else if (i == 0) {
            updateHelper();
            container.add(new CenterPanelWeather());
            repaintAndValidate();
        }
    }

    //EFFECTS: removes all panels on this frame and adds optionsPanelCompact
    private void updateHelper() {
        container.removeAll();
        container.add(optionsPanelCompact, BorderLayout.EAST);
    }

    //EFFECTS: repaints and re-validates this frame
    private void repaintAndValidate() {
        container.repaint();
        container.revalidate();
    }
}

