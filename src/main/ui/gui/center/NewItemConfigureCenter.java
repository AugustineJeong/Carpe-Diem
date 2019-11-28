package ui.gui.center;

import model.item.Event;
import model.item.Item;
import ui.gui.observer.Observable;
import ui.gui.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//CITATION: Class modified / added on from youtube "Advanced Java: Swing (GUI) Programming"
// tutorial series by "Cave of Programming" Part 3 and Part 4.
//i.e. Class built based on details regarding "Panels and Forms" and "GridBagLayout" learned / copied from the tutorial
// series.
//Part 3: https://www.youtube.com/watch?v=DJqlT1d67jI
//Part 4: https://www.youtube.com/watch?v=YKaea4ezQQE
//ATTENTION: Actual implementation of action lister functions, observer pattern, program specific functions and designs
// project are all my original work.

public class NewItemConfigureCenter extends CenterPanelDefault implements Observable {

    private List<Observer> observerList;
    private GridBagConstraints gridBagConstraints;
    private int spacer = 0;

    private JLabel eventLabel = new JLabel("CONFIGURE EVENT: ");
    private JLabel taskLabel = new JLabel("CONFIGURE TASK: ");
    private JLabel eventName = new JLabel("Event name:");
    private JLabel eventDate = new JLabel("Event date:");
    private JLabel eventTime = new JLabel("Event time:");
    private JLabel eventDuration = new JLabel("Event duration:");
    private JLabel eventWeather = new JLabel("Event Weather Sensitivity:");
    private JLabel taskName = new JLabel("Task name:");
    private JLabel taskDate = new JLabel("Task date:");
    private JButton createEvent = new JButton("Create event");
    private JButton createTask = new JButton("Create task");
    private JTextField nameChoice = new JTextField("        ");
    private JTextField taskNameChoice = new JTextField("        ");
    private JComboBox weatherSelection;
    private JComboBox timeSelection;
    private JComboBox dateSelection;
    private JComboBox taskDateSelection;
    private JComboBox durationChoice;

    public NewItemConfigureCenter() {
        super();

        this.observerList = new ArrayList<>();

        //CITATION: Lines 55-72 modified from example provided at https://www.javatpoint.com/java-jcombobox
        String[] weather = {"No weather restriction", "No rain"};
        weatherSelection = new JComboBox(weather);
        weatherSelection.setBounds(50,50,90, 20);
        String[] time = {"00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30",
                "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00",
                "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30",
                "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00",
                "21:30", "22:00", "22:30", "23:00", "23:30"};
        timeSelection = new JComboBox(time);
        timeSelection.setBounds(50,50,90, 20);
        String[] date = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        dateSelection = new JComboBox(date);
        dateSelection.setBounds(50,50,90, 20);
        taskDateSelection = new JComboBox(date);
        taskDateSelection.setBounds(50,50,90, 20);
        String[] duration = {"1 hour", "2 hours", "3 hours", "4 hours", "5 hours", "6 hours", "7 hours"};
        durationChoice = new JComboBox(duration);
        durationChoice.setBounds(50,50,90, 20);

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

        this.createEvent.addActionListener(newEventClick);
        this.createTask.addActionListener(newTaskClick);
    }

    ActionListener newEventClick = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Item item = configureEvent();
            notifyObserver(10, item);
        }
    };

    ActionListener newTaskClick = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Item item = configureTask();
            notifyObserver(10, item);
        }
    };

    private Item configureEvent() {
        Item item = new Event();
        item.setActivity(this.nameChoice.getText());
        item.setDate(this.dateSelection.getSelectedItem().toString());
        item.setTime(Integer.parseInt(parseTime(this.timeSelection.getSelectedItem().toString())));
        item.setDuration(Integer.parseInt(parseDuration(this.durationChoice.getSelectedItem().toString())));
        if (this.weatherSelection.getSelectedItem().toString().equals("No rain")) {
            item.setWeatherSensitive(false);
        } else {
            item.setWeatherSensitive(true);
        }
        return item;
    }

    private Item configureTask() {
        Item item = new Event();
        item.setActivity(this.taskNameChoice.getText());
        item.setDate(this.taskDateSelection.getSelectedItem().toString());
        return item;
    }



    private String parseTime(String time) {
        String numTime = time.substring(0,2) + time.substring(3);
        return numTime;
    }

    private String parseDuration(String duration) {
        String numTime = duration.substring(0,1);
        return numTime;
    }


    private void emptySpacing() {
        gridBagConstraints.gridy = spacer;
        add(new JLabel(" "), gridBagConstraints);
        spacer++;
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
