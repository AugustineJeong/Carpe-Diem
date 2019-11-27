package ui.gui;

import model.data.TextSaveLoad;
import model.item.Item;
import model.marker.Flag;
import ui.gui.center.CenterPanelDefault;
import ui.gui.center.DisplayItemsCenter;
import ui.gui.center.FlagCenter;
import ui.gui.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//CITATION: Lines 29-35, 49-62 modified / added on from youtube "Advanced Java: Swing (GUI) Programming" tutorial series
// by "Cave of Programming" Part 2.
// Part 2: https://www.youtube.com/watch?v=svM0SBFqp4s

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
        this.optionsPanel.addObserver(this);
        this.centerPanelDefault = new CenterPanelDefault();
        this.displayItemsCenter = new DisplayItemsCenter(this.itemList);
        this.flagCenter = new FlagCenter(this.itemList);

        //add swing component to content pane
        container.add(itemListPanel, BorderLayout.WEST);
        container.add(optionsPanel, BorderLayout.EAST);
        container.add(centerPanelDefault, BorderLayout.CENTER);

    }

    @Override
    public void update(int i) {
        if (i == 1) {
            container.remove(centerPanelDefault);
            container.remove(flagCenter);
            container.add(displayItemsCenter);
            container.revalidate();
            container.repaint();
        } else if (i == 2) {
            container.remove(centerPanelDefault);
            container.remove(displayItemsCenter);
            container.add(flagCenter);
            container.revalidate();
            container.repaint();
        }
    }
}

