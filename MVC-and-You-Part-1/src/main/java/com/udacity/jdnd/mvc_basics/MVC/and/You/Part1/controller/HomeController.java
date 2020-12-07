package com.udacity.jdnd.mvc_basics.MVC.and.You.Part1.controller;

import com.udacity.jdnd.mvc_basics.MVC.and.You.Part1.MessageForm;
import com.udacity.jdnd.mvc_basics.MVC.and.You.Part1.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
public class HomeController {

    private MessageListService messageListService;

    public HomeController (MessageListService messageListService) {
        this.messageListService = messageListService;
    }

//    @RequestMapping("/home")
//    public String getHomePage (Model model) {
//        // model.addAttribute("welcomeMessage", Instant.now().toString());
//        model.addAttribute("greetings", new String[] {"Hi", "Hello", "There"});
//        return "home";
//    }

    @GetMapping("/home")
    public String getHomePage (@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        model.addAttribute("greetings", this.messageListService.getMessages());
        return "home";
    }

    @PostMapping("/home")
    public String addMessage (@ModelAttribute("newMessage") MessageForm messageForm, Model model) {
        messageListService.addMessage(messageForm.getText());
        model.addAttribute("greetings", messageListService.getMessages());
        messageForm.setText("");
        return "home";
    }


    @RequestMapping("/simplehome")
    public String getSimpleHome (Model model) {
        model.addAttribute("firstVisit", "true");
        return "simplehome";
    }
}
