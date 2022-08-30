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
        driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]" +
                "//parent::div[@class='oxd-table-cell oxd-padding-cell']" +
                "//preceding-sibling::div[@class='oxd-table-cell oxd-padding-cell']" +
                "//div[@class='oxd-checkbox-wrapper']")).click();
        return this;
    }
}