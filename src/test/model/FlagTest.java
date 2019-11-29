//package model;
//
//import model.item.Event;
//import model.item.Item;
////import model.marker.Flag;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class FlagTest {
//    Event event;
////    Flag flag;
//
//    @BeforeEach
//     void setup() {
////        flag = new Flag("blue");
//        event = new Event();
//        event.setActivity("interview");
//        event.setDate("Monday");
//        event.setTime(10);
//        event.setDuration(5);
//        event.setCalculatedEnd();
//    }
//
//    @Test
//     void testGetColour() {
//        assertEquals("blue", flag.getColour());
//    }
//
//
//    @Test
//     void testContainsSameItemAndAddItem() {
//        flag.addItem(event);
//
//        assertTrue(flag.containsSameItem(event));
//
//        flag.removeItem(event);
//
//        assertFalse(flag.containsSameItem(event));
//    }
//
//    @Test
//     void testContainsSameItemAndRemoveItem() {
//        Flag flag = new Flag("blue");
//
//        flag.addItem(event);
//
//        flag.removeItem(event);
//
//        assertFalse(flag.containsSameItem(event));
//    }
//
//    @Test
//    void testContainsSameItemFalse() {
//        assertFalse(flag.containsSameItem(event));
//    }
//
//    @Test
//    void testHashcodeAndEquals() {
//        Flag flag2 = null;
//        assertNotEquals(flag, flag2);
//
//        Item fakeFlag = new Event();
//        assertNotEquals(flag, fakeFlag);
//
//        flag2 = new Flag("blue");
//        assertEquals(flag.hashCode(), flag2.hashCode());
//    }
//}
