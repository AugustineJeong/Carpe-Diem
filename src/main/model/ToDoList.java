package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList extends ItemList {

    public ToDoList() {
        super();
    }

    //EFFECTS: Prints all ToDos in this ToDoList
    @Override
    public void print() {
        ArrayList<Item> itemlist;
        Item item;
        int i = 0;
        int z = 1;

        itemlist = this.itemArrayList;

        System.out.println();
        if (itemlist.size() > 0) {
            System.out.println("YOU HAVE THE FOLLOWING TODO TASKS:");
        } else {
            System.out.println("YOU DO NOT HAVE ANY TODO");
        }

        while (i < itemlist.size()) {
            item = itemlist.get(i);
            System.out.println("[" + z + "]" + item.returnItemDetails());
            i++;
            z++;
        }
    }

    @Override
    public void save() throws IOException {
        ArrayList<Item> itemlist;
        itemlist = this.itemArrayList;
        int i = 0;

        File file = new File("./data/saveToDos.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        while (i < itemlist.size()) {
            pw.println(itemlist.get(i).getDate());
            pw.println(itemlist.get(i).getIsEvent());
            pw.println(itemlist.get(i).getActivity());
            i++;
        }
        pw.println("007");
        pw.close();
    }

    @Override
    public void load() throws FileNotFoundException {
        File file = new File("./data/saveToDos.txt");
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
            this.addItem(event);
        }
    }
}
