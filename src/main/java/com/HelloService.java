package com;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getWelcomeMessage() {
        return "Code is deployed in Code Deploy Again";
    }

    public String getGoodbyeMessage() {
        return "Goodbye, see you again!";
    }

    public String getHelloMessage() {
        return "Hello from AWS CodeDeploy Demo!";
    }

    // A method to simulate an error
    public String simulateError() {
        throw new CustomException("Simulated service error!");
    }
}
