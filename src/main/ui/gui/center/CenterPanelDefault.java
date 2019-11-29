package ui.gui.center;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

//CITATION: lines 19-24 copied / modified from youtube "Advanced Java: Swing (GUI) Programming" tutorial series by
//"Cave of Programming" Part 3 and Part 4.
//i.e. Class built based on details regarding "Panels and Forms" and "GridBagLayout" learned / copied from the tutorial
// series.
//Part 3: https://www.youtube.com/watch?v=DJqlT1d67jI
//Part 4: https://www.youtube.com/watch?v=YKaea4ezQQE
//ATTENTION: Actual implementation of action lister functions, observer pattern, program specific functions and designs
// in this project are all my original work.

public class CenterPanelDefault extends JPanel {

    public CenterPanelDefault() {
        Dimension size = getPreferredSize();
        size.width = 300;
        size.height = 500;
        setPreferredSize(size);

        setBorder(BorderFactory.createLineBorder(Color.white, 1));

        setBackground(new Color(173, 216, 230));
    }
}
