package ui.tui;

//import model.item.Item;
//import model.marker.Flag;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
import java.util.Scanner;

public class InputManagement {

    private Interface interface1 = new Interface();

    //EFFECTS: returns the input value for a main menu options selection
    public int mainMenuOptionSelection() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            String response;
            response = scan.nextLine();

            if ((response.equals("1")) || (response.equals("2")) || (response.equals("3")) || (response.equals("4"))) {
                return (Integer.parseInt(response));
            } else if ((response.equals("5")) || (response.equals("6")) || (response.equals("7"))) {
                return (Integer.parseInt(response));
            }
            interface1.invalidInput();
        }
    }

    //EFFECTS: returns true if user enters "yes", false if user enters "no"
    public boolean yesOrNoSelection() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            String response;
            response = scan.nextLine();

            if (response.equals("yes")) {
                return true;
            }
            if (response.equals("no")) {
                return false;
            }
            interface1.invalidInput();
        }
    }

    //EFFECTS: returns true if user enters "add", false if user enters "remove"
    public boolean addOrRemoveSelection() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            String response;
            response = scan.nextLine();

            if (response.equals("add")) {
                return true;
            }
            if (response.equals("remove")) {
                return false;
            }
            interface1.invalidInput();
        }
    }

    //EFFECTS: returns whatever user enters
    public String anyStringResponse() {
        Scanner scanner = new Scanner(System.in);
        return (scanner.nextLine());
    }

    //EFFECTS: scans for any user input
    public void enterAnyKeyToContinue() {
        Scanner scanner = new Scanner(System.in);
        interface1.pressEnterToContinue();

        scanner.nextLine();
    }
}
