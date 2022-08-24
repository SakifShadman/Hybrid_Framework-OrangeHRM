package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.PMIPage;
import com.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners(TestUtil.class)
public class PMIPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    PMIPage pmiPage;

    String sheetName = "New Employee";

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
    public void clickAddEmployeeTest()  {
        pmiPage.clickOnAddEmployee();
    }

    @DataProvider
    public Object[][] getOrangeHRMTestData() {
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 3, dataProvider = "getOrangeHRMTestData")
    public void validateAddNewEmployeeTest(String firstName, String middleName, String lastName) {
        pmiPage.clickOnAddEmployee();
        pmiPage.addNewEmployee(firstName, middleName, lastName);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}