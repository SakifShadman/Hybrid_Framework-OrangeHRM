package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Initializing the Page Objects:
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Page Factory - OR:
    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement passWord;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
    WebElement forgotPassword;

    //Actions:
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateLoginButton() {
        return loginButton.isDisplayed();
    }

    public HomePage login(String un, String pwd) {
        userName.sendKeys(un);
        passWord.sendKeys(pwd);
        loginButton.click();

        return new HomePage();
    }
}