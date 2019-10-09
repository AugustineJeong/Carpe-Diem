package modelTest;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoListTest {

    ToDoList todolist1 = new ToDoList();
    ToDoList todolist2 = new ToDoList();
    ToDo todo1 = new ToDo();
    ToDo todo2 = new ToDo();
    ToDo todo3 = new ToDo();

    @BeforeEach
    public void setup() throws IOException {
        todo1.setIsEvent(true);
        todo1.setDate("Monday");
        todo1.setActivity("Interview");

        todo2.setIsEvent(true);
        todo2.setDate("Tuesday");
        todo2.setActivity("Do home");

        todo3.setIsEvent(true);
        todo3.setDate("Friday");
        todo3.setActivity("Do project");

        todolist1.addItem(todo1);
        todolist1.addItem(todo2);
        todolist1.addItem(todo3);

        todolist1.save();
        todolist2.load();
    }

    @Test
    public void testLoadSave() {
        // test that values of events saved and loaded are the same
        assertEquals(todolist1.get(1).getIsEvent(), todolist2.get(1).getIsEvent());
        assertEquals(todolist1.get(1).getDate(), todolist2.get(1).getDate());
        assertEquals(todolist1.get(1).getActivity(), todolist2.get(1).getActivity());
        assertEquals(todolist1.get(1).getTime(), todolist2.get(1).getTime());
        assertEquals(todolist1.get(1).getDuration(), todolist2.get(1).getDuration());
        assertEquals(todolist1.get(1).getEnd(), todolist2.get(1).getEnd());
        assertEquals(todolist1.get(1).getWeatherSensitive(), todolist2.get(1).getWeatherSensitive());

        assertEquals(todolist1.get(2).getIsEvent(), todolist2.get(2).getIsEvent());
        assertEquals(todolist1.get(2).getDate(), todolist2.get(2).getDate());
        assertEquals(todolist1.get(2).getActivity(), todolist2.get(2).getActivity());
        assertEquals(todolist1.get(2).getTime(), todolist2.get(2).getTime());
        assertEquals(todolist1.get(2).getDuration(), todolist2.get(2).getDuration());
        assertEquals(todolist1.get(2).getEnd(), todolist2.get(2).getEnd());
        assertEquals(todolist1.get(2).getWeatherSensitive(), todolist2.get(2).getWeatherSensitive());

        assertEquals(todolist1.get(3).getIsEvent(), todolist2.get(3).getIsEvent());
        assertEquals(todolist1.get(3).getDate(), todolist2.get(3).getDate());
        assertEquals(todolist1.get(3).getActivity(), todolist2.get(3).getActivity());
        assertEquals(todolist1.get(3).getTime(), todolist2.get(3).getTime());
        assertEquals(todolist1.get(3).getDuration(), todolist2.get(3).getDuration());
        assertEquals(todolist1.get(3).getEnd(), todolist2.get(3).getEnd());
        assertEquals(todolist1.get(3).getWeatherSensitive(), todolist2.get(3).getWeatherSensitive());

        // test that values of events saved and loaded are same, this time using initial event inputs.
        assertEquals(todolist2.get(1).getIsEvent(), todo1.getIsEvent());
        assertEquals(todolist2.get(1).getDate(), todo1.getDate());
        assertEquals(todolist2.get(1).getActivity(), todo1.getActivity());

        assertEquals(todolist2.get(2).getIsEvent(), todo2.getIsEvent());
        assertEquals(todolist2.get(2).getDate(), todo2.getDate());
        assertEquals(todolist2.get(2).getActivity(), todo2.getActivity());

        assertEquals(todolist2.get(3).getIsEvent(), todo3.getIsEvent());
        assertEquals(todolist2.get(3).getDate(), todo3.getDate());
        assertEquals(todolist2.get(3).getActivity(), todo3.getActivity());
    }
}
