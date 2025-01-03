import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.HelloController;  
import com.HelloService;  

@WebMvcTest(HelloController.class)
class HelloControllerTest {  // Removed the 'public' modifier

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    @Test
    void testWelcome() throws Exception {  // Removed the 'public' modifier
        when(helloService.getWelcomeMessage()).thenReturn("Code is deployed in Code Deploy Again");

        mockMvc.perform(get("/api/welcome").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Code is deployed in Code Deploy Again")));
    }

    @Test
    void testGoodbye() throws Exception {  // Removed the 'public' modifier
        when(helloService.getGoodbyeMessage()).thenReturn("Goodbye! See you next time!");

        mockMvc.perform(get("/api/goodbye").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Goodbye! See you next time!")));
    }
}
