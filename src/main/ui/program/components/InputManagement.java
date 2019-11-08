package ui.program.components;

import model.item.Item;
import model.marker.Flag;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InputManagement {

    private Interface interface1 = new Interface();

    public int mainMenuOptionSelection() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            String response;
            response = scan.nextLine();

            if ((response.equals("1")) || (response.equals("2")) || (response.equals("3"))) {
                return (Integer.parseInt(response));
            } else if ((response.equals("4")) || (response.equals("5")) || (response.equals("6"))) {
                return (Integer.parseInt(response));
            }
        }
    }

    public void addFlag(Map<Flag, List<Item>> flagMap, Item i) {
        Flag flag = new Flag(anyStringResponse());
        i.addFlag(flag);
        interface1.itemFlagged();

        if (flagMap.containsKey(flag)) {
            List<Item> list = flagMap.get(flag);
            list.add(i);
        } else {
            List<Item> list = new ArrayList<Item>();
            list.add(i);
            flagMap.put(flag, list);
        }
    }

    public void removeFlag(Map<Flag, List<Item>> flagMap, Item i) {
        Flag flag = i.getFlag();

        i.removeFlag();
        interface1.itemUnFlagged();

        if (!(flag == null) && flagMap.containsKey(flag)) {
            List<Item> list = flagMap.get(flag);
            list.remove(i);
        }
    }

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

    public void flagSelectedItemWithGivenActivityName(Map<Flag, List<Item>> flagMap,
                                                      List<Item> itemList, String activity) {
        int n = 0;
        for (Item i : itemList) {
            if (i.getActivity().equals(activity)) {
                n++;
                System.out.println("Would you like to flag:" + i.returnItemDetails() + " ?");
                if (yesOrNoSelection()) {
                    interface1.whatColourFlagWouldYouLikeToAdd();
                    addFlag(flagMap, i);
                    System.out.println();
                }
            }
        }
        if (n == 0) {
            interface1.noMatchFound();
        }
    }

    public void unFlagSelectedItemWithGivenActivityName(Map<Flag, List<Item>> flagMap,
                                                        List<Item> itemList, String activity) {
        int n = 0;
        for (Item i : itemList) {
            if (i.getActivity().equals(activity)) {
                n++;
                System.out.println("Would you like to un-flag:" + i.returnItemDetails() + " ?");
                if (yesOrNoSelection()) {
                    removeFlag(flagMap, i);
                    System.out.println();
                }
            }
        }
        if (n == 0) {
            interface1.noMatchFound();
        }
    }

    public List<Item> getItemsWithSameColourAsParameter(Map<Flag, List<Item>> flagMap, String string) {
        Flag flag = new Flag(string);
        if (flagMap.containsKey(flag)) {
            return (flagMap.get(flag));
        }
        interface1.noMatchFound();
        return (new ArrayList<Item>());
    }

    public String anyStringResponse() {
        Scanner scanner = new Scanner(System.in);
        return (scanner.nextLine());
    }

    public void enterAnyKeyToContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter any key to continue.");
        scanner.nextLine();
    }
}
