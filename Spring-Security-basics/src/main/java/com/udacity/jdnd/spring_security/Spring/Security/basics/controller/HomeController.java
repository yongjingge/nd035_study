package com.udacity.jdnd.spring_security.Spring.Security.basics.controller;

import com.udacity.jdnd.spring_security.Spring.Security.basics.model.MessageForm;
import com.udacity.jdnd.spring_security.Spring.Security.basics.service.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private MessageListService messageListService;

    public HomeController (MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping
    public String getHomePage (@ModelAttribute("messageForm") MessageForm messageForm, Model model) {
        model.addAttribute("greetings", this.messageListService.getMessages());
        return "home";
    }

    @PostMapping
    public String addMessage (@ModelAttribute("messageForm") MessageForm messageForm, Model model) {
        messageListService.addMessage(messageForm.getText());
        model.addAttribute("greetings", this.messageListService.getMessages());
        messageForm.setText("");
        return "home";
    }
}
