package model;

import java.io.*;
import java.util.*;


public class EventList extends ItemList {

    public EventList() {
        super();
    }

    //EFFECTS: Saves all Events in this EventList to text file
    @Override
    public void save() throws IOException {
        ArrayList<Item> itemlist;
        itemlist = this.itemArrayList;
        int i = 0;

        File file = new File("./data/saveEvents.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        while (i < itemlist.size()) {
            pw.println(itemlist.get(i).getDate());
            pw.println(itemlist.get(i).getIsEvent());
            pw.println(itemlist.get(i).getActivity());
            pw.println(itemlist.get(i).getTime());
            pw.println(itemlist.get(i).getDuration());
            pw.println(itemlist.get(i).getEnd());
            pw.println(itemlist.get(i).getWeatherSensitive());
            i++;
        }
        pw.println("007");
        pw.close();
    }

    //EFFECTS: Loads all Events from text file to this EventList
    @Override
    public void load() throws FileNotFoundException {
        File file = new File("./data/saveEvents.txt");
        Scanner scan = new Scanner(file);

        while (true) {
            Event event = new Event();

            String s = scan.next();
            if (s.equals("007")) {
                break;
            }

            event.setDate(s);
            event.setIsEvent(scan.nextBoolean());
            scan.nextLine();
            event.setActivity(scan.nextLine());
            event.setTime(scan.nextInt());
            event.setDuration(scan.nextInt());
            event.setEnd(scan.nextInt());
            event.setWeatherSensitive(scan.nextBoolean());
            this.addItem(event);
        }
    }
}
