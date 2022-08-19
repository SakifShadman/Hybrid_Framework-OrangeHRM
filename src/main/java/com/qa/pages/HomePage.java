package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement userNameLabel;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//span[normalize-space()='Admin']")
    WebElement admin;

    @FindBy(xpath = "//span[normalize-space()='My Info']")
    WebElement myInfo;

    @FindBy(xpath = "//span[normalize-space()='Directory']")
    WebElement directory;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public boolean verifyUserNameLabel() {
        return userNameLabel.isDisplayed();
    }

    public AdminPage clickOnAdmin() {
        admin.click();
        return new AdminPage();
    }

    public MyInfoPage clickOnMyInfo() {
        myInfo.click();
        return new MyInfoPage();
    }

    public DirectoryPage clickOnDirection() {
        directory.click();
        return new DirectoryPage();
    }
}