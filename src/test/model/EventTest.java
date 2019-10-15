package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventTest extends ItemTest {

    @BeforeEach
    public void setup() {
        item = new Event();
    }

    @Test
    public void returnItemDetailsTest() {
        String expectedDetails;
        expectedDetails = " 'interview' scheduled on Monday from 10 to 15";

        String eventDetails;
        eventDetails = item.returnItemDetails();

        assertEquals(expectedDetails, eventDetails);
    }
}