package modelTest;

import model.Event;
import model.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class ItemTest {
    protected Item item;

    @Test
    public void getDateTest() {
        assertEquals("Monday", item.getDate());
    }

    @Test
    public void getActivityTest() {
        assertEquals("interview", item.getActivity());
    }

    @Test
    public void getTimeTest() {
        assertEquals(10, item.getTime());
    }

    @Test
    public void getDurationTest() {
        assertEquals(5, item.getDuration());
    }

    @Test
    public void getEndTest() {
        assertEquals(15, item.getEnd());
    }

    @Test
    public void getWeatherSensitive() {
        assertEquals(false, item.getWeatherSensitive());
    }

    @Test
    public void setDateTest() {
        item.setDate("Saturday");
        assertEquals("Saturday", item.getDate());
    }

    @Test
    public void setActivityTest() {
        item.setActivity("party");
        assertEquals("party", item.getActivity());
    }

    @Test
    public void setTimeTest() {
        item.setTime(2200);
        assertEquals(2200, item.getTime());
    }

    @Test
    public void setDurationTest() {
        item.setDuration(30);
        assertEquals(30, item.getDuration());
    }

    @Test
    public void setEndTest() {
        item.setEnd(2300);
        assertEquals(2300, item.getEnd());
    }

    @Test
    public void setWeatherSensitive() {
        item.setWeatherSensitive(true);
        assertEquals(true, item.getWeatherSensitive());
    }

    @Test
    public void setCalculatedEndTest() {
        item.setTime(5);
        item.setDuration(10);
        item.setCalculatedEnd();
        assertEquals(15, item.getEnd());

        item.setTime(5);
        item.setDuration(20);
        item.setCalculatedEnd();
        assertEquals(1, item.getEnd());

        item.setTime(7);
        item.setDuration(100);
        item.setCalculatedEnd();
        assertEquals(11, item.getEnd());
    }
}
