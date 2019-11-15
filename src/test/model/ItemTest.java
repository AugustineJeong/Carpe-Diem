package model;

import static org.junit.jupiter.api.Assertions.*;

import model.item.Item;
import model.marker.Flag;
import org.junit.jupiter.api.Test;

abstract class ItemTest {
    protected Item item;
    protected Flag flag = new Flag("blue");

    @Test
     void testGetDateAndSetDate() {
        item.setDate("Monday");
        assertEquals("Monday", item.getDate());
    }

    @Test
     void testGetActivityTestAndSetActivity() {
        item.setActivity("interview");
        assertEquals("interview", item.getActivity());
    }

    @Test
     void testGetTimeAndSetTime() {
        item.setTime(10);
        assertEquals(10, item.getTime());
    }

    @Test
     void testGetDurationAndSetDuration() {
        item.setDuration(5);
        assertEquals(5, item.getDuration());
    }

    @Test
     void testGetTimeAndSetCalculatedEnd() {
        item.setTime(1000);
        item.setDuration(5);
        item.setCalculatedEnd();
        assertEquals(1500, item.getEnd());
    }

    @Test
     void testGetTimeAndSetCalculatedEndNotSameDay() {
        item.setTime(1000);
        item.setDuration(30);
        item.setCalculatedEnd();
        assertEquals(1600, item.getEnd());
    }

    @Test
     void getWeatherSensitive() {
        assertEquals(false, item.getWeatherSensitive());
    }

    @Test
     void setEndTest() {
        item.setEnd(2300);
        assertEquals(2300, item.getEnd());
    }

    @Test
     void testSetWeatherSensitiveAndGetWeateherSensitive() {
        item.setWeatherSensitive(true);
        assertEquals(true, item.getWeatherSensitive());
    }

    @Test
     void addFlagTest() {
        item.addFlag(flag);

        assertTrue(item.isFlagged());
        assertTrue(item.containsFlag(flag));
    }

    @Test
     void addFlagTestAlreadyFlagged() {
        item.addFlag(flag);
        Flag flag2 = new Flag("green");
        item.addFlag(flag2);

        assertTrue(item.isFlagged());
        assertFalse(item.containsFlag(flag));
        assertTrue(item.containsFlag(flag2));

    }

    @Test
     void removeFlagTest() {
        item.addFlag(flag);

        item.removeFlag();
        assertFalse(item.isFlagged());
    }

    @Test
     void testContainsFlagTrue() {
        item.addFlag(flag);

        assertTrue(item.containsFlag(flag));
    }

    @Test
     void testGetFlag() {
        item.addFlag(flag);
        assertEquals(flag, item.getFlag());
    }

    @Test
     void testContainsFlagFalse() {
        assertFalse(item.containsFlag(flag));
    }

    @Test
     abstract void testGetIsEvent();

    @Test
     abstract void testSetIsEvent();
}
