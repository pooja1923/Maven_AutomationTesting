package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
public class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testExceptionHandler() throws Exception {
        String response = mockMvc.perform(MockMvcRequestBuilders.get("/api/nonexistent"))
                .andReturn().getResponse().getContentAsString();
        assertEquals("An error occurred: No mapping for GET /api/nonexistent", response);
    }
}
