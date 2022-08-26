package Pages;

import Browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class PMIPage extends Browser {
    WebDriver driver = Browser.driver;

    @FindBy(linkText = "Employee List")
    @CacheLookup
    WebElement employeeListLabel;

    @FindBy(css = "button[type='submit']")
    WebElement searchButton;

    @FindBy(linkText = "Add Employee")
    WebElement addEmployeeLink;

    @FindBy(linkText = "Admin")
    WebElement adminLink;

    public PMIPage verifyEmployeeList() {
        Assert.assertTrue(employeeListLabel.isDisplayed());
        return this;
    }

    public PMIPage searchEmployeeId(String id) {
        List<WebElement> list = driver.findElements(By.cssSelector(".oxd-input.oxd-input--active"));
        list.get(1).sendKeys(id);
        searchButton.click();
        return this;
    }

    public PMIPage validateFirstAndLastName(String firstName, String lastName) {
        List<WebElement> list = driver.findElements(By.cssSelector(".oxd-table-cell.oxd-padding-cell"));
        Assert.assertEquals(list.get(2).getText(), firstName, "First name not matched");
        Assert.assertEquals(list.get(3).getText(), lastName, "Last name not matched");
        return this;
    }

    public AddEmployeePage clickOnAddEmployeePage() {
        addEmployeeLink.click();
        return PageFactory.initElements(driver, AddEmployeePage.class);
    }

    public AdminPage clickOnAdminPage() {
        adminLink.click();
        return PageFactory.initElements(driver, AdminPage.class);
    }
}