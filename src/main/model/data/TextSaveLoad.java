package model.data;

import model.item.Event;
import model.item.Item;
import model.item.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//citation: (line 15, 22-23, 35, 41) copied / learned from Paul Miskew's video: youtube.com/watch?v=k3K9KHPYZFc
public class TextSaveLoad {

    private File file = new File("./data/saveItems.txt");
    private List<Item> itemList = new ArrayList<>();


    //EFFECTS: save all items in itemList parameter
    public void save(List<Item> itemList) throws IOException {
        int n = 0;
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        for (Item i : itemList) {
            pw.println(itemList.get(n).getIsEvent());
            pw.println(itemList.get(n).getDate());
            pw.println(itemList.get(n).getActivity());
            pw.println(itemList.get(n).getTime());
            pw.println(itemList.get(n).getDuration());
            pw.println(itemList.get(n).getEnd());
            pw.println(itemList.get(n).getWeatherSensitive());
            n++;
        }
        pw.close();
    }

    //EFFECTS: Loads all Events from text file to this EventList
    public List<Item> load() throws FileNotFoundException {
        Scanner scan = new Scanner(file);

        while (scan.hasNext()) {
            Item i = new Task();
            boolean s = scan.nextBoolean();
            if (s) {
                i = new Event();
            }
            i.setIsEvent(s);
            i.setDate(scan.next());
            scan.nextLine();
            i.setActivity(scan.nextLine());
            i.setTime(scan.nextInt());
            i.setDuration(scan.nextInt());
            i.setEnd(scan.nextInt());
            i.setWeatherSensitive(scan.nextBoolean());
            itemList.add(i);
        }
        return itemList;
    }
}
