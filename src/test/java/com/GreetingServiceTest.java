package com;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingServiceTest {

    private final GreetingService greetingService = new GreetingService();

    @Test
    public void testGetWelcomeMessage() {
        assertEquals("Code is deployed in Code Deploy Again", greetingService.getWelcomeMessage());
    }

    @Test
    public void testGetGoodbyeMessage() {
        assertEquals("Goodbye! See you next time!", greetingService.getGoodbyeMessage());
    }
}
