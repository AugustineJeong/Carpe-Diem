package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//CITATION: Class copied / modified from youtube "Advanced Java: Swing (GUI) Programming" tutorial series by
//"Cave of Programming" Part 2.
// Part 2: https://www.youtube.com/watch?v=svM0SBFqp4s

public class MainFrame extends JFrame {

    private ItemListPanel itemListPanel;

    public MainFrame(String title) {
        super(title);

        //layout
        setLayout(new BorderLayout());

        //swing component
        JTextArea textArea = new JTextArea();
        JButton button = new JButton("Name of button");
        this.itemListPanel = new ItemListPanel();

        //add swing component to content pane
        Container container = getContentPane();
        container.add(textArea, BorderLayout.CENTER);
        container.add(button, BorderLayout.SOUTH);
        container.add(itemListPanel, BorderLayout.WEST);

        //add behaviour
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Hello, you have clicked a button!\n");
            }
        });
    }
}
