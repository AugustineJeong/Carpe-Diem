//package model;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//abstract class ItemListTest {
//    protected ItemList itemlist1;
//    protected ItemList itemlist2;
//    protected Item item1;
//    protected Item item2;
//    protected Item item3;
//
//    @Test
//    public void lengthTest() {
//        int length;
//        length = itemlist1.length();
//
//        int expectedLength;
//        expectedLength = 3;
//        assertEquals(expectedLength, length);
//    }
//
//    @Test
//    public void getTest() {
//        assertEquals(item1, itemlist1.get(1));
//        assertEquals(item2, itemlist1.get(2));
//        assertEquals(item3, itemlist1.get(3));
//    }
//
//    @Test
//    abstract void testLoadSave();
//}
