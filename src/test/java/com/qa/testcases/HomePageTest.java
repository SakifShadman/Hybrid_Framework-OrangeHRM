package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    AdminPage adminPage;

    PMIPage pmiPage;
    DirectoryPage directoryPage;
    MyInfoPage myInfoPage;

    public HomePageTest() {
        super();
    }

    //test cases should be separated -- independent with each other
    //before each test case -- launch the browser and login
    //@test -- execute test case
    //after each test case -- close the browser
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        pmiPage = new PMIPage();
        directoryPage = new DirectoryPage();
        myInfoPage = new MyInfoPage();
        homePage = loginPage.login(prop.getProperty("user"), prop.getProperty("pass"));
    }

    @Test(priority = 1)
    public void homePageTitleTest() {
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "OrangeHRM", "Home page title not matched");
    }

    @Test(priority = 2)
    public void userNameLabelTest() {
        boolean isPresent = homePage.verifyUserNameLabel();
        Assert.assertTrue(isPresent);
    }

    @Test(priority = 3)
    public void adminPageTest() {
        adminPage = homePage.clickOnAdminPage();
    }

    @Test(priority = 4)
    public void pmiPageTest() {
        pmiPage = homePage.clickOnPMIPage();
    }
    @Test(priority = 5)
    public void myInfoPageTest() {
        myInfoPage = homePage.clickOnMyInfoPage();
    }
    @Test(priority = 6)
    public void directoryPageTest() {
        directoryPage = homePage.clickOnDirectoryPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}