package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ToDoTest extends ItemTest {

    @BeforeEach
    public void setup() {
        item = new ToDo();
    }

    @Test
    public void returnItemDetailsTest() {
        ToDo todo;
        todo = new ToDo();

        todo.setActivity("Do homework");
        todo.setDate("Monday");

        String message;
        message = todo.returnItemDetails();

        String expectedMessage;
        expectedMessage = " 'Do homework' by Monday";

        assertEquals(message, expectedMessage);
    }
}
