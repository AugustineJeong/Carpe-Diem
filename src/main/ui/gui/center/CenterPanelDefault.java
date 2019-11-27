package ui.gui.center;

import javax.swing.*;
import java.awt.*;

//CITATION: lines 16-21 copied / modified from youtube "Advanced Java: Swing (GUI) Programming" tutorial series by
//"Cave of Programming" Part 3 and Part 4.
//i.e. RunTextInterface details regarding "Panels and Forms" and "GridBagLayout" learned / copied from the tutorial
// series.
//Part 3: https://www.youtube.com/watch?v=DJqlT1d67jI
//Part 4: https://www.youtube.com/watch?v=YKaea4ezQQE

public class CenterPanelDefault extends JPanel {

    public CenterPanelDefault() {
        Dimension size = getPreferredSize();
        size.width = 300;
        size.height = 500;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Display"));
    }
}
