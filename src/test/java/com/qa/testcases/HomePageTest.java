package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.AdminPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    AdminPage adminPage;

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
        homePage = loginPage.login(prop.getProperty("user"), prop.getProperty("pass"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "OrangeHRM", "Home page title not matched");
    }

    @Test(priority = 2)
    public void verifyUserNameLabel() {
        boolean isPresent = homePage.verifyUserNameLabel();
        Assert.assertTrue(isPresent);
    }

    @Test(priority = 3)
    public void verifyAdminTest() {
        adminPage = homePage.clickOnAdmin();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}