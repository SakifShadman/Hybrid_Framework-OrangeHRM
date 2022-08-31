package Pages;

import Browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AdminPage {
    WebDriver driver = Browser.driver;

    @FindBy(xpath = "//div[@class='oxd-topbar-header-title']")
    WebElement adminLabel;

    public void verifyAdminLabel() {
         Assert.assertTrue(adminLabel.isDisplayed(), "Admin label not displayed");
    }

    public AdminPage selectAdminName(String name) {
        WebElement element = driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]//parent::div"
                + "//preceding-sibling::div//div[@class='oxd-checkbox-wrapper']"));

        element.click();
        return this;
    }
}