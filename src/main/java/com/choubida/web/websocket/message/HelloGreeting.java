package com.choubida.web.websocket.message;

public class HelloGreeting {

    private String content;

    public HelloGreeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
