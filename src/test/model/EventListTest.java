//package model;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//
//public class EventListTest extends ItemListTest {
//
//    @BeforeEach
//    public void setup() throws IOException {
//        itemlist1 = new EventList();
//        itemlist2 = new EventList();
//        item1 = new Event();
//        item2 = new Event();
//        item3 = new Event();
//
//        item1.setIsEvent(true);
//        item1.setDate("Monday");
//        item1.setActivity("Interview");
//        item1.setTime(10);
//        item1.setDuration(2);
//        item1.setEnd(12);
//        item1.setWeatherSensitive(false);
//
//        item2.setIsEvent(true);
//        item2.setDate("Saturday");
//        item2.setActivity("Skiing");
//        item2.setTime(7);
//        item2.setDuration(5);
//        item2.setEnd(12);
//        item2.setWeatherSensitive(true);
//
//        item3.setIsEvent(true);
//        item3.setDate("Tuesday");
//        item3.setActivity("Project");
//        item3.setTime(8);
//        item3.setDuration(1);
//        item3.setEnd(9);
//        item3.setWeatherSensitive(false);
//
//        itemlist1.addItem(item1);
//        itemlist1.addItem(item2);
//        itemlist1.addItem(item3);
//
//        itemlist1.save();
//        itemlist2.load();
//    }
//
//    @Test
//    public void testLoadSave() {
//        // test that values of events saved and loaded are the same
//        assertEquals(itemlist1.get(1).getIsEvent(), itemlist2.get(1).getIsEvent());
//        assertEquals(itemlist1.get(1).getDate(), itemlist2.get(1).getDate());
//        assertEquals(itemlist1.get(1).getActivity(), itemlist2.get(1).getActivity());
//        assertEquals(itemlist1.get(1).getTime(), itemlist2.get(1).getTime());
//        assertEquals(itemlist1.get(1).getDuration(), itemlist2.get(1).getDuration());
//        assertEquals(itemlist1.get(1).getEnd(), itemlist2.get(1).getEnd());
//        assertEquals(itemlist1.get(1).getWeatherSensitive(), itemlist2.get(1).getWeatherSensitive());
//
//        assertEquals(itemlist1.get(2).getIsEvent(), itemlist2.get(2).getIsEvent());
//        assertEquals(itemlist1.get(2).getDate(), itemlist2.get(2).getDate());
//        assertEquals(itemlist1.get(2).getActivity(), itemlist2.get(2).getActivity());
//        assertEquals(itemlist1.get(2).getTime(), itemlist2.get(2).getTime());
//        assertEquals(itemlist1.get(2).getDuration(), itemlist2.get(2).getDuration());
//        assertEquals(itemlist1.get(2).getEnd(), itemlist2.get(2).getEnd());
//        assertEquals(itemlist1.get(2).getWeatherSensitive(), itemlist2.get(2).getWeatherSensitive());
//
//        assertEquals(itemlist1.get(3).getIsEvent(), itemlist2.get(3).getIsEvent());
//        assertEquals(itemlist1.get(3).getDate(), itemlist2.get(3).getDate());
//        assertEquals(itemlist1.get(3).getActivity(), itemlist2.get(3).getActivity());
//        assertEquals(itemlist1.get(3).getTime(), itemlist2.get(3).getTime());
//        assertEquals(itemlist1.get(3).getDuration(), itemlist2.get(3).getDuration());
//        assertEquals(itemlist1.get(3).getEnd(), itemlist2.get(3).getEnd());
//        assertEquals(itemlist1.get(3).getWeatherSensitive(), itemlist2.get(3).getWeatherSensitive());
//
//        // test that values of events saved and loaded are the same, this time using initial event inputs.
//        assertEquals(itemlist2.get(1).getIsEvent(), item1.getIsEvent());
//        assertEquals(itemlist2.get(1).getDate(), item1.getDate());
//        assertEquals(itemlist2.get(1).getActivity(), item1.getActivity());
//        assertEquals(itemlist2.get(1).getTime(), item1.getTime());
//        assertEquals(itemlist2.get(1).getDuration(), item1.getDuration());
//        assertEquals(itemlist2.get(1).getEnd(), item1.getEnd());
//        assertEquals(itemlist2.get(1).getWeatherSensitive(), item1.getWeatherSensitive());
//
//        assertEquals(itemlist2.get(2).getIsEvent(), item2.getIsEvent());
//        assertEquals(itemlist2.get(2).getDate(), item2.getDate());
//        assertEquals(itemlist2.get(2).getActivity(), item2.getActivity());
//        assertEquals(itemlist2.get(2).getTime(), item2.getTime());
//        assertEquals(itemlist2.get(2).getDuration(), item2.getDuration());
//        assertEquals(itemlist2.get(2).getEnd(), item2.getEnd());
//        assertEquals(itemlist2.get(2).getWeatherSensitive(), item2.getWeatherSensitive());
//
//        assertEquals(itemlist2.get(3).getIsEvent(), item3.getIsEvent());
//        assertEquals(itemlist2.get(3).getDate(), item3.getDate());
//        assertEquals(itemlist2.get(3).getActivity(), item3.getActivity());
//        assertEquals(itemlist2.get(3).getTime(), item3.getTime());
//        assertEquals(itemlist2.get(3).getDuration(), item3.getDuration());
//        assertEquals(itemlist2.get(3).getEnd(), item3.getEnd());
//        assertEquals(itemlist2.get(3).getWeatherSensitive(), item3.getWeatherSensitive());
//    }
//}
//
//
