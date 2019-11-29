package ui.gui;

import javax.swing.JFrame;

//CITATION: Class copied / slightly modified from youtube "Advanced Java: Swing (GUI) Programming" tutorial series by
//"Cave of Programming" Part 1.
// Part 1: https://www.youtube.com/watch?v=jUEOWVjnIR8
// Line 16 from Part 2.
// Part 2: https://www.youtube.com/watch?v=svM0SBFqp4s
//ATTENTION: Actual implementation of action lister functions, observer pattern, program specific functions and designs
// in this project are all my original work.

public class GraphicInterface {

    //constructor
    public GraphicInterface() {
        JFrame frame = new MainFrame("Dashboard");

        frame.setSize(1200, 700);
        frame.setMinimumSize(frame.getSize());
        frame.setMaximumSize(frame.getSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CITATION: Lines 27-28 copied from JRL's answer edited by Tot Zam on
        // https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-
        // monitor-resolution
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }
}

