package model;

import file.*;

import java.io.*;
import java.util.*;

abstract class ItemList implements Loadable, Saveable {

    private ArrayList<Event> itemArrayList;

    public ItemList() {
        itemArrayList = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: adds the Event parameter to this EventList's ArrayList
    public void addEvent(Event event) {
        this.itemArrayList.add(event);
    }

    //REQUIRES: This EventList's ArrayList must not be empty
    //EFFECTS: returns first event of this EventList
    public Event get(int i) {
        ArrayList<Event> eventslist;
        Event event;

        eventslist = this.itemArrayList;
        event = eventslist.get(i - 1);
        return event;
    }

    //EFFECTS: Prints all events in this EventList
    public void print() {
        ArrayList<Event> eventslist;
        Event event;
        int i = 0;
        int z = 1;

        eventslist = this.itemArrayList;

        System.out.println();
        if (eventslist.size() > 0) {
            System.out.println("YOU HAVE THE FOLLOWING SCHEDULED EVENTS:");
        } else {
            System.out.println("YOU DO NOT HAVE ANY SCHEDULED EVENTS");
        }

        while (i < eventslist.size()) {
            event = eventslist.get(i);
            System.out.println("[" + z + "]" + event.returnItemDetails());
            i++;
            z++;
        }
    }

    public void save() throws IOException {
        ArrayList<Event> eventslist;
        eventslist = this.itemArrayList;
        int i = 0;

        File file = new File("./data/save.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        while (i < eventslist.size()) {
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

            String s = scan.next();
            if (s.equals("007")) {
                break;
            }

            event.setDate(s);
            scan.nextLine();
            event.setActivity(scan.nextLine());
            event.setTime(scan.nextInt());
            event.setDuration(scan.nextInt());
            event.setEnd(scan.nextInt());
            event.setWeatherSensitive(scan.nextBoolean());
            this.addEvent(event);
        }
    }
}

