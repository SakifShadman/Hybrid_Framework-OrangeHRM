package Pages;

import Browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PMIPage extends Browser {
    WebDriver driver = Browser.driver;

    @FindBy(linkText = "Employee List")
    @CacheLookup
    WebElement employeeListLabel;

    @FindBy(linkText = "Add Employee")
    WebElement addEmployeeLink;

    @FindBy(linkText = "Admin")
    WebElement adminLink;

    public PMIPage verifyEmployeeList() {
        Assert.assertTrue(employeeListLabel.isDisplayed());
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