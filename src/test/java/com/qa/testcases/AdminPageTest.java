package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.AdminPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestUtil.class)
public class AdminPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    AdminPage adminPage;

    public AdminPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        adminPage = new AdminPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("user"), prop.getProperty("pass"));
        adminPage = homePage.clickOnAdminPage();
    }

    @Test(priority = 1)
    public void adminLabelTest() {
        Assert.assertTrue(adminPage.verifyAdminLabel(), "admin label is missing on the page");
    }

    @Test(priority = 2)
    public void selectSingleAdminNameTest() {
        adminPage.selectAdminName("Anthony.Nolan");
    }

    @Test(priority = 3)
    public void selectMultipleAdminNameTest() {
        adminPage.selectAdminName("Anthony.Nolan");
        adminPage.selectAdminName("Maxim");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}