package com;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getWelcomeMessage() {
        return "Code is deployed in Code Deploy Again";
    }

    public String getGoodbyeMessage() {
        return "Goodbye! See you next time!";
    }
}
