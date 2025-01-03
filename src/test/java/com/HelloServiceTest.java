package com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HelloServiceTest {

    private final HelloService helloService = new HelloService();

    @Test
    void testGetWelcomeMessage() {
        assertEquals("Code is deployed in Code Deploy Again", helloService.getWelcomeMessage());
    }

    @Test
    void testGetGoodbyeMessage() {
        assertEquals("Goodbye, see you again!", helloService.getGoodbyeMessage());
    }

    @Test
    void testGetHelloMessage() {
        assertEquals("Hello from AWS CodeDeploy Demo!", helloService.getHelloMessage());
    }

    @Test
    void testSimulateError() {
        // Ensure the CustomException is thrown
        CustomException thrown = assertThrows(CustomException.class, () -> {
            helloService.simulateError();
        });
        assertEquals("Simulated service error!", thrown.getMessage());
    }
}
