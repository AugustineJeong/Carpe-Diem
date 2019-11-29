package ui.gui;

import javax.swing.JFrame;

//CITATION: Class referencd / modified from youtube "Advanced Java: Swing (GUI) Programming" tutorial series by
//"Cave of Programming" Part 1.
// Part 1: https://www.youtube.com/watch?v=jUEOWVjnIR8
// Line 16 from Part 2.
// Part 2: https://www.youtube.com/watch?v=svM0SBFqp4s
//ATTENTION: Actual implementation of action lister functions, observer pattern, program specific functions and designs
// in this project are all my original work.

public class GraphicInterface {

    public GraphicInterface() {
        JFrame frame = new MainFrame("Dashboard");

        frame.setSize(1200, 700);
        frame.setMinimumSize(frame.getSize());
        frame.setMaximumSize(frame.getSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

