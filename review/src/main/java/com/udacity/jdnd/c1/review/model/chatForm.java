package com.udacity.jdnd.c1.review.model;

/**
 * Add a chatForm class to hold the chat form data
 * field name should be Exactly SAME with the ones in the HTML template
 */
public class chatForm {

    private String name;
    private String text;
    private String type;

    public void setName (String name) {
        this.name = name;
    }

    public void setText (String text) {
        this.text = text;
    }

    public void setType (String type) {
        this.type = type;
    }

    public String getName () {
        return this.name;
    }

    public String getText () {
        return this.text;
    }
    public String getType () {
        return type;
    }
}
