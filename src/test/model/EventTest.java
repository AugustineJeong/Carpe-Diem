package model;

import static org.junit.jupiter.api.Assertions.*;

import model.item.Event;
import model.item.Item;
import model.marker.Flag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventTest extends ItemTest {

    @BeforeEach
     void setup() {
        item = new Event();
        item.setActivity("interview");
        item.setDate("Monday");
        item.setTime(10);
        item.setDuration(5);
        item.setCalculatedEnd();
    }

    @Test
     void testReturnItemDetails() {
        String expectedDetails;
        expectedDetails = " 'interview' by Monday from 10 to 15";

        String eventDetails;
        eventDetails = item.returnItemDetails();

        assertEquals(expectedDetails, eventDetails);
    }

    @Override
    @Test
    void testGetIsEvent() {
        assertTrue(item.getIsEvent());
    }

    @Override
    @Test
    public void testSetIsEvent() {
        item.setIsEvent(false);
        assertFalse(item.getIsEvent());
    }

    @Test
     void testHashcodeAndEquals() {
        Item item2 = null;
        assertNotEquals(item, item2);

        Flag fakeItem = new Flag("blue");
        assertNotEquals(item, fakeItem);

        item.setActivity("interview");
        item.setDate("Monday");
        item.setTime(10);
        item.setDuration(5);
        item.setCalculatedEnd();

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
