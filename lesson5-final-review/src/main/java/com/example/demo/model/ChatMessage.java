package com.example.demo.model;

/**
 * this class integrates 'text' and 'username'
 */
public class ChatMessage {

    private Integer messageId;
    private String username;
    private String messagetext;

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public String getUsername() {
        return username;
    }

    public String getMessagetext() {
        return messagetext;
    }
}
