package model;

import static org.junit.jupiter.api.Assertions.*;

import model.item.Event;
import model.item.Item;
//import model.marker.Flag;
import org.junit.jupiter.api.Test;

abstract class ItemTest {
    protected Item item;
//    protected Flag flag = new Flag("blue");

    @Test
    abstract void testReturnItemDetails();

    @Test
    abstract void testSetIsEvent();

    @Test
    abstract void testGetIsEvent();

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


//    @Test
//     void addFlagTest() {
//        item.addFlag(flag);
//
//        assertTrue(item.isFlagged());
//        assertTrue(item.containsFlag(flag));
//    }
//
//    @Test
//     void addFlagTestAlreadyFlagged() {
//        item.addFlag(flag);
//        Flag flag2 = new Flag("green");
//        item.addFlag(flag2);
//
//        assertTrue(item.isFlagged());
//        assertFalse(item.containsFlag(flag));
//        assertTrue(item.containsFlag(flag2));
//
//    }

//    @Test
//     void removeFlagTest() {
//        item.addFlag(flag);
//
//        item.removeFlag();
//        assertFalse(item.isFlagged());
//    }
//
//    @Test
//     void testContainsFlagTrue() {
//        item.addFlag(flag);
//
//        assertTrue(item.containsFlag(flag));
//    }

//    @Test
//     void testGetFlag() {
//        item.addFlag(flag);
//        assertEquals(flag, item.getFlag());
//    }
//
//    @Test
//     void testContainsFlagFalse() {
//        assertFalse(item.containsFlag(flag));
//    }

    @Test
    void testIsFlaggedAndSetFlaggedTrue() {
        item.setFlagged(true);
        assertTrue(item.isFlagged());
    }

    @Test
    void testIsFlaggedAndSetFlaggedFalse() {
        item.setFlagged(false);
        assertFalse(item.isFlagged());
    }

    @Test
    void testHashcodeAndEquals() {
        Event item2 = null;
        assertNotEquals(item, item2);

        String fakeItem = "blue";
        assertNotEquals(item, fakeItem);

        item.setActivity("interview");
        item.setDate("Monday");

        item2 = new Event();
        item2.setActivity("interview");
        item2.setDate("Monday");
        item2.setTime(10);
        item2.setDuration(5);
        item2.setCalculatedEnd();

        assertEquals(item, item2);

        assertEquals(item.hashCode(), item2.hashCode());
    }
}
