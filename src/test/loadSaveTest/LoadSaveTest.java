package loadSaveTest;

import model.EventList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadSaveTest {
    EventList events1 = new EventList();
    EventList events2 = new EventList();
    Event event1 = new Event();
    Event event2 = new Event();
    Event event3 = new Event();

    @BeforeEach
    public void setup() throws IOException {
        event1.setCategory("work");
        event1.setDate("Monday");
        event1.setActivity("Interview");
        event1.setTime(10);
        event1.setDuration(2);
        event1.setEnd(12);
        event1.setWeatherSensitive(false);

        event2.setCategory("personal");
        event2.setDate("Saturday");
        event2.setActivity("Skiing");
        event2.setTime(7);
        event2.setDuration(5);
        event2.setEnd(12);
        event2.setWeatherSensitive(true);

        event3.setCategory("work");
        event3.setDate("Tuesday");
        event3.setActivity("Project");
        event3.setTime(8);
        event3.setDuration(1);
        event3.setEnd(9);
        event3.setWeatherSensitive(false);

        events1.addEvent(event1);
        events1.addEvent(event2);
        events1.addEvent(event3);

        events1.save();
        events2.load();
    }



    @Test
    public void testLoadSave() {
        // test that values of events saved and loaded are the same
        assertEquals(events1.get(1).getCategory(), events2.get(1).getCategory());
        assertEquals(events1.get(1).getDate(), events2.get(1).getDate());
        assertEquals(events1.get(1).getActivity(), events2.get(1).getActivity());
        assertEquals(events1.get(1).getTime(), events2.get(1).getTime());
        assertEquals(events1.get(1).getDuration(), events2.get(1).getDuration());
        assertEquals(events1.get(1).getEnd(), events2.get(1).getEnd());
        assertEquals(events1.get(1).getWeatherSensitive(), events2.get(1).getWeatherSensitive());

        assertEquals(events1.get(2).getCategory(), events2.get(2).getCategory());
        assertEquals(events1.get(2).getDate(), events2.get(2).getDate());
        assertEquals(events1.get(2).getActivity(), events2.get(2).getActivity());
        assertEquals(events1.get(2).getTime(), events2.get(2).getTime());
        assertEquals(events1.get(2).getDuration(), events2.get(2).getDuration());
        assertEquals(events1.get(2).getEnd(), events2.get(2).getEnd());
        assertEquals(events1.get(2).getWeatherSensitive(), events2.get(2).getWeatherSensitive());

        assertEquals(events1.get(3).getCategory(), events2.get(3).getCategory());
        assertEquals(events1.get(3).getDate(), events2.get(3).getDate());
        assertEquals(events1.get(3).getActivity(), events2.get(3).getActivity());
        assertEquals(events1.get(3).getTime(), events2.get(3).getTime());
        assertEquals(events1.get(3).getDuration(), events2.get(3).getDuration());
        assertEquals(events1.get(3).getEnd(), events2.get(3).getEnd());
        assertEquals(events1.get(3).getWeatherSensitive(), events2.get(3).getWeatherSensitive());

        // test that values of events saved and loaded are the same, this time using initial event inputs.
        assertEquals(events2.get(1).getCategory(), event1.getCategory());
        assertEquals(events2.get(1).getDate(), event1.getDate());
        assertEquals(events2.get(1).getActivity(), event1.getActivity());
        assertEquals(events2.get(1).getTime(), event1.getTime());
        assertEquals(events2.get(1).getDuration(), event1.getDuration());
        assertEquals(events2.get(1).getEnd(), event1.getEnd());
        assertEquals(events2.get(1).getWeatherSensitive(), event1.getWeatherSensitive());

        assertEquals(events2.get(2).getCategory(), event2.getCategory());
        assertEquals(events2.get(2).getDate(), event2.getDate());
        assertEquals(events2.get(2).getActivity(), event2.getActivity());
        assertEquals(events2.get(2).getTime(), event2.getTime());
        assertEquals(events2.get(2).getDuration(), event2.getDuration());
        assertEquals(events2.get(2).getEnd(), event2.getEnd());
        assertEquals(events2.get(2).getWeatherSensitive(), event2.getWeatherSensitive());

        assertEquals(events2.get(3).getCategory(), event3.getCategory());
        assertEquals(events2.get(3).getDate(), event3.getDate());
        assertEquals(events2.get(3).getActivity(), event3.getActivity());
        assertEquals(events2.get(3).getTime(), event3.getTime());
        assertEquals(events2.get(3).getDuration(), event3.getDuration());
        assertEquals(events2.get(3).getEnd(), event3.getEnd());
        assertEquals(events2.get(3).getWeatherSensitive(), event3.getWeatherSensitive());
    }

}
