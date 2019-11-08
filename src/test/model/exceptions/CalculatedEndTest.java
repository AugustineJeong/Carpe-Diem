//package model.exceptions;
//
//import exceptions.NotSameDay;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//
//public class CalculatedEndTest {
//    private Item item;
//
//    @Test
//    public void setCalculatedEndTest() {
//        item = new Event();
//
//        item.setTime(5);
//        item.setDuration(10);
//        try {
//            item.setCalculatedEnd();
//        } catch (NotSameDay notSameDay) {
//            fail("NotSameDay exception thrown but end on same day");
//        }
//        assertEquals(15, item.getEnd());
//
//        item.setTime(5);
//        item.setDuration(20);
//        try {
//            item.setCalculatedEnd();
//        } catch (NotSameDay notSameDay) {
//            notSameDay.printStackTrace();
//        }
//        assertEquals(1, item.getEnd());
//
//        item.setTime(7);
//        item.setDuration(100);
//        try {
//            item.setCalculatedEnd();
//        } catch (NotSameDay notSameDay) {
//            notSameDay.printStackTrace();
//        }
//        assertEquals(11, item.getEnd());
//    }
//}
