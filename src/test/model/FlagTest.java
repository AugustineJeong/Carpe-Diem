package model;

import model.item.Event;
import model.item.Item;
import model.marker.Flag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlagTest {
    Item item;
    Flag flag;

    @BeforeEach
     void setup() {
        flag = new Flag("blue");
        item = new Event();
        item.setActivity("interview");
        item.setDate("Monday");
        item.setTime(10);
        item.setDuration(5);
        item.setCalculatedEnd();
    }

    @Test
     void testGetColour() {
        assertEquals("blue", flag.getColour());
    }


    @Test
     void testContainsSameItemAndAddItem() {
        flag.addItem(item);

        assertTrue(flag.containsSameItem(item));

        flag.removeItem(item);

        assertFalse(flag.containsSameItem(item));
    }

    @Test
     void testContainsSameItemAndRemoveItem() {
        Flag flag = new Flag("blue");

        flag.addItem(item);

        flag.removeItem(item);

        assertFalse(flag.containsSameItem(item));
    }

    @Test
    void testContainsSameItemFalse() {
        assertFalse(flag.containsSameItem(item));
    }

    @Test
    void testHashcodeAndEquals() {
        Flag flag2 = null;
        assertNotEquals(flag, flag2);

        Item fakeFlag = new Event();
        assertNotEquals(flag, fakeFlag);

        flag2 = new Flag("blue");
        assertEquals(flag.hashCode(), flag2.hashCode());
    }
}
