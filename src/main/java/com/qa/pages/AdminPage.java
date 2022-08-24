package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends TestBase {

    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='oxd-topbar-header-title']")
    WebElement adminLabel;

    public boolean verifyAdminLabel() {
        return adminLabel.isDisplayed();
    }

    public void selectAdminName(String name) {
        driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]" +
                "//parent::div[@class='oxd-table-cell oxd-padding-cell']" +
                "//preceding-sibling::div[@class='oxd-table-cell oxd-padding-cell']" +
                "//div[@class='oxd-checkbox-wrapper']")).click();
    }
}