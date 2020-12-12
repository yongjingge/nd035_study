package com.udacity.jdnd.spring_security.Spring.Security.basics.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {
    private List<String> messages;

    @PostConstruct
    public void postConstruct () {
        System.out.println("Creating MessageListService bean ...");
        this.messages = new ArrayList<>();
    }

    public void addMessage (String message) {
        messages.add(message);
    }
    public List<String> getMessages () {
        return messages;
    }
}
