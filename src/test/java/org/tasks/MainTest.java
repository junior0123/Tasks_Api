package org.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MainTest {
    @Test
    void appHasAGreeting() {
        Main classUnderTest = new Main();
        assertEquals("Hello World!",classUnderTest.getGreeting());
    }
}
