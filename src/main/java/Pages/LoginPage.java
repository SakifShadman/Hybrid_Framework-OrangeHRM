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

    public void validateLoginPageTitle() {
        Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Title is not matched");
    }

    public void validateLoginButton() {
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
    }

    public PMIPage navigateToPIMPage() {
        userName.sendKeys(Browser.getPropertyValue("user"));
        passWord.sendKeys(Browser.getPropertyValue("pass"));
        loginButton.click();

        return PageFactory.initElements(driver, PMIPage.class);
    }
}