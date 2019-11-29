package ui.gui.center;

import model.data.WeatherData;
import model.item.Item;
import network.WebDataLoad;
import ui.gui.observer.Observer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import java.io.IOException;
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

public class CenterPanelWeather extends CenterPanelDefault {

    private List<Item> itemList;
    private List<Observer> observerList;

    private GridBagConstraints gridBagConstraints;
    private int spacer = 0;

    private WebDataLoad webDataLoad = new WebDataLoad();
    private WeatherData weatherData;

    public CenterPanelWeather() {
        super();

        try {
            weatherData = webDataLoad.dataLoad();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.observerList = new ArrayList<>();

        Border border = BorderFactory.createLineBorder(Color.white, 1);

        //CITATION: Copied / modified the following 4 lines of code from Xiaoerge's answer on
        //https://stackoverflow.com/questions/4564755/java-setting-fonts-color-in-setborder
        Border titledBorder = BorderFactory.createTitledBorder(border, "Home Screen", 0,
                0, new Font("Comic Sans MS", Font.PLAIN, 17), Color.black);
        setBorder(titledBorder);

        JLabel welcomeLabel = new JLabel("Good day!");
        JLabel weatherLabel = new JLabel("The current weather in Vancouver is: ");

        //CITATION: LINES 60-63 copied from
        // http://www.nullpointer.at/2011/08/21/java-code-snippets-howto-resize-an-imageicon/#comment-11870
        ImageIcon weatherIcon = new ImageIcon("./data/warm-98534_640.png");
        Image weatherImage = weatherIcon.getImage();
        weatherImage = weatherImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        weatherIcon = new ImageIcon(weatherImage);

        weatherLabel.setIcon(weatherIcon);
        JLabel weatherDetailLabel = new JLabel(weatherData.getMain().getTempInCelsius()
                + " degrees celsius with " + weatherData.getWeather().get(0).getDescription());
        JLabel advisoryLabel1 = new JLabel(" ");
        JLabel advisoryLabel2 = new JLabel(" ");
        JLabel advisoryLabel3 = new JLabel(" ");

        //CITATION: copied / modified the following 6 lines of 'setFont' code from Asaf David's answer on
        // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
        // the-maximum-size
        welcomeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        weatherLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        weatherDetailLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        advisoryLabel1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        advisoryLabel2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        advisoryLabel3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));

        if (Double.parseDouble(weatherData.getMain().getTempInCelsius()) < 0) {
            advisoryLabel1.setText("(It's below freezing! Pack a jacket!)");
        } else if (Double.parseDouble(weatherData.getMain().getTempInCelsius()) < 5) {
            advisoryLabel1.setText("(It's quite cold outside. Pack a light jacket!)");
        } else if (Double.parseDouble(weatherData.getMain().getTempInCelsius()) >= 5) {
            advisoryLabel1.setText("(Perfect weather! Not too cold, not too warm!)");
        }

        setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.gridy = spacer;
        add(welcomeLabel, gridBagConstraints);
        spacer++;

        emptySpace();
        emptySpace();

        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.gridy = spacer;
        add(weatherLabel, gridBagConstraints);

        emptySpace();

        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        gridBagConstraints.gridy = spacer;
        add(weatherDetailLabel, gridBagConstraints);
        spacer++;

        emptySpace();

        gridBagConstraints.gridy = spacer;
        add(advisoryLabel1, gridBagConstraints);
        spacer++;

        emptySpace();
        emptySpace();
        emptySpace();
        emptySpace();
        emptySpace();
        emptySpace();
        emptySpace();
        emptySpace();
        emptySpace();
        emptySpace();

        advisoryLabel2.setText("\"Life is a journey to be experienced, not a problem to be solved.\"");
        gridBagConstraints.gridy = spacer;
        add(advisoryLabel2, gridBagConstraints);
        spacer++;

        advisoryLabel3.setText("- Pooh, Winnie the Pooh");
        gridBagConstraints.gridy = spacer;
        add(advisoryLabel3, gridBagConstraints);
    }

    private void emptySpace() {
        gridBagConstraints.gridy = spacer;
        add(new JLabel(" "), gridBagConstraints);
        spacer++;
    }
}
