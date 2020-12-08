package com.udacity.jdnd.c1.review.service;

import com.udacity.jdnd.c1.review.model.chatForm;
import com.udacity.jdnd.c1.review.model.chatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

//    private String message;
//
//    public MessageService (String message) { //we use the Bean we defined from ReviewApplication class
//        this.message = message;
//    }
//
//    public String uppercase () {
//        return message.toUpperCase();
//    }
//
//    public String lowercase () {
//        return message.toLowerCase();
//    }

    private List<chatMessage> chatMessages;

    @PostConstruct
    public void postConstruct () {
//        System.out.println("Creating MessageService bean which depends on message dependency");
        System.out.println("Creating MessageService bean ...");
        this.chatMessages = new ArrayList<>();
    }

//    add a submitted message to the message list stored by the MessageService
    public void addMessage (chatForm chatForm) {
        chatMessage chat = new chatMessage();
        chat.setName(chatForm.getName());
        switch (chatForm.getType()) {
            case "Say":
                chat.setMessage(chatForm.getText());
                break;
            case "Shout":
                chat.setMessage(chatForm.getText().toUpperCase());
                break;
            case "Whisper":
                chat.setMessage(chatForm.getText().toLowerCase());
                break;
        }


//        if (chatForm.getType() == "Say") {
//            chat.setMessage(chatForm.getText());
//        } else if (chatForm.getType() == "Shout") {
//            chat.setMessage(chatForm.getText().toUpperCase());
//        } else {
//            chat.setMessage(chatForm.getText().toLowerCase());
//        }
        this.chatMessages.add(chat);
    }

    public List<chatMessage> getChats () {
        return chatMessages;
    }
}
