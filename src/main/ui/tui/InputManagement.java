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

//    //MODIFIES: flagMap parameter, item parameter
//    //EFFECTS: flags the item in the itemList parameter with the same activity as activity parameter, update map
//    public void flagSelectedItemWithGivenActivityName(Map<Flag, List<Item>> flagMap,
//                                                      List<Item> itemList, String activity) {
//        int n = 0;
//        for (Item i : itemList) {
//            if (i.getActivity().equals(activity)) {
//                n++;
//                System.out.println("Would you like to flag:" + i.returnItemDetails() + " ?");
//                if (yesOrNoSelection()) {
//                    interface1.whatColourFlagWouldYouLikeToAdd();
//                    addFlag(flagMap, i);
//                    System.out.println();
//                }
//            }
//        }
//        if (n == 0) {
//            interface1.noMatchFound();
//        }
//    }

//    //MODIFIES: flagMap parameter, item parameter
//    //EFFECTS: adds a new flag to the item parameter, adds item parameter to map parameter with the new flag as key
//    public void addFlag(Map<Flag, List<Item>> flagMap, Item i) {
//        Flag flag = new Flag(anyStringResponse());
//        i.addFlag(flag);
//        interface1.itemFlagged();
//
//        if (flagMap.containsKey(flag)) {
//            List<Item> list = flagMap.get(flag);
//            list.add(i);
//        } else {
//            List<Item> list = new ArrayList<Item>();
//            list.add(i);
//            flagMap.put(flag, list);
//        }
//    }

//    //MODIFIES: flagMap parameter, item parameter
//    //EFFECTS: un-flags the item in the itemList parameter with the same activity as activity parameter, update map
//    public void unFlagSelectedItemWithGivenActivityName(Map<Flag, List<Item>> flagMap,
//                                                        List<Item> itemList, String activity) {
//        int n = 0;
//        for (Item i : itemList) {
//            if (i.getActivity().equals(activity)) {
//                n++;
//                System.out.println("Would you like to un-flag:" + i.returnItemDetails() + " ?");
//                if (yesOrNoSelection()) {
//                    removeFlag(flagMap, i);
//                    System.out.println();
//                }
//            }
//        }
//        if (n == 0) {
//            interface1.noMatchFound();
//        }
//    }
//
//    //MODIFIES: flagMap parameter, item parameter
//    //EFFECTS: removes a new flag to the item parameter, removes item parameter from map parameter
//    public void removeFlag(Map<Flag, List<Item>> flagMap, Item i) {
//        Flag flag = i.getFlag();
//
//        i.removeFlag();
//        interface1.itemUnFlagged();
//
//        if (!(flag == null) && flagMap.containsKey(flag)) {
//            List<Item> list = flagMap.get(flag);
//            list.remove(i);
//        }
//    }
//
//    //EFFECTS: returns item with the same colour as colour parameter
//    public List<Item> getItemsWithSameColourAsParameter(Map<Flag, List<Item>> flagMap, String colour) {
//        Flag flag = new Flag(colour);
//        if (flagMap.containsKey(flag)) {
//            return (flagMap.get(flag));
//        }
//        interface1.noMatchFound();
//        return (new ArrayList<>());
//    }

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
