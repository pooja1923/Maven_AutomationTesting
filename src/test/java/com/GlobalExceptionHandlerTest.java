package com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHandleAllExceptions() throws Exception {
        mockMvc.perform(get("/api/throwException"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Test error occurred: Test Exception: Custom Exception thrown"));
    }

    @Test
    void testHandleOtherExceptions() throws Exception {
        mockMvc.perform(get("/api/nonExistentEndpoint"))
                .andExpect(status().isNotFound());
    }
}
