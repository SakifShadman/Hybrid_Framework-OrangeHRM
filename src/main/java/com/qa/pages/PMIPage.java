package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PMIPage extends TestBase {

    public PMIPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Employee List')]")
    @CacheLookup
    WebElement employeeList;

    @FindBy(xpath = "//a[contains(text(),'Add Employee')]")
    WebElement addEmployee;

    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(name = "middleName")
    WebElement middleName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveBtn;

    public boolean verifyEmployeeList() {
        return employeeList.isDisplayed();
    }

    public void clickOnAddEmployee() {
        addEmployee.click();
    }

    public void addNewEmployee(String fName, String mName, String lName) {
        firstName.sendKeys(fName);
        middleName.sendKeys(mName);
        lastName.sendKeys(lName);
        saveBtn.click();
    }
}