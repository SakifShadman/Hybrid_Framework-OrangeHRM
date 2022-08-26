package TestCases;

import Util.TestUtil;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value = TestUtil.class)
public class LoginPageTest extends TestBase {

    @Test
    public void loginPageTest() {
        startLoginPage()
                .validateLoginPageTitle()
                .validateLoginButton()
                .loginToPIMPage();
    }
}