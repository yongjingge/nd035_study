package com.udacity.jdnd.spring_security.Spring.Security.basics.controller;

import com.udacity.jdnd.spring_security.Spring.Security.basics.model.User;
import com.udacity.jdnd.spring_security.Spring.Security.basics.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author SarGould
 */

@Controller
@RequestMapping("/signup")
public class SignupController {

    private UserService userService;

    public SignupController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getSignupPage () {
        return "signup";
    }

    @PostMapping
    public String addSignupUser (User user, Model model) {
        String signupError = null;

        if (! userService.isUsernameAvailable(user.getUsername())) {
            signupError = "The username already exists.";
        }

        if (signupError == null) {
            int generatedKey = userService.createUser(user);
            if (generatedKey < 0) {
                signupError = "There was an error signing you up. Please try again.";
            }
        }

        if (signupError == null) {
            model.addAttribute("signupSuccess", true);
        } else {
            model.addAttribute("signupError", signupError);
        }

        return "signup";
    }
}
