package TestCases;

import Browser.Browser;
import Pages.LoginPage;
import Screenshot.Util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Browser.initialization();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        driver.navigate().to(Browser.getPropertyValue("url"));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public LoginPage startLoginPage() {
        return PageFactory.initElements(Browser.driver, LoginPage.class);
    }
}