package com.example.automation;

import com.HelloController;
import com.HelloService;
import com.CustomException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class IntegratedTests {

    private MockMvc mockMvc;
    private WebDriver driver;

    @MockBean
    private HelloService helloService;

    @InjectMocks
    private HelloController helloController;

    @BeforeEach
    public void setup() {
        // Setup for MockMvc (Spring Boot Controller Test)
        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();

        // Setup WebDriver for Selenium Tests
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pooja\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testWelcomeEndpoint() throws Exception {
        when(helloService.getWelcomeMessage()).thenReturn("Code is deployed in Code Deploy Again");

        mockMvc.perform(get("/api/welcome"))
                .andExpect(status().isOk())
                .andExpect(content().string("Code is deployed in Code Deploy Again"));

        verify(helloService, times(1)).getWelcomeMessage();
    }

    @Test
    public void testGoodbyeEndpoint() throws Exception {
        when(helloService.getGoodbyeMessage()).thenReturn("Goodbye, see you again!");

        mockMvc.perform(get("/api/goodbye"))
                .andExpect(status().isOk())
                .andExpect(content().string("Goodbye, see you again!"));

        verify(helloService, times(1)).getGoodbyeMessage();
    }

    @Test
    public void testErrorEndpoint() throws Exception {
        doThrow(new CustomException("Custom error occurred!")).when(helloService).simulateError();

        mockMvc.perform(get("/api/error"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Custom error occurred!"));

        verify(helloService, times(1)).simulateError();
    }

    @Test
    public void testLogin() {
        // Navigate to the login page
        driver.get("https://www.saucedemo.com/");

        // Locate the username and password fields
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Perform login
        usernameField.sendKeys("testUser");
        passwordField.sendKeys("testPassword");
        loginButton.click();

        // Validate successful login
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @AfterEach
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
