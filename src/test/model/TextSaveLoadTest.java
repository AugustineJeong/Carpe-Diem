package model;

import model.data.TextSaveLoad;
import model.item.Event;
import model.item.Item;
import model.item.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextSaveLoadTest {

    @Test
    void testLoadAndSave() throws IOException {
        List<Item> itemList = new ArrayList<>();

        Item event1 = new Event();
        event1.setActivity("interview");
        event1.setDate("Monday");
        event1.setTime(10);
        event1.setDuration(5);
        event1.setCalculatedEnd();

        Item event2 = new Event();
        event2.setActivity("study session");
        event2.setDate("Saturday");
        event2.setTime(7);
        event2.setDuration(10);
        event2.setCalculatedEnd();

        Item event3 = new Event();
        event3.setActivity("very long exam");
        event3.setDate("Wednesday");
        event3.setTime(7);
        event3.setDuration(25);
        event3.setCalculatedEnd();

        Item task1 = new Task();
        task1.setActivity("wash dog");
        task1.setDate("Friday");

        itemList.add(event1);
        itemList.add(event2);
        itemList.add(task1);
        itemList.add(event3);

        TextSaveLoad textSaveLoad = new TextSaveLoad();
        textSaveLoad.save(itemList);

        assertEquals(itemList, textSaveLoad.load());
    }
}
