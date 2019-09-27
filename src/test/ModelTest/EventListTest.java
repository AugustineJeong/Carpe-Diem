package ModelTest;

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

        event1.updateDate("1");
        event1.updateActivity("2");
        event1.updateTime(3);
        event1.updateDuration(4);
        event1.updateEnd(5);

        event2.updateDate("21");
        event2.updateActivity("22");
        event2.updateTime(23);
        event2.updateDuration(24);
        event2.updateEnd(25);

        events = new EventList();

        events.addEvent(event1);
        events.addEvent(event2);
    }

    @Test
    public void firstTest() {
        assertEquals(event1, events.first());
    }
}


