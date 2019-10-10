package ui;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import model.*;

public class InterfaceVersion1 implements UserInterface {

    private EventList eventlist;
    private ToDoList todolist;

    public InterfaceVersion1() {
        eventlist = new EventList();
        todolist = new ToDoList();
    }

    //MODIFIES: The passed EventList parameter
    //EFFECTS: Launches the entire program
    public void execute() throws IOException {
        System.out.println("______________________________________");

        mainMenuOptions();

        System.out.println("______________________________________");

        System.out.println("Press any key to return to main menu.");
        anyKey();

        execute();
    }

    //MODIFIES: The passed EventList parameter
    //EFFECTS: Prints user options and executes chosen task, returns updated EventList
    private void mainMenuOptions() throws IOException {
        System.out.println("[Simple Scheduler alpha 1.1 - Interface 1]");
        System.out.println("PLEASE MAKE A SELECTION FROM THE FOLLOWING MENU");
        System.out.println();
        System.out.println("[1] Add Event(s)");
        System.out.println("[2] Add ToDo(s)");
        System.out.println("[3] View All Items");
        System.out.println("[4] View Events by Category");
        System.out.println("[5] Delete Event");
        System.out.println();

        selection();
    }

    //MODIFIES: The passed EventList parameter
    //EFFECTS: Executes chosen option, returns updated EventList
    private void selection() throws IOException {
        eventlist = new EventList();
        todolist = new ToDoList();
        this.eventlist.load();
        this.todolist.load();

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {
            setEvents(this.eventlist);
        } else if (choice == 2) {
            setToDos(this.todolist);
        } else if (choice == 3) {
            print(this.eventlist);
            print(this.todolist);
        } else if (choice == 4 || choice == 5) {
            System.out.println("This feature is not available yet. Suck it up.");
        } else {
            System.out.println("You have made an invalid selection.");
        }
    }

    private void anyKey() {
        Scanner scan = new Scanner(System.in);
        String response;
        response = scan.nextLine();
    }

    //EFFECTS: Prints details of all Events in EventList parameter;
    public void print(EventList eventList) {
        int z = 1;
        int i = 1;

        System.out.println();
        if (eventList.length() > 0) {
            System.out.println("YOU HAVE THE FOLLOWING SCHEDULED EVENTS:");
        } else {
            System.out.println("YOU DO NOT HAVE ANY EVENTS SCHEDULED");
        }

        while (i <= eventList.length()) {
            System.out.println("[" + z + "]" + eventList.get(i).returnItemDetails());
            z++;
            i++;
        }
    }

    //EFFECTS: Prints details of all tasks in ToDoList parameter;
    public void print(ToDoList todolist) {
        int z = 1;
        int i = 1;

        System.out.println();
        if (todolist.length() > 0) {
            System.out.println("YOU HAVE THE FOLLOWING TODO TASKS:");
        } else {
            System.out.println("YOU DO NOT HAVE ANY TODO TASK");
        }

        while (i <= todolist.length()) {
            System.out.println("[" + z + "]" + todolist.get(i).returnItemDetails());
            z++;
            i++;
        }
    }

    //MODIFIES: EventList parameter
    //EFFECTS: Adds new configured event(s) to EventList parameter
    private void setEvents(EventList eventlist) throws IOException {
        String response;

        while (true) {
            eventlist = this.addNewEvent(eventlist);

            //ask user again
            System.out.println("Would you like to schedule another event into your calendar?");
            response = validResponse();

            if (response.equals("no")) {
                //say goodbye
                System.out.println("Sure. No additional event will be scheduled");

                eventlist.save();

                break;
            }
        }
    }

    //MODIFIES: ToDoList parameter
    //EFFECTS: Adds new configured task(s) to ToDoList parameter
    private void setToDos(ToDoList todolist) throws IOException {
        String response;

        while (true) {
            todolist = this.addNewToDo(todolist);

            //ask user again
            System.out.println("Would you like to add another ToDo task?");
            response = validResponse();

            if (response.equals("no")) {
                //say goodbye
                System.out.println("Sure. No additional ToDo will be scheduled");

                todolist.save();

                break;
            }
        }
    }

    //MODIFIES: this and the EventList parameter
    //EFFECTS: configures new event and stores it to EventList parameter
    private EventList addNewEvent(EventList eventlist) {
        Event event;
        event = new Event();

        event = this.configureEvent(event);

        eventlist.addItem(event);

        System.out.println();
        System.out.println("Event '" + event.getActivity() + "' " + "has been scheduled.");
        System.out.println();

        return eventlist;
    }

    //MODIFIES: This and the ToDoList parameter
    //EFFECTS: Configures new task and stores it to EventList parameter
    private ToDoList addNewToDo(ToDoList todolist) {
        ToDo todo;
        todo = new ToDo();

        todo = this.configureToDo(todo);

        todolist.addItem(todo);

        System.out.println();
        System.out.println("ToDo task '" + todo.getActivity() + "' " + "has been added.");
        System.out.println();

        return todolist;
    }

    //MODIFIES: Event parameter
    //EFFECTS: Configures the details of the passed Event parameter
    private Event configureEvent(Event event) {
        Scanner scan = new Scanner(System.in);

        String responseString;

        System.out.println("What would you like to name the event?");
        responseString = scan.nextLine();
        event.setActivity(responseString);

        System.out.println("What day is this event on?");
        responseString = scan.nextLine();
        event.setDate(responseString);

        int responseInt;

        System.out.println("What time, in hours, does this event start?");
        responseInt = scan.nextInt();
        event.setTime(responseInt);

        System.out.println("How long, in hours, is this event?");
        responseInt = scan.nextInt();
        event.setDuration(responseInt);

        event.setCalculatedEnd();

        return event;
    }

    //MODIFIES: Parameter
    //EFFECTS: Configures the details of the passed Event parameter
    private ToDo configureToDo(ToDo todo) {
        Scanner scan = new Scanner(System.in);

        String responseString;

        System.out.println("What would you like to name the ToDo task?");
        responseString = scan.nextLine();
        todo.setActivity(responseString);

        System.out.println("What day is this event on?");
        responseString = scan.nextLine();
        todo.setDate(responseString);

        return todo;
    }

    //EFFECTS: Returns scanner string only if it is either 'yes' or 'no'
    private static String validResponse() {
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
}
