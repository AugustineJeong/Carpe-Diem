package ui.program;

import exceptions.IntExpectedDuration;
import exceptions.IntExpectedTime;
import exceptions.UserEndProgram;
import model.data.TextSaveLoad;
import model.item.Item;
import model.marker.Flag;
import ui.program.components.Configurer;
import ui.program.components.InputManagement;
import ui.program.components.Interface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {
    private TextSaveLoad textSaveLoad;
    private List<Item> itemList;
    private Map<Flag, List<Item>> flagMap;
    private Interface interface1;
    private InputManagement inputManagement;
    private Configurer configurer;

    public Program() {
        textSaveLoad = new TextSaveLoad();
        itemList = new ArrayList<>();
        interface1 = new Interface();
        inputManagement = new InputManagement();
        configurer = new Configurer();
        flagMap = new HashMap<>();
    }

    public void runProgram() {
        try {
            itemList = textSaveLoad.load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                execute();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UserEndProgram userEndProgram) {
                interface1.endProgramMessage();
                break;
            }
        }
    }

    public void execute() throws IOException, UserEndProgram {
        interface1.mainMenuOptions();
        int optionSelection = inputManagement.mainMenuOptionSelection();
        try {
            runOptionSelection(optionSelection);
        } catch (IntExpectedDuration | IntExpectedTime i) {
            interface1.invalidInput();
        }
        inputManagement.enterAnyKeyToContinue();
    }

    private void runOptionSelection(int optionSelection) throws IntExpectedDuration, IntExpectedTime, IOException,
            UserEndProgram {
        if (optionSelection == 1) {
            this.itemList.add(configurer.setItem(true));
        } else if (optionSelection == 2) {
            this.itemList.add(configurer.setItem(false));
        } else if (optionSelection == 3) {
            interface1.print(itemList);
        } else if (optionSelection == 4) {
            interface1.print(itemList);
            itemFlagger();
        } else if (optionSelection == 6) {
            saveProgram();
            throw new UserEndProgram();
        } else {
            getFlaggedItems();
        }
    }

    private void saveProgram() throws IOException {
        textSaveLoad.save(this.itemList);
    }

    private void itemFlagger() {
        interface1.addOrRemoveFlag();
        if (inputManagement.addOrRemoveSelection()) {
            interface1.pleaseSelectItemToFlag();
            inputManagement.flagSelectedItemWithGivenActivityName(this.flagMap, this.itemList,
                    inputManagement.anyStringResponse());
        } else { interface1.pleaseSelectItemToUnFlag();
        inputManagement.unFlagSelectedItemWithGivenActivityName(this.flagMap, this.itemList,
                inputManagement.anyStringResponse());
        }

    }

    private void getFlaggedItems() {
        interface1.whatColourFlagWouldYouLikeToView();
        interface1.print(inputManagement.getItemsWithSameColourAsParameter(this.flagMap,
                inputManagement.anyStringResponse()));
    }
}
