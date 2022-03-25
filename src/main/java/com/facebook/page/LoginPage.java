package com.facebook.page;

import com.facebook.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Page Factory = Object Repository
    @FindBy(id = "email")
    WebElement username;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginButton;

    // initialization the page objects
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions
    public String validataLoginPageTitle() {
        return driver.getTitle();
    }

    public Homepage login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
        return new Homepage();
    }

}
