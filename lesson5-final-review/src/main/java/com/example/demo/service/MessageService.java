package com.example.demo.service;

import com.example.demo.mapper.MessageMapper;
import com.example.demo.model.ChatMessage;
import com.example.demo.model.MessageForm;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MessageService {

    /**
     * we replace the in-memory List with a Dependency on a MessageMapper class
     */
    private MessageMapper messageMapper;

    public MessageService (MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @PostConstruct
    public void postConstruct () {
        System.out.println("Creating MessageService bean ...");
    }

    public void addMessage (MessageForm messageForm) {
        // ChatMessage needs no constructor or an empty constructor
        ChatMessage newchat = new ChatMessage();
        newchat.setUsername(messageForm.getUsername());
        // add new message into mapper
        messageMapper.addMessage(newchat);
    }

    public List<ChatMessage> getChatMessages () {
        // get messages from mapper
        return messageMapper.getChatMessages();
    }
}
