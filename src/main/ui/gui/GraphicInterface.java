package ui.gui;

import javax.swing.JFrame;

public class GraphicInterface {

    //CITATION: Class copied / modified from youtube "Advanced Java: Swing (GUI) Programming" tutorial series by
    //"Cave of Programming" Part 1.
    // Part 1: https://www.youtube.com/watch?v=jUEOWVjnIR8
    // Line 14 from Part 2.
    // Part 2: https://www.youtube.com/watch?v=svM0SBFqp4s

    public GraphicInterface() {
        JFrame frame = new MainFrame("Dashboard");

        frame.setSize(1200, 650);
        frame.setMinimumSize(frame.getSize());
        frame.setMaximumSize(frame.getSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

