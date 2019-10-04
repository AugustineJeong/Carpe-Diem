package model;

import file.*;

import java.io.*;
import java.util.*;


public class EventList implements Loadable, Saveable {

    private ArrayList<Event> eventArrayList;

    public EventList() {
        eventArrayList = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: adds the Event parameter to this EventList's ArrayList
    public void addEvent(Event event) {
        this.eventArrayList.add(event);
    }

    //MODIFIES: this
    //EFFECTS: Adds new configured event(s) to this EventList
    public EventList setEvents() {
        String response;
        Event event1;
        EventList events;
        events = this;

        while (true) {
            event1 = new Event();

            events = event1.setEvent(events);

            askUserAgain();
            response = validResponse();

            if (response.equals("no")) {
                goodbye();
                return events;
            }
        }
    }

    //REQUIRES: This EventList's ArrayList must not be empty
    //EFFECTS: returns first event of this EventList
    public Event get(int i) {
        ArrayList<Event> eventslist;
        Event event;

        eventslist = this.eventArrayList;
        event = eventslist.get(i - 1);
        return event;
    }

    //EFFECTS: Prints all events in this EventList
    public void print() {
        ArrayList<Event> eventslist;
        Event event;
        int i = 0;
        int z = 1;

        eventslist = this.eventArrayList;

        System.out.println();
        if (eventslist.size() > 0) {
            System.out.println("YOU HAVE THE FOLLOWING SCHEDULED EVENTS:");
        } else {
            System.out.println("YOU DO NOT HAVE ANY SCHEDULED EVENTS");
        }

        while (i < eventslist.size()) {
            event = eventslist.get(i);
            System.out.println("[" + z + "]" + event.returnEventDetails());
            i++;
            z++;
        }
    }

    public void save() throws IOException {
        ArrayList<Event> eventslist;
        eventslist = this.eventArrayList;
        int i = 0;

        File file = new File("./data/save.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        while (i < eventslist.size()) {
            pw.println(eventslist.get(i).getCategory());
            pw.println(eventslist.get(i).getDate());
            pw.println(eventslist.get(i).getActivity());
            pw.println(eventslist.get(i).getTime());
            pw.println(eventslist.get(i).getDuration());
            pw.println(eventslist.get(i).getEnd());
            pw.println(eventslist.get(i).getWeatherSensitive());
            i++;
        }
        pw.println("007");
        pw.close();
    }

    public void load() throws FileNotFoundException {
        File file = new File("./data/save.txt");
        Scanner scan = new Scanner(file);

        while (true) {
            Event event = new Event();

            String y = scan.next();
            Boolean x = y.equals("007");
            if (x) {
                break;
            }

            event.setCategory(y);
            event.setDate(scan.next());
            event.setActivity(scan.next());
            event.setTime(scan.nextInt());
            event.setDuration(scan.nextInt());
            event.setEnd(scan.nextInt());
            event.setWeatherSensitive(scan.nextBoolean());
            this.addEvent(event);
        }
    }


    //EFFECTS: Returns scanner string only if it is either 'yes' or 'no'
    private String validResponse() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            String response;
            response = scan.nextLine();

            if (!((response.equals("yes")) || (response.equals("no")))) {
                System.out.println("Response unrecognized. Please respond by 'yes' or 'no'.");
            } else {
                return response;
            }
        }
    }

    //EFFECTS: Prints message
    private void askUserAgain() {
        System.out.println("Would you like to schedule another event into your calendar?");
    }

    //EFFECT: Prints message
    private void goodbye() {
        System.out.println("Sure. No additional event will be scheduled");
    }
}
