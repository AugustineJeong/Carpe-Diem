package model.data;

import model.item.Event;
import model.item.Item;
import model.item.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//citation: (line 16-17, 36-37, 47, 51-52, 58, 68, 87) copied / learned from Paul Miskew's video:
// youtube.com/watch?v=k3K9KHPYZFc
public class TextSaveLoad {

    private File eventFile = new File("./data/saveEvents.txt");
    private File taskFile = new File("./data/saveTasks.txt");

    //MODIFIES: saveEvents.txt
    //EFFECTS: save all items in itemList parameter
    public void save(List<Item> itemList) throws IOException {
        List<Event> eventList = new ArrayList<>();
        List<Task> taskList = new ArrayList<>();
        for (Item item : itemList) {
            if (item.getIsEvent()) {
                eventList.add((Event) item);
            } else {
                taskList.add((Task) item);
            }
        }
        saveEventList(eventList);
        saveTaskList(taskList);
    }

    private void saveEventList(List<Event> eventList) throws IOException {
        FileWriter fw = new FileWriter(eventFile);
        PrintWriter pw = new PrintWriter(fw);
        for (Event event : eventList) {
            pw.println(event.getIsEvent());
            pw.println(event.getDate());
            pw.println(event.getActivity());
            pw.println(event.getTime());
            pw.println(event.getDuration());
            pw.println(event.getEnd());
            pw.println(event.getWeatherSensitive());
        }
        pw.close();
    }

    private void saveTaskList(List<Task> taskList) throws IOException {
        FileWriter fw = new FileWriter(taskFile);
        PrintWriter pw = new PrintWriter(fw);
        for (Task task : taskList) {
            pw.println(task.getIsEvent());
            pw.println(task.getDate());
            pw.println(task.getActivity());
        }
        pw.close();
    }

    //EFFECTS: Loads all Items from text file and returns them as List of Items
    public List<Item> load() throws FileNotFoundException {
        List<Item> itemList = new ArrayList<>();
        itemList.addAll(loadEvents());
        itemList.addAll(loadTasks());
        return itemList;
    }

    private List<Item> loadEvents() throws FileNotFoundException {
        Scanner scanEvent = new Scanner(eventFile);
        List<Item> itemList = new ArrayList<>();

        while (scanEvent.hasNext()) {
            Event event = new Event();
            event.setIsEvent(scanEvent.nextBoolean());
            event.setDate(scanEvent.next());
            scanEvent.nextLine();
            event.setActivity(scanEvent.nextLine());
            event.setTime(scanEvent.nextInt());
            event.setDuration(scanEvent.nextInt());
            event.setEnd(scanEvent.nextInt());
            event.setWeatherSensitive(scanEvent.nextBoolean());
            itemList.add(event);
        }
        return itemList;
    }

    private List<Item> loadTasks() throws FileNotFoundException {
        Scanner scanTask = new Scanner(taskFile);
        List<Item> itemList = new ArrayList<>();

        while (scanTask.hasNext()) {
            Task task = new Task();
            task.setIsEvent(scanTask.nextBoolean());
            task.setDate(scanTask.next());
            scanTask.nextLine();
            task.setActivity(scanTask.nextLine());
            itemList.add(task);
        }
        return itemList;
    }
}
