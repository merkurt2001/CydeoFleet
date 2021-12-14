package com.fleet.pages;

import com.fleet.utilities.ConfigurationReader;
import com.fleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement userName;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(name = "_submit")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='alert alert-error']//div[1]")
    public WebElement errorMessage;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPassword;

    @FindBy(xpath = "//*[@type='checkbox']")
    public WebElement rememberMe;


    public void login(String userNameStr, String passwordStr) {

        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        submit.click();
        // verification that we logged
    }

//    public void login() {
//        String username = System.getProperty("username") != null ? System.getProperty("username") : ConfigurationReader.get("driver_username");
//        String password = System.getProperty("password") != null ? System.getProperty("password") : ConfigurationReader.get("driver_password");
//        login(username, password);
//
//    }


}