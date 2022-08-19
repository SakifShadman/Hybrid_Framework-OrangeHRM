package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.PMIPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PMIPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    PMIPage pmiPage;

    public PMIPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        pmiPage = new PMIPage();
        homePage = loginPage.login(prop.getProperty("user"), prop.getProperty("pass"));
        pmiPage = homePage.clickOnPMIPage();
    }

    @Test(priority = 1)
    public void employeeListTest() {
        Assert.assertTrue(pmiPage.verifyEmployeeList(), "employee list label is missing on the page");
    }

    @Test(priority = 2)
    public void clickAddEmployeeTest() {
        pmiPage.clickOnAddEmployee();
    }

    @DataProvider
    public void getTestData() {

    }

    @Test(priority = 3)
    public void validateAddNewEmployeeTest() {
        pmiPage.clickOnAddEmployee();
        pmiPage.addNewEmployee("Sakif","Shadman","Arnob");
    }
}