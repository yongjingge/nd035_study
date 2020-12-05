package com.udacity.jdnd.c1.review;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MessageService {
    private String message;
    public MessageService (String message) { //we use the Bean we defined from ReviewApplication class
        this.message = message;
    }
    public String uppercase () {
        return message.toUpperCase();
    }
    public String lowercase () {
        return message.toLowerCase();
    }
    @PostConstruct
    public void postConstruct () {
        System.out.println("Creating MessageService bean which depends on message dependency");
    }
}
