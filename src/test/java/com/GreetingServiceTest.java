package com;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingServiceTest {  // No 'public' modifier on the class

    private final GreetingService greetingService = new GreetingService();

    @Test
    void testGetWelcomeMessage() {  // No 'public' modifier on the method
        assertEquals("Code is deployed in Code Deploy Again", greetingService.getWelcomeMessage());
    }

    // Add more test methods as needed
}
