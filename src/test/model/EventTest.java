package model;

import static org.junit.jupiter.api.Assertions.*;

import model.item.Event;
import model.item.Item;
//import model.marker.Flag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventTest extends ItemTest {

    Event event;

    @BeforeEach
     void setup() {
        event = new Event();
        item = new Event();
        event.setActivity("interview");
        event.setDate("Monday");
        event.setTime(1000);
        event.setDuration(5);
        event.setCalculatedEnd();
    }

    @Test
     void testReturnItemDetails() {
        String expectedDetails;
        expectedDetails = " 'interview' on Monday from 10:00 to 15:00";

        String eventDetails;
        eventDetails = event.returnItemDetails();

        assertEquals(expectedDetails, eventDetails);
    }

    @Override
    @Test
    void testGetIsEvent() {
        assertTrue(event.getIsEvent());
    }

    @Override
    @Test
    public void testSetIsEvent() {
        event.setIsEvent(false);
        assertFalse(event.getIsEvent());
    }

    @Test
    void testGetTimeAndSetTime() {
        event.setTime(10);
        assertEquals(10, event.getTime());
    }

    @Test
    void testGetDurationAndSetDuration() {
        event.setDuration(5);
        assertEquals(5, event.getDuration());
    }

    @Test
    void testGetTimeAndSetCalculatedEnd() {
        event.setTime(1000);
        event.setDuration(5);
        event.setCalculatedEnd();
        assertEquals(1500, event.getEnd());
    }

    @Test
    void testGetTimeAndSetCalculatedEndNotSameDay() {
        event.setTime(1000);
        event.setDuration(30);
        event.setCalculatedEnd();
        assertEquals(1600, event.getEnd());
    }

    @Test
    void getWeatherSensitive() {
        assertEquals(false, event.getWeatherSensitive());
    }

    @Test
    void setEndTest() {
        event.setEnd(2300);
        assertEquals(2300, event.getEnd());
    }

    @Test
    void testSetWeatherSensitiveAndGetWeateherSensitive() {
        event.setWeatherSensitive(true);
        assertEquals(true, event.getWeatherSensitive());
    }
}
