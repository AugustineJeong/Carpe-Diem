package modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Event;

class EventTest {

    Event event;

    @BeforeEach
    public void setup() {
        event = new Event();
    }

    @Test
    public void returnEventTest() {
        String expectedDetails;
        expectedDetails = " work | 'interview' scheduled on Monday from 1400 to 1500";

        String eventDetails;
        eventDetails = event.returnEventDetails();

        assertEquals(expectedDetails, eventDetails);
    }
    @Test
    public void getCategoryTest() {
        assertEquals("work", event.getCategory());
    }

    @Test
    public void getDateTest() {
        assertEquals("Monday", event.getDate());
    }

    @Test
    public void getActivityTest() {
        assertEquals("interview", event.getActivity());
    }

    @Test
    public void getTimeTest() {
        assertEquals(1400, event.getTime());
    }

    @Test
    public void getDurationTest() {
        assertEquals(60, event.getDuration());
    }

    @Test
    public void getEndTest() {
        assertEquals(1500, event.getEnd());
    }

    @Test
    public void getWeatherSensitive() {
        assertEquals(false, event.getWeatherSensitive());
    }


    @Test
    public void setCategoryTest() {
        event.setCategory("work");
        assertEquals("work", event.getCategory());
    }

    @Test
    public void setDateTest() {
        event.setDate("Saturday");
        assertEquals("Saturday", event.getDate());
    }

    @Test
    public void setActivityTest() {
        event.setActivity("party");
        assertEquals("party", event.getActivity());
    }

    @Test
    public void setTimeTest() {
        event.setTime(2200);
        assertEquals(2200, event.getTime());
    }

    @Test
    public void setDurationTest() {
        event.setDuration(30);
        assertEquals(30, event.getDuration());
    }

    @Test
    public void setEndTest() {
        event.setEnd(2300);
        assertEquals(2300, event.getEnd());
    }

    @Test
    public void setWeatherSensitive() {
        event.setWeatherSensitive(true);
        assertEquals(true, event.getWeatherSensitive());
    }
}