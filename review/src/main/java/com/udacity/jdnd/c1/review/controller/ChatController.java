package com.udacity.jdnd.c1.review.controller;

import com.udacity.jdnd.c1.review.service.MessageService;
import com.udacity.jdnd.c1.review.model.chatForm;
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
    public String getChatPage (@ModelAttribute("chatForm") chatForm chatForm, Model model) {
        model.addAttribute("chatMessages", this.messageService.getChats());
        return "chat";
    }

    @PostMapping
    public String addChat (@ModelAttribute("chatForm") chatForm chatForm, Model model) {
        this.messageService.addMessage(chatForm);
        chatForm.setText("");
        model.addAttribute("chatMessages", messageService.getChats());
        return "chat";
    }

    @ModelAttribute("allTypes")
    public String[] allTypes () {
        return new String[] { "Say", "Shout", "Whisper"};
    }

}
