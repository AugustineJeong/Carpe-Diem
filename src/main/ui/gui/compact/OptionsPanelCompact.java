package ui.gui;

import ui.gui.observer.Observable;
import ui.gui.observer.Observer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//CITATION: Class referenced / modified from youtube "Advanced Java: Swing (GUI) Programming"
// tutorial series by "Cave of Programming" Part 3 and Part 4.
//i.e. Class built based on details regarding "Panels and Forms" and "GridBagLayout" learned / copied from the tutorial
// series.
//Part 3: https://www.youtube.com/watch?v=DJqlT1d67jI
//Part 4: https://www.youtube.com/watch?v=YKaea4ezQQE
//ATTENTION: Actual implementation of action lister functions, observer pattern, program specific functions and designs
// in this project are all my original work.

public class OptionsPanelCompact extends JPanel implements Observable {

    List<Observer> observerList = new ArrayList<>();

    public OptionsPanelCompact() {
        Dimension size = getPreferredSize();
        size.width = 350;
        size.height = 350;
        setPreferredSize(size);

        //CITATION: Copied / modified the following 4 lines of code from Xiaoerge's answer on
        //https://stackoverflow.com/questions/4564755/java-setting-fonts-color-in-setborder
        Border titledBorder = BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),
                "Options Menu", 0, 0,
                new Font("Comic Sans MS", Font.PLAIN, 17), Color.black);
        setBorder(titledBorder);

        JButton viewAllItems = new JButton("    View All Items    ");
        JButton viewItemsByDay = new JButton(" View Items by Day ");
        JButton flagUnFlagItem = new JButton(" Flag / un-flag Item");
        JButton deleteItems = new JButton("      Delete Items     ");
        JButton saveProgram = new JButton("     Save Changes     ");
        JButton homeButton = new JButton("        To Home         ");
        JButton newItemButton = new JButton("     Add new Item    ");


        viewAllItems.setBorderPainted(false);
        flagUnFlagItem.setBorderPainted(false);
        deleteItems.setBorderPainted(false);
        saveProgram.setBorderPainted(false);
        viewItemsByDay.setBorderPainted(false);
        homeButton.setBorderPainted(false);
        newItemButton.setBorderPainted(false);

        viewAllItems.setOpaque(true);
        flagUnFlagItem.setOpaque(true);
        deleteItems.setOpaque(true);
        saveProgram.setOpaque(true);
        viewItemsByDay.setOpaque(true);
        homeButton.setOpaque(true);
        newItemButton.setOpaque(true);

        //CITATION: Following 4 lines of code copied from
        // http://www.nullpointer.at/2011/08/21/java-code-snippets-howto-resize-an-imageicon/#comment-11870
        ImageIcon itemIcon = new ImageIcon("./data/pencil.png");
        Image iconImage = itemIcon.getImage();
        iconImage = iconImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        itemIcon = new ImageIcon(iconImage);

        newItemButton.setIcon(itemIcon);
        newItemButton.setBackground(Color.orange);

        //CITATION: copied / modified the following 7 lines of 'setFont' code from Asaf David's answer on
        // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
        // the-maximum-size
        viewAllItems.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        flagUnFlagItem.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        deleteItems.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        saveProgram.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        viewItemsByDay.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        homeButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        newItemButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        int n = 0;

        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(25, 10, 25,10);
        gridBagConstraints.gridy = n;
        add(newItemButton, gridBagConstraints);
        n++;

        //CITATION: Following 4 lines of code copied from
        // http://www.nullpointer.at/2011/08/21/java-code-snippets-howto-resize-an-imageicon/#comment-11870
        ImageIcon allIcon = new ImageIcon("./data/search.png");
        Image allImage = allIcon.getImage();
        allImage = allImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        allIcon = new ImageIcon(allImage);

        viewAllItems.setIcon(allIcon);

        gridBagConstraints.insets = new Insets(25, 10, 25,10);
        gridBagConstraints.gridy = n;
        add(viewAllItems, gridBagConstraints);
        n++;

        //CITATION: Following 4 lines of code copied from
        // http://www.nullpointer.at/2011/08/21/java-code-snippets-howto-resize-an-imageicon/#comment-11870
        ImageIcon dayIcon = new ImageIcon("./data/calendar-checkmark-line.png");
        Image dayImage = dayIcon.getImage();
        dayImage = dayImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        dayIcon = new ImageIcon(dayImage);

        viewItemsByDay.setIcon(dayIcon);

        gridBagConstraints.insets = new Insets(25, 10, 25,10);
        gridBagConstraints.gridy = n;
        add(viewItemsByDay, gridBagConstraints);
        n++;

        //CITATION: Following 4 lines of code copied from
        // http://www.nullpointer.at/2011/08/21/java-code-snippets-howto-resize-an-imageicon/#comment-11870
        ImageIcon deleteIcon = new ImageIcon("./data/text-document-remove.png");
        Image deleteImage = deleteIcon.getImage();
        deleteImage = deleteImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        deleteIcon = new ImageIcon(deleteImage);

        deleteItems.setIcon(deleteIcon);

        gridBagConstraints.gridy = n;
        add(deleteItems, gridBagConstraints);
        n++;

        //CITATION: Following 4 lines of code copied from
        // http://www.nullpointer.at/2011/08/21/java-code-snippets-howto-resize-an-imageicon/#comment-11870
        ImageIcon flagIcon = new ImageIcon("./data/flag-line.png");
        Image flagImage = flagIcon.getImage();
        flagImage = flagImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        flagIcon = new ImageIcon(flagImage);

        flagUnFlagItem.setIcon(flagIcon);

        gridBagConstraints.gridy = n;
        add(flagUnFlagItem, gridBagConstraints);
        n++;

        //CITATION: Following 4 lines copied from
        // http://www.nullpointer.at/2011/08/21/java-code-snippets-howto-resize-an-imageicon/#comment-11870
        ImageIcon saveIcon = new ImageIcon("./data/save.png");
        Image saveImage = saveIcon.getImage();
        saveImage = saveImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        saveIcon = new ImageIcon(saveImage);

        saveProgram.setIcon(saveIcon);

        gridBagConstraints.gridy = n;
        add(saveProgram, gridBagConstraints);
        n++;

        gridBagConstraints.gridy = n;
        add(new JLabel(" "), gridBagConstraints);
        n++;

        //CITATION: Following 4 lines of code copied from
        // http://www.nullpointer.at/2011/08/21/java-code-snippets-howto-resize-an-imageicon/#comment-11870
        ImageIcon homeIcon = new ImageIcon("./data/home.png");
        Image homeImage = homeIcon.getImage();
        homeImage = homeImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        homeIcon = new ImageIcon(homeImage);

        homeButton.setIcon(homeIcon);

        gridBagConstraints.gridy = n;
        add(homeButton, gridBagConstraints);

        setBackground(new Color(173, 216, 230));

        ActionListener showAllItems = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyObserver(1, null);
            }
        };

        ActionListener showItemsByDay = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyObserver(9, null);
            }
        };

        ActionListener flagger = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyObserver(2, null);
            }
        };

        ActionListener deleter = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyObserver(4, null);
            }
        };

        ActionListener saver = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyObserver(3, null);
            }
        };

        ActionListener goHome = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyObserver(0, null);
            }
        };

        ActionListener createItem = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyObserver(7, null);
            }
        };

        viewAllItems.addActionListener(showAllItems);
        flagUnFlagItem.addActionListener(flagger);
        saveProgram.addActionListener(saver);
        deleteItems.addActionListener(deleter);
        viewItemsByDay.addActionListener(showItemsByDay);
        homeButton.addActionListener(goHome);
        newItemButton.addActionListener(createItem);
    }

    @Override
    public void addObserver(Observer observer) {
        if (!this.observerList.contains(observer)) {
            this.observerList.add(observer);
        }
    }

    @Override
    public void notifyObserver(int i, Object o) {
        for (Observer observer : this.observerList) {
            observer.update(i, o);
        }
    }
}
