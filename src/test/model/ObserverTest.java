package model;

import model.item.Event;
import model.item.Item;
import model.observer.Birb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.program.Program;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class ObserverTest {
    Program program;
    Birb birb;

    @BeforeEach
    void setup() throws IOException {
        program = new Program();
        birb = new Birb();
        program.addObserver(birb);
    }

    @Test
    void notifyAndUpdateAndGetSeenItemListTest() {
        Item item = new Event();
        program.notifyObservers(item);
        assertTrue(birb.getSeenItemList().contains(item));
    }
}
