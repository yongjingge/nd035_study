package com.udacity.jdnd.c1.review.model;

/**
 * Add a chatMessage class to hold the displayed message information
 */
public class chatMessage {

    private String name;
    private String message;

    public void setName (String name) {
        this.name = name;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public String getName () {
        return name;
    }

    public String getMessage () {
        return message;
    }

}
