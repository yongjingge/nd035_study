package com.udacity.jdnd.mvc_basics.MVC.Lesson4.model;

/**
 * Add a chatMessage class to hold the displayed message information
 */
public class chatMessage {

    private String userName;
    private String message;

    public void setUserName (String name) {
        userName = name;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public String getUserName () {
        return userName;
    }

    public String getMessage () {
        return message;
    }
}
