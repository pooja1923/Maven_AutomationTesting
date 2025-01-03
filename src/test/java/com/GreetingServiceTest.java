package com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingServiceTest {

    private final GreetingService greetingService = new GreetingService();

    @Test
    void testGetWelcomeMessage() {
        assertEquals("Code is deployed in Code Deploy Again", greetingService.getWelcomeMessage());
    }

    @Test
    void testGetGoodbyeMessage() {
        assertEquals("Goodbye! See you next time!", greetingService.getGoodbyeMessage());
    }

    @Test
    void testMultipleMethods() {
        assertEquals("Code is deployed in Code Deploy Again", greetingService.getWelcomeMessage());
        assertEquals("Goodbye! See you next time!", greetingService.getGoodbyeMessage());
    }
}
