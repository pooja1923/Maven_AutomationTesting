package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/welcome")
    public String welcome() {
        return helloService.getWelcomeMessage();
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return helloService.getGoodbyeMessage();
    }

    @GetMapping("/error")
    public String simulateError() {
        return helloService.simulateError();
    }
}
