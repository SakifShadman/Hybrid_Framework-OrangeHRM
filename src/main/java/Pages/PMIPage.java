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

public class PMIPage {
    WebDriver driver = Browser.driver;

    @FindBy(linkText = "Employee List")
    @CacheLookup
    WebElement employeeListLabel;

    @FindBy(css = "button[type='submit']")
    WebElement searchButton;

    @FindBy(css = "span[class='oxd-topbar-body-nav-tab-item']")
    WebElement configurationDropDown;

    @FindBy(linkText = "Add Employee")
    WebElement addEmployeeLink;

    @FindBy(linkText = "Admin")
    WebElement adminLink;

    @FindBy(linkText = "Recruitment")
    WebElement recruitmentLink;

    public void verifyEmployeeList() {
        Assert.assertTrue(employeeListLabel.isDisplayed());
    }

    public PMIPage searchEmployeeId(String id) {
        List<WebElement> list = driver.findElements(By.cssSelector(".oxd-input.oxd-input--active"));

        list.get(1).sendKeys(id);
        searchButton.click();

        return this;
    }

    public void validateFirstAndLastName(String firstName, String lastName) {
        List<WebElement> list = driver.findElements(By.cssSelector(".oxd-table-cell.oxd-padding-cell"));

        Assert.assertEquals(list.get(2).getText(), firstName, "First name not matched");
        Assert.assertEquals(list.get(3).getText(), lastName, "Last name not matched");
    }

    public DataImportPage navigateToDataImportPage() {
        configurationDropDown.click();

        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='oxd-dropdown-menu']//li"));

        for (WebElement element : list) {
            if (element.getText().equals("Data Import")) {
                element.click();
                break;
            }
        }
        return PageFactory.initElements(driver, DataImportPage.class);
    }

    public AddEmployeePage navigateToAddEmployeePage() {
        addEmployeeLink.click();
        return PageFactory.initElements(driver, AddEmployeePage.class);
    }

    public AdminPage navigateToAdminPage() {
        adminLink.click();
        return PageFactory.initElements(driver, AdminPage.class);
    }

    public RecruitmentPage navigateToRecruitmentPage() {
        recruitmentLink.click();
        return PageFactory.initElements(driver, RecruitmentPage.class);
    }
}