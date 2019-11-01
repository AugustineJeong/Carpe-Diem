package ui;

import java.io.IOException;
import java.util.*;

import exceptions.*;
import model.*;

public class ProgramVersion1 implements UserInterface {

    private EventList eventlist;
    private ToDoList todolist;
    private Flag flag = new Flag("blue");

    private Map<Boolean, ItemList> flagMap = new HashMap<>();

    public ProgramVersion1() {
        eventlist = new EventList();
        todolist = new ToDoList();
    }

    //MODIFIES: The passed EventList parameter
    //EFFECTS: Launches the entire program
    public void execute() throws IOException {
        while (true) {
            System.out.println("______________________________________");

            try {
                mainMenuOptions();
            } catch (UserEndProgram userEndProgram) {
                System.out.println("Exiting Program...");
                break;
            } finally {
                System.out.println();
                System.out.println("[Simple Scheduler alpha v1.2 - Interface 1]");
            }

            System.out.println("______________________________________");
            System.out.println("Press any key to return to main menu.");
            anyKey();
        }
    }

    //MODIFIES: The passed EventList parameter
    //EFFECTS: Prints user options and executes chosen task, returns updated EventList
    private void mainMenuOptions() throws IOException, UserEndProgram {
        System.out.println("PLEASE MAKE A SELECTION FROM THE FOLLOWING MENU");
        System.out.println();
        System.out.println("[1] Add Event(s)");
        System.out.println("[2] Add ToDo(s)");
        System.out.println("[3] View All Items");
        System.out.println("[4] Mark / un-mark event");
        System.out.println("[5] Delete Event");
        System.out.println("[6] Exit Program");
        System.out.println();

        this.eventlist = new EventList();
        this.todolist = new ToDoList();
        this.eventlist.load();
        this.todolist.load();

        selection();
    }

    //MODIFIES: The passed EventList parameter
    //EFFECTS: Executes chosen option, returns updated EventList
    private void selection() throws IOException, UserEndProgram {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {
            setEvents(this.eventlist);
        } else if (choice == 2) {
            setToDos(this.todolist);
        } else if (choice == 3) {
            print(this.eventlist);
            print(this.todolist);
        } else if (choice == 4) {
            print(this.eventlist);
            print(this.todolist);
            itemSelector();
        } else if (choice == 6) {
            throw new UserEndProgram();
        } else {
            System.out.println("You have made an invalid selection.");
        }
    }

    private void itemSelector() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to flag / un-flag an EVENT or a TODO?");
        String response = scan.nextLine();
        while (true) {
            if (response.equalsIgnoreCase("event")) {
                eventSelector();
                break;
            } else if (response.equalsIgnoreCase("todo")) {
                todoSelector();
                break;
            } else {
                response = scan.nextLine();
                continue;
            }
        }
    }

    private void eventSelector() {
        System.out.println("Which event would you like to flag / un-flag?");
        System.out.println("Please enter the number of the event.");
        Scanner scan = new Scanner(System.in);
        String response = scan.nextLine();
        while (true) {
            try {
                int choice = Integer.parseInt(response) - 1;
                if (choice > this.eventlist.length()) {
                    continue;
                }
                flagOrUnFlagItem(1, choice);
                break;
            } catch (NumberFormatException e) {
                continue;
            }
        }
    }

    private void todoSelector() {
        System.out.println("Which event would you like to flag / un-flag?");
        System.out.println("Please enter the number of the ToDo.");
        Scanner scan = new Scanner(System.in);
        while (true) {
            String response = scan.nextLine();
            try {
                int choice = Integer.parseInt(response);
                if (choice > this.todolist.length()) {
                    continue;
                }
                flagOrUnFlagItem(2, choice);
                break;
            } catch (NumberFormatException e) {
                continue;
            }
        }
    }

    private void flagOrUnFlagItem(int itemType, int choice) {
        System.out.println("Would you like to ADD or REMOVE a flag?");
        Scanner scan = new Scanner(System.in);
        String response = scan.nextLine();
        while (true) {
            if (response.equalsIgnoreCase("add")) {
                break;
            } else if (response.equalsIgnoreCase("remove")) {
                break;
            } else {
                response = scan.nextLine();
                continue;
            }
        }
        if (response.equals("add")) {
            addFlag(itemType, choice);
        } else {
            removeFlag(itemType, choice);
        }
    }

    private void addFlag(int itemType, int choice) {
        if (itemType == 1) {
            if (!this.flag.containsSameItem(this.eventlist.get(choice))) {
                this.eventlist.get(choice).addFlag(flag);
            } else {
                System.out.println("This event is already flagged!");
            }
        } else {
            if (!this.flag.containsSameItem(this.todolist.get(choice))) {
                this.todolist.get(choice).addFlag(flag);
            } else {
                System.out.println("This ToDo is already flagged!");
            }
        }
    }

    private void removeFlag(int itemType, int choice) {
        if (itemType == 1) {
            this.eventlist.get(choice).removeFlag(flag);
        } else {
            this.todolist.get(choice).removeFlag(flag);
        }
    }


    private void anyKey() {
        Scanner scan = new Scanner(System.in);
        String response;
        response = scan.nextLine();
    }

    //EFFECTS: Prints details of all Events in EventList parameter;
    private void print(EventList eventList) {
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
    private void print(ToDoList todolist) {
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
        while (true) {
            try {
                eventlist = this.addNewEvent(eventlist);
                eventlist.save();
            } catch (IntExpectedTime intExpectedTime) {
                expectedIntErrorMessage("TIME");
                break;
            } catch (IntExpectedDuration intExpectedDuration) {
                expectedIntErrorMessage("DURATION");
                break;
            }

            try {
                askUserAgain();
            } catch (NoMoreEvent noMoreEvent) {
                break;
            }
        }
    }

    private void expectedIntErrorMessage(String string) {
        System.out.println("______________________________________");
        System.out.println();
        System.out.println("ERROR. USER DID NOT ENTER " + string + " IN INTEGERS.");
        System.out.println("______________________________________");
    }

    //MODIFIES: EventList parameter;
    //EFFECTS: Recurses back to set another event or stops
    private void askUserAgain() throws NoMoreEvent {
        String response;

        System.out.println("Would you like to schedule another event into your calendar?");
        response = validResponse();

        if (response.equals("no")) {
            //say goodbye
            System.out.println("Sure. No additional event will be scheduled");

            throw new NoMoreEvent();
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

    //

    //MODIFIES: this and the EventList parameter
    //EFFECTS: configures new event and stores it to EventList parameter
    private EventList addNewEvent(EventList eventlist) throws IntExpectedTime, IntExpectedDuration {
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
    private Event configureEvent(Event event) throws IntExpectedTime, IntExpectedDuration {
        Scanner scan = new Scanner(System.in);

        String responseString;

        System.out.println("What would you like to name the event?");
        responseString = scan.nextLine();
        event.setActivity(responseString);

        System.out.println("What day is this event on?");
        responseString = scan.nextLine();
        event.setDate(responseString);


        event = configureEventHelper1(event);

        return event;
    }

    private Event configureEventHelper1(Event event) throws IntExpectedTime, IntExpectedDuration {
        Scanner scan = new Scanner(System.in);

        String response;
        int responseInt;

        System.out.println("What time, in hours, does this event start?");
        response = scan.nextLine();
        if (response.matches("[.]*[^0-9]*[.]*")) {
            throw new IntExpectedTime();
        }
        responseInt = Integer.parseInt(response);
        event.setTime(responseInt);

        event = configureEventHelper2(event);

        return event;
    }

    private Event configureEventHelper2(Event event) throws IntExpectedDuration {
        Scanner scan = new Scanner(System.in);

        String response;
        int responseInt;

        System.out.println("How long, in hours, is this event?");
        response = scan.nextLine();
        if (response.matches("[.]*[^0-9]*[.]*")) {
            throw new IntExpectedDuration();
        }
        responseInt = Integer.parseInt(response);
        event.setDuration(responseInt);

        try {
            event.setCalculatedEnd();
        } catch (NotSameDay notSameDay) {
            System.out.println();
            System.out.println("Warning: your event does not start and end on the same date.");
        }

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
}
