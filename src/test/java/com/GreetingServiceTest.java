package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @Test
    public void testGetWelcomeMessage() {
        String result = greetingService.getWelcomeMessage();
        assertEquals("Code is deployed in Code Deploy Again", result);
    }

    @Test
    public void testGetGoodbyeMessage() {
        String result = greetingService.getGoodbyeMessage();
        assertEquals("Goodbye! See you next time!", result);
    }
}
