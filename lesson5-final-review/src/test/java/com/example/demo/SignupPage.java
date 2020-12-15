package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    // define element selectors
    @FindBy(id = "inputFirstName")
    private WebElement firstNameInput;

    @FindBy(id = "inputLastName")
    private WebElement lastNameInput;

    @FindBy(id = "inputUsername")
    private WebElement usernameInput;

    @FindBy(id = "inputPassword")
    private WebElement passwordInput;

    @FindBy(id = "submit-button")
    private WebElement submit;

    // initialising web elements
    public SignupPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // creating helper methods
    public void signup (String firstname, String lastname, String username, String password) {
        // using sendKeys() to add values
        this.firstNameInput.sendKeys(firstname);
        this.lastNameInput.sendKeys(lastname);
        this.usernameInput.sendKeys(username);
        this.passwordInput.sendKeys(password);
        this.submit.click();
    }

}
