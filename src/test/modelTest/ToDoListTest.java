package modelTest;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoListTest extends ItemListTest {

    @BeforeEach
    public void setup() throws IOException {
        itemlist1 = new ToDoList();
        itemlist2 = new ToDoList();
        item1 = new ToDo();
        item2 = new ToDo();
        item3 = new ToDo();

        item1.setIsEvent(true);
        item1.setDate("Monday");
        item1.setActivity("Interview");

        item2.setIsEvent(true);
        item2.setDate("Tuesday");
        item2.setActivity("Do home");

        item3.setIsEvent(true);
        item3.setDate("Friday");
        item3.setActivity("Do project");

        itemlist1.addItem(item1);
        itemlist1.addItem(item2);
        itemlist1.addItem(item3);

        itemlist1.save();
        itemlist2.load();
    }

    @Test
    public void testLoadSave() {
        // test that values of events saved and loaded are the same
        assertEquals(itemlist1.get(1).getIsEvent(), itemlist2.get(1).getIsEvent());
        assertEquals(itemlist1.get(1).getDate(), itemlist2.get(1).getDate());
        assertEquals(itemlist1.get(1).getActivity(), itemlist2.get(1).getActivity());
        assertEquals(itemlist1.get(1).getTime(), itemlist2.get(1).getTime());
        assertEquals(itemlist1.get(1).getDuration(), itemlist2.get(1).getDuration());
        assertEquals(itemlist1.get(1).getEnd(), itemlist2.get(1).getEnd());
        assertEquals(itemlist1.get(1).getWeatherSensitive(), itemlist2.get(1).getWeatherSensitive());

        assertEquals(itemlist1.get(2).getIsEvent(), itemlist2.get(2).getIsEvent());
        assertEquals(itemlist1.get(2).getDate(), itemlist2.get(2).getDate());
        assertEquals(itemlist1.get(2).getActivity(), itemlist2.get(2).getActivity());
        assertEquals(itemlist1.get(2).getTime(), itemlist2.get(2).getTime());
        assertEquals(itemlist1.get(2).getDuration(), itemlist2.get(2).getDuration());
        assertEquals(itemlist1.get(2).getEnd(), itemlist2.get(2).getEnd());
        assertEquals(itemlist1.get(2).getWeatherSensitive(), itemlist2.get(2).getWeatherSensitive());

        assertEquals(itemlist1.get(3).getIsEvent(), itemlist2.get(3).getIsEvent());
        assertEquals(itemlist1.get(3).getDate(), itemlist2.get(3).getDate());
        assertEquals(itemlist1.get(3).getActivity(), itemlist2.get(3).getActivity());
        assertEquals(itemlist1.get(3).getTime(), itemlist2.get(3).getTime());
        assertEquals(itemlist1.get(3).getDuration(), itemlist2.get(3).getDuration());
        assertEquals(itemlist1.get(3).getEnd(), itemlist2.get(3).getEnd());
        assertEquals(itemlist1.get(3).getWeatherSensitive(), itemlist2.get(3).getWeatherSensitive());

        // test that values of events saved and loaded are same, this time using initial event inputs.
        assertEquals(itemlist2.get(1).getIsEvent(), item1.getIsEvent());
        assertEquals(itemlist2.get(1).getDate(), item1.getDate());
        assertEquals(itemlist2.get(1).getActivity(), item1.getActivity());

        assertEquals(itemlist2.get(2).getIsEvent(), item2.getIsEvent());
        assertEquals(itemlist2.get(2).getDate(), item2.getDate());
        assertEquals(itemlist2.get(2).getActivity(), item2.getActivity());

        assertEquals(itemlist2.get(3).getIsEvent(), item3.getIsEvent());
        assertEquals(itemlist2.get(3).getDate(), item3.getDate());
        assertEquals(itemlist2.get(3).getActivity(), item3.getActivity());
    }
}
