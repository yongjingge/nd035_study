package com.example.demo.controller;

import com.example.demo.model.MessageForm;
import com.example.demo.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    private MessageService messageService;

    public HomeController (MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getHomePage (@ModelAttribute("messageForm") MessageForm messageForm, Model model) {
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        return "home";
    }

    /**
     * postChatMessage (dealing with POST request)
     * @param authentication our AuthenticationService class's authenticate method will return an Authentication Object.
     * @param messageForm
     * @param model
     * @return
     */
    @PostMapping
    public String postChatMessage (@ModelAttribute("messageForm") Authentication authentication, MessageForm messageForm, Model model) {
        messageForm.setUsername(authentication.getName());
        this.messageService.addMessage(messageForm);
        messageForm.setText("");
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        return "home";
    }
}
