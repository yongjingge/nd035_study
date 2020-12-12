package com.example.demo.model;

/**
 * this class is used to hold data from the form as a form-backing object
 */
public class MessageForm {
    private String text;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
