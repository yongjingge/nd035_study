package com.udacity.jdnd.mvc_basics.MVC.Lesson4.service;

import com.udacity.jdnd.mvc_basics.MVC.Lesson4.model.chatForm;
import com.udacity.jdnd.mvc_basics.MVC.Lesson4.model.chatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private List<chatMessage> chatMessages;

    @PostConstruct
    public void postConstruct () {
        System.out.println("Creating MessageService bean ...");
        this.chatMessages = new ArrayList<>();
    }

    /* Add a submitted message to the message list stored by MessageService
     */
    public void addMessage (chatForm chatform) {
        chatMessage newChat = new chatMessage();
        newChat.setUserName(chatform.getUserName());
        if ("Say".equals(chatform.getMessageType())) {
            newChat.setMessage(chatform.getUserText());
        } else if ("Shout".equals(chatform.getMessageType())) {
            newChat.setMessage(chatform.getUserText().toUpperCase());
        } else if ("Whisper".equals(chatform.getMessageType())) {
            newChat.setMessage(chatform.getUserText().toLowerCase());
        }
        this.chatMessages.add(newChat);
    }

    public List<chatMessage> getChatMessages () {
        return chatMessages;
    }
}
