package com.udacity.jdnd.mvc_basics.MVC.Lesson4.model;

/**
 * Add a chatForm class to hold the char form data
 * field name should be EXACTLY SAME with ones in the Template
 */
public class chatForm {

    private String userName;
    private String userText;
    private String messageType;

    public void setUsername (String name) {
        userName = name;
    }

    public void setUserText (String text) {
        userText = text;
    }

    public void setMessageType (String type) {
        messageType = type;
    }

    public String getUserName () {
        return userName;
    }

    public String getUserText () {
        return userText;
    }

    public String getMessageType () {
        return messageType;
    }
}
