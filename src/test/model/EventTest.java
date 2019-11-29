package model;

import static org.junit.jupiter.api.Assertions.*;

import model.item.Event;
import model.item.Item;
//import model.marker.Flag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.gui.MainFrame;

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

    @Test
    void testReturnItemDetailsWeatherSensitive() {
        String expectedDetails;
        expectedDetails = " 'interview' on Monday from 10:00 to 15:00 *";

        String eventDetails;
        event.setWeatherSensitive(true);
        eventDetails = event.returnItemDetails();

        assertEquals(expectedDetails, eventDetails);
    }

    @Test
    void testReturnItemDetailsBeforeTwelve() {
        event.setTime(900);
        event.setDuration(7);
        event.setCalculatedEnd();

        String expectedDetails;
        expectedDetails = " 'interview' on Monday from 09:00 to 16:00";

        String eventDetails;
        eventDetails = event.returnItemDetails();

        assertEquals(expectedDetails, eventDetails);
    }

    @Test
    void testReturnItemDetailsBeforeTwelveHalfHour() {
        event.setTime(930);
        event.setDuration(7);
        event.setCalculatedEnd();

        String expectedDetails;
        expectedDetails = " 'interview' on Monday from 09:30 to 16:30";

        String eventDetails;
        eventDetails = event.returnItemDetails();

        assertEquals(expectedDetails, eventDetails);
    }

    @Test
     void testReturnItemDetailsHalfHour() {
        event.setTime(1130);
        event.setDuration(7);
        event.setCalculatedEnd();

        String expectedDetails;
        expectedDetails = " 'interview' on Monday from 11:30 to 18:30";

        String eventDetails;
        eventDetails = event.returnItemDetails();

        assertEquals(expectedDetails, eventDetails);
    }
    @Test
    void testGetIsEvent() {
        assertTrue(event.getIsEvent());
    }

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
    void testSetCalculatedEndMonday() {
        event.setDate("Monday");
        event.setTime(1000);
        event.setDuration(5);
        event.setCalculatedEnd();
        assertEquals(1500, event.getEnd());
    }

    @Test
    void testSetCalculatedEndTuesday() {
        event.setDate("Tuesday");
        event.setTime(1000);
        event.setDuration(5);
        event.setCalculatedEnd();
        assertEquals(1500, event.getEnd());
    }

    @Test
    void testSetCalculatedEndWednesday() {
        event.setDate("Wednesday");
        event.setTime(1000);
        event.setDuration(5);
        event.setCalculatedEnd();
        assertEquals(1500, event.getEnd());
    }

    @Test
    void testSetCalculatedEndThursday() {
        event.setDate("Thursday");
        event.setTime(1000);
        event.setDuration(5);
        event.setCalculatedEnd();
        assertEquals(1500, event.getEnd());
    }

    @Test
    void testSetCalculatedEndFriday() {
        event.setDate("Friday");
        event.setTime(1000);
        event.setDuration(5);
        event.setCalculatedEnd();
        assertEquals(1500, event.getEnd());
    }

    @Test
    void testSetCalculatedEndSaturday() {
        event.setDate("Saturday");
        event.setTime(1000);
        event.setDuration(5);
        event.setCalculatedEnd();
        assertEquals(1500, event.getEnd());
    }

    @Test
    void testSetCalculatedEndSunday() {
        event.setDate("Sunday");
        event.setTime(1000);
        event.setDuration(5);
        event.setCalculatedEnd();
        assertEquals(1500, event.getEnd());
    }

    @Test
    void testSetCalculatedEndOneDay() {
        event.setDate("Sunday");
        event.setTime(1000);
        event.setDuration(24);
        event.setCalculatedEnd();
        assertEquals(1000, event.getEnd());
    }

    @Test
    void testSetCalculatedEndTwoDay() {
        event.setDate("Sunday");
        event.setTime(1000);
        event.setDuration(48);
        event.setCalculatedEnd();
        assertEquals(1000, event.getEnd());
    }

    @Test
    void testSetCalculatedEndThreeDay() {
        event.setDate("Sunday");
        event.setTime(1000);
        event.setDuration(72);
        event.setCalculatedEnd();
        assertEquals(1000, event.getEnd());
    }

    @Test
    void testSetCalculatedEndFourDay() {
        event.setDate("Sunday");
        event.setTime(1000);
        event.setDuration(96);
        event.setCalculatedEnd();
        assertEquals(1000, event.getEnd());
    }

    @Test
    void testSetCalculatedEndFiveDay() {
        event.setDate("Sunday");
        event.setTime(1000);
        event.setDuration(120);
        event.setCalculatedEnd();
        assertEquals(1000, event.getEnd());
    }

    @Test
    void testSetCalculatedEndSixDay() {
        event.setDate("Sunday");
        event.setTime(1000);
        event.setDuration(144);
        event.setCalculatedEnd();
        assertEquals(1000, event.getEnd());
    }

    @Test
    void testSetCalculatedEndSevenDay() {
        event.setDate("Sunday");
        event.setTime(1000);
        event.setDuration(168);
        event.setCalculatedEnd();
        assertEquals(1000, event.getEnd());
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
