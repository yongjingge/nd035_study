package com.example.demo.model;

/**
 * create User class to model SQL table 'USERS'
 */
public class User {

    private Integer userId;
    private String username;
    private String salt;
    private String password;
    private String firstname;
    private String lastname;

    public User(Integer userId, String username, String salt, String password, String firstname, String lastname) {
        this.userId = userId;
        this.username = username;
        this.salt = salt;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public void setSalt (String salt) {
        this.salt = salt;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public void setFirstname (String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getSalt() {
        return salt;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
