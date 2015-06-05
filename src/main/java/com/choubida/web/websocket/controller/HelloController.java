package com.choubida.web.websocket.controller;


import com.choubida.web.websocket.message.HelloGreeting;
import com.choubida.web.websocket.message.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class HelloController {

    @MessageMapping("/hello")
    @SendTo("/topic/hello")
    public HelloGreeting greeting(HelloMessage message) throws Exception {
        return new HelloGreeting("Hello, " + message.getName() + "!");
    }

}
