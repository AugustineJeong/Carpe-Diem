package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList extends ItemList {

    public ToDoList() {
        super();
    }

    //citation: (line 21-23, 32) copied / learned from Paul Miskew's video: youtube.com/watch?v=k3K9KHPYZFc
    //EFFECTS: Saves all ToDos in this ToDoList to text file
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

    //citation: (lines 39-40) copied / learned from Paul Miskew's video: www.youtube.com/watch?v=81ZpSI4PqFo
    //EFFECTS: Loads all ToDos from text file to this ToDoList
    @Override
    public void load() throws FileNotFoundException {
        File file = new File("./data/saveToDos.txt");
        Scanner scan = new Scanner(file);

        while (true) {
            ToDo todo = new ToDo();

            String s = scan.next();
            if (s.equals("007")) {
                break;
            }

            todo.setDate(s);
            todo.setIsEvent(scan.nextBoolean());
            scan.nextLine();
            todo.setActivity(scan.nextLine());
            this.addItem(todo);
        }
    }
}
