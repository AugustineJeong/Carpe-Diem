package ui.gui.center;

import model.item.Event;
import model.item.Item;
import model.item.Task;
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


//This is an Observer and an Observable at the same time!!!
public class NewItemConfigureCenter extends CenterPanelDefault implements Observable, Observer {

    private List<Observer> observerList;
    private GridBagConstraints gridBagConstraints;
    private int spacer = 0;

    private JTextField nameChoice = new JTextField("               ");
    private JTextField taskNameChoice = new JTextField("               ");
    private JComboBox weatherSelection;
    private JComboBox timeSelection;
    private JComboBox dateSelection;
    private JComboBox taskDateSelection;
    private JComboBox durationChoice;

    private List<Item> itemList;

    //constructor
    public NewItemConfigureCenter(List<Item> itemList) {
        super();

        this.itemList = itemList;
        this.observerList = new ArrayList<>();

        JLabel eventLabel = new JLabel("CONFIGURE EVENT: ");
        JLabel taskLabel = new JLabel("CONFIGURE TASK: ");
        JLabel eventName = new JLabel("Event name:");
        JLabel eventDate = new JLabel("Event date:");
        JLabel eventTime = new JLabel("Event time:");
        JLabel eventDuration = new JLabel("Event duration:");
        JLabel eventWeather = new JLabel("Event Weather Sensitivity:");
        JLabel taskName = new JLabel("Task name:");
        JLabel taskDate = new JLabel("Task date:");

        Border border = BorderFactory.createLineBorder(Color.white, 1);

        //CITATION: Copied / modified Lines 65-67 from Xiaoerge's answer on
        //https://stackoverflow.com/questions/4564755/java-setting-fonts-color-in-setborder
        Border titledBorder = BorderFactory.createTitledBorder(border, "Configure New Item", 0,
                0, new Font("Comic Sans MS", Font.PLAIN, 17), Color.black);
        setBorder(titledBorder);

        //CITATION: Lines 70-90 modified from example provided at https://www.javatpoint.com/java-jcombobox
        String[] weather = {"No weather restriction", "No rain"};
        weatherSelection = new JComboBox(weather);
        weatherSelection.setBounds(50, 50, 90, 20);
        String[] time = {"00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30",
                "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00",
                "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30",
                "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00",
                "21:30", "22:00", "22:30", "23:00", "23:30"};
        timeSelection = new JComboBox(time);
        timeSelection.setBounds(50, 50, 90, 20);
        String[] date = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        dateSelection = new JComboBox(date);
        dateSelection.setBounds(50, 50, 90, 20);
        taskDateSelection = new JComboBox(date);
        taskDateSelection.setBounds(50, 50, 90, 20);
        String[] duration = {"1 hour", "2 hours", "3 hours", "4 hours", "5 hours", "6 hours", "7 hours", "8 hours",
                "9 hours", "10 hours", "11 hours", "12 hours", "13 hours", "14 hours", "15 hours", "16 hours",
                "17 hours", "18 hours", "19 hours", "20 hours", "21 hours", "22 hours", "23 hours", "24 hours",
                "48 hours", "72 hours", "96 hours", "120 hours"};
        durationChoice = new JComboBox(duration);
        durationChoice.setBounds(50, 50, 90, 20);

        JButton createEvent = new JButton("Create event");
        JButton createTask = new JButton("Create task");

        //CITATION: copied / modified the Lines 98-117 of 'setFont' code from Asaf David's answer on
        // https://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-
        // the-maximum-size
        eventLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        taskLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        eventName.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        eventDate.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        eventTime.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        eventDuration.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        eventWeather.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        taskName.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        taskDate.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        taskNameChoice.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        taskDateSelection.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        durationChoice.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        createEvent.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        createTask.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        weatherSelection.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        timeSelection.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        dateSelection.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        taskDateSelection.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        durationChoice.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        nameChoice.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));

        setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(eventLabel, gridBagConstraints);
        spacer++;

        emptySpacing();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = spacer;
        add(eventName, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = spacer;
        add(nameChoice, gridBagConstraints);
        spacer++;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = spacer;
        add(eventDate, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = spacer;
        add(dateSelection, gridBagConstraints);
        spacer++;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = spacer;
        add(eventTime, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = spacer;
        add(timeSelection, gridBagConstraints);
        spacer++;

        gridBagConstraints.gridy = spacer;
        gridBagConstraints.gridx = 0;
        add(eventDuration, gridBagConstraints);

        gridBagConstraints.gridy = spacer;
        gridBagConstraints.gridx = 1;
        add(durationChoice, gridBagConstraints);
        spacer++;

        gridBagConstraints.gridy = spacer;
        gridBagConstraints.gridx = 0;
        add(eventWeather, gridBagConstraints);

        gridBagConstraints.gridy = spacer;
        gridBagConstraints.gridx = 1;
        add(weatherSelection, gridBagConstraints);
        spacer++;

        emptySpacing();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = spacer;
        add(createEvent, gridBagConstraints);
        spacer++;

        emptySpacing();
        emptySpacing();

        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(taskLabel, gridBagConstraints);
        spacer++;

        emptySpacing();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = spacer;
        add(taskName, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = spacer;
        add(taskNameChoice, gridBagConstraints);
        spacer++;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = spacer;
        add(taskDate, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = spacer;
        add(taskDateSelection, gridBagConstraints);
        spacer++;

        emptySpacing();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = spacer;
        add(createTask, gridBagConstraints);

        ActionListener eventCreateClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item item = configureEvent();

                if (itemList.size() <= 16) {
                    itemList.add(item);

                    //CITATION: Copied Line 223 from
                    // https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
                    JOptionPane.showMessageDialog(new JFrame(), "Event Created!");
                } else {

                    //CITATION: Copied the Lines 228-230 from
                    // https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
                    JOptionPane.showMessageDialog(new JFrame(), "Warning: Max number of scheduled items "
                                    + "reached. Delete an item first. (Limit: 17 items)", "WARNING",
                            JOptionPane.WARNING_MESSAGE);
                }

                notifyObserver(10, null);

            }
        };

        ActionListener taskCreateClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item item = configureTask();

                if (itemList.size() <= 16) {
                    itemList.add(item);

                    //CITATION: Copied Line 248 from
                    // https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
                    JOptionPane.showMessageDialog(new JFrame(), "Task Created!");
                } else {
                    
                    //CITATION: Copied Line 253-255 from
                    // https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
                    JOptionPane.showMessageDialog(new JFrame(), "Warning: Max number of scheduled items "
                                    + "reached. Delete an item first. (Limit: 17 items)", "WARNING",
                            JOptionPane.WARNING_MESSAGE);
                }

                notifyObserver(10, null);
            }
        };

        createEvent.addActionListener(eventCreateClick);
        createTask.addActionListener(taskCreateClick);

        setBackground(new Color(173, 216, 230));
    }

    //EFFECTS: creates and configures new Event based on user input
    private Item configureEvent() {
        Event item = new Event();
        item.addObserver(this);
        item.setActivity(removeSpaces(this.nameChoice.getText()));
        item.setDate(this.dateSelection.getSelectedItem().toString());
        item.setTime(Integer.parseInt(parseTime(this.timeSelection.getSelectedItem().toString())));
        item.setDuration(Integer.parseInt(parseDuration(this.durationChoice.getSelectedItem().toString())));
        item.setCalculatedEnd();
        if (this.weatherSelection.getSelectedItem().toString().equals("No rain")) {
            item.setWeatherSensitive(true);
        } else {
            item.setWeatherSensitive(false);
        }
        return item;
    }

    //EFFECTS: creates and configures new Task based on user input
    private Item configureTask() {
        Item item = new Task();
        item.setActivity(removeSpaces(this.taskNameChoice.getText()));
        item.setDate(this.taskDateSelection.getSelectedItem().toString());
        return item;
    }

    //EFFECTS: parses and returns a string of numbers from time parameter
    private String parseTime(String time) {
        String numTime = time.substring(0, 2) + time.substring(3);
        return numTime;
    }

    //EFFECTS: parses and returns a string of numbers from duration parameter
    private String parseDuration(String duration) {
        String numTime;
        if (duration.length() == 9) {
            numTime = duration.substring(0, 3);
        } else if (duration.length() == 8) {
            numTime = duration.substring(0, 2);
        } else {
            numTime = duration.substring(0, 1);
        }
        return numTime;
    }

    //this is like LeetCode
    //ex. given " this better work ", return "this better work"

    //EFFECTS: return string parameter without spaces, but includes spaces between letters
    private String removeSpaces(String string) {
        String removed = "";

        int counter = 0;
        boolean hasSeenLetter = false;
        while (counter < string.length()) {
            String str = string.substring(counter, (counter + 1));
            if (!str.equals(" ")) {
                removed += str;
                hasSeenLetter = true;
            } else if (hasSeenLetter && (string.length() - counter) > 1
                    && !string.substring((counter + 1), (counter + 2)).equals(" ")) {
                removed += str;
            }
            counter++;
        }
        if (removed.equals("")) {
            return "un-named";
        }
        return removed;
    }

    //EFFECTS: adds empty vertical spacing in gridBadConstraints
    private void emptySpacing() {
        gridBagConstraints.gridy = spacer;
        add(new JLabel(" "), gridBagConstraints);
        spacer++;
    }

    //MODIFIES: this
    //EFFECTS: adds observer parameter to this object's List of observers if not already contained in the list
    @Override
    public void addObserver(Observer observer) {
        if (!this.observerList.contains(observer)) {
            this.observerList.add(observer);
        }
    }

    //EFFECTS: calls update method on all Observers in this object's List of observers
    @Override
    public void notifyObserver(int i, Object o) {
        for (Observer observer : this.observerList) {
            observer.update(i, o);
        }
    }

    @Override
    public void update(int i, Object o) {
        if (i == 22) {
            //CITATION: Copied the following line from
            // https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
            JOptionPane.showMessageDialog(new JFrame(), "Warning: Your event does not end on the same day as "
                    + "it starts. It ends on: " + o, "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }
}
