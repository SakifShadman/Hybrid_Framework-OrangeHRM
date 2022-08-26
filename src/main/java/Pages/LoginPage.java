package Pages;

import Browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver = Browser.driver;

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement passWord;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public LoginPage validateLoginPageTitle() {
        Assert.assertEquals(driver.getTitle(), "OrangeHRM", "title is not matched");
        return this;
    }

    public LoginPage validateLoginButton() {
        Assert.assertTrue(loginButton.isDisplayed());
        return this;
    }

    public PMIPage loginToPIMPage() {
        userName.sendKeys(Browser.getPropertyValue("user"));
        passWord.sendKeys(Browser.getPropertyValue("pass"));
        loginButton.click();

        return PageFactory.initElements(driver, PMIPage.class);
    }
}