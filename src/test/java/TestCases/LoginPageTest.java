package TestCases;

import Util.TestUtil;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestUtil.class)
public class LoginPageTest extends TestBase {

    @Test(priority = 1)
    public void loginPageTitleTest() {
        startLoginPage()
                .validateLoginPageTitle();
    }

    @Test(priority = 2)
    public void loginButtonTest() {
        startLoginPage()
                .validateLoginButton();
    }
    @Test(priority = 3)
    public void loginPageTest() {
        startLoginPage()
                .navigateToPIMPage();
    }
}