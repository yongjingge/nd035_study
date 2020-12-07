package com.udacity.jdnd.mvc_basics.MVC.and.You.Part1;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {
    private List<String> messages;

    @PostConstruct
    public void postConstruct () {
        this.messages = new ArrayList<>();
    }

    public void addMessage (String message) {
        this.messages.add(message);
    }

    public List<String> getMessages () {
        return new ArrayList<>(this.messages);
    }

}
