package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement userNameLabel;

    @FindBy(xpath = "//span[normalize-space()='Admin']")
    WebElement admin;

    @FindBy(xpath = "//a[@class='oxd-main-menu-item active']")
    WebElement pmi;

    @FindBy(xpath = "//span[normalize-space()='My Info']")
    WebElement myInfo;

    @FindBy(xpath = "//span[normalize-space()='Directory']")
    WebElement directory;

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public boolean verifyUserNameLabel() {
        return userNameLabel.isDisplayed();
    }

    public AdminPage clickOnAdminPage() {
        admin.click();
        return new AdminPage();
    }

    public PMIPage clickOnPMIPage() {
        pmi.click();
        return new PMIPage();
    }

    public MyInfoPage clickOnMyInfoPage() {
        myInfo.click();
        return new MyInfoPage();
    }

    public DirectoryPage clickOnDirectoryPage() {
        directory.click();
        return new DirectoryPage();
    }
}