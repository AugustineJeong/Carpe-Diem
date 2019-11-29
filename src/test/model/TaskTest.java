package model;

import static org.junit.jupiter.api.Assertions.*;

import model.item.Event;
import model.item.Item;
import model.item.Task;
//import model.marker.Flag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest extends ItemTest {

    @BeforeEach
     void setup() {
        item = new Task();
    }

    @Test
     void testReturnItemDetails() {
        item.setActivity("Do homework");
        item.setDate("Monday");

        String message;
        message = item.returnItemDetails();

        String expectedMessage;
        expectedMessage = " 'Do homework' by Monday";

        assertEquals(message, expectedMessage);
    }

    @Test
     void testGetIsEvent() {
        assertFalse(item.getIsEvent());
    }

    @Test
     void testSetIsEvent() {
        item.setIsEvent(true);
        assertTrue(item.getIsEvent());
    }

    @Override
    @Test
    void testHashcodeAndEquals() {
        Item item2 = null;
        assertNotEquals(item, item2);

        String fakeItem = "blue";
        assertNotEquals(item, fakeItem);

        item.setActivity("interview");
        item.setDate("Monday");

        item2 = new Task();
        item2.setActivity("interview");
        item2.setDate("Monday");

        assertEquals(item, item2);

        assertEquals(item.hashCode(), item2.hashCode());
    }
}
