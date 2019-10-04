package modelTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import model.*;

public class EventListTest {

    Event event1;
    Event event2;
    EventList events;

    @BeforeAll
    public void setup() {
        event1 = new Event();
        event2 = new Event();

        event1.setDate("1");
        event1.setActivity("2");
        event1.setTime(3);
        event1.setDuration(4);
        event1.setEnd(5);

        event2.setDate("21");
        event2.setActivity("22");
        event2.setTime(23);
        event2.setDuration(24);
        event2.setEnd(25);

        events = new EventList();

        events.addEvent(event1);
        events.addEvent(event2);
    }

    @Test
    public void firstTest() {
        assertEquals(event1, events.get(1));
    }
}


