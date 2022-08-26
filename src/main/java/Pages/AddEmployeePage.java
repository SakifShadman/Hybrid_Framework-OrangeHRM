package Pages;

import Browser.Browser;
import Screenshot.Util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

public class AddEmployeePage {
    WebDriver driver = Browser.driver;
    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(name = "middleName")
    WebElement middleName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;

    public void addNewEmployee(String fName, String mName, String lName) {
        firstName.sendKeys(fName);
        middleName.sendKeys(mName);
        lastName.sendKeys(lName);
        saveButton.click();
    }

    @DataProvider(name = "newEmployeeData")
    public Object[][] getOrangeHRMTestData() {
        Object data[][] = TestUtil.getTestData("New Employee");
        return data;
    }
}
