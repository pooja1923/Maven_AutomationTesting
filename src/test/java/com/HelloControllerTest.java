package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;  // Mock the service that is injected into the controller

    @Test
    public void testWelcomeEndpoint() throws Exception {
        // Mock the service method
        when(helloService.getWelcomeMessage()).thenReturn("Code is deployed in Code Deploy Again");

        String response = mockMvc.perform(MockMvcRequestBuilders.get("/api/welcome"))
                .andReturn().getResponse().getContentAsString();
        assertEquals("Code is deployed in Code Deploy Again", response);
    }

    @Test
    public void testGoodbyeEndpoint() throws Exception {
        // Mock the service method
        when(helloService.getGoodbyeMessage()).thenReturn("Goodbye, see you again!");

        String response = mockMvc.perform(MockMvcRequestBuilders.get("/api/goodbye"))
                .andReturn().getResponse().getContentAsString();
        assertEquals("Goodbye, see you again!", response);
    }
}
