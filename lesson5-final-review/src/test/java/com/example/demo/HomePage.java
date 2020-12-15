package com.example.demo;

import com.example.demo.model.ChatMessage;
import com.example.demo.model.MessageForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "newMessageText")
    private WebElement message;

    @FindBy(id = "submit-button")
    private WebElement submit;

    @FindBy(className = "chatUsername")
    private WebElement chatUsername;

    @FindBy(className = "chatText")
    private WebElement chatText;

    public HomePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addPost (String message) {
        this.message.sendKeys(message);
        this.submit.click();
    }

    public ChatMessage getMessage () {
        ChatMessage res = new ChatMessage();
        res.setUsername(chatUsername.getText());
        res.setMessagetext(chatText.getText());
        return res;
    }

}
