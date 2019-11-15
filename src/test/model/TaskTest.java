package model;

import static org.junit.jupiter.api.Assertions.*;

import model.item.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest extends ItemTest {

    @BeforeEach
     void setup() {
        item = new Task();
    }

    @Test
     void testReturnItemDetails() {
        item.setActivity("Do homework");
        item.setDate("Monday");

        String message;
        message = item.returnItemDetails();

        String expectedMessage;
        expectedMessage = " 'Do homework' by Monday";

        assertEquals(message, expectedMessage);
    }

    @Override
    @Test
     void testGetIsEvent() {
        assertFalse(item.getIsEvent());
    }

    @Override
    @Test
     void testSetIsEvent() {
        item.setIsEvent(true);
        assertTrue(item.getIsEvent());
    }
}
