package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testWelcomeEndpoint() throws Exception {
        String response = mockMvc.perform(MockMvcRequestBuilders.get("/api/welcome"))
                .andReturn().getResponse().getContentAsString();
        assertEquals("Code is deployed in Code Deploy Again", response);
    }

    @Test
    public void testGoodbyeEndpoint() throws Exception {
        String response = mockMvc.perform(MockMvcRequestBuilders.get("/api/goodbye"))
                .andReturn().getResponse().getContentAsString();
        assertEquals("Goodbye, see you again!", response);
    }
}
