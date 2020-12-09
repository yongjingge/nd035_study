package com.udacity.jdnd.mvc_basics.MVC.Lesson4.controller;

import com.udacity.jdnd.mvc_basics.MVC.Lesson4.model.chatForm;
import com.udacity.jdnd.mvc_basics.MVC.Lesson4.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageService messageService;
    public ChatController (MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatPage (@ModelAttribute("chatForm") chatForm chatform, Model model) {
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        return "chat";
    }


    @PostMapping
    public String addChat (@ModelAttribute("chatForm") chatForm chatform, Model model) {
        this.messageService.addMessage(chatform);
        model.addAttribute("chatMessages", messageService.getChatMessages());
        chatform.setUserText("");
        return "chat";
    }

    @ModelAttribute("allTypes")
    public String[] allTypes () {
        return new String[] {"Say", "Shout", "Whisper"};
    }
}
