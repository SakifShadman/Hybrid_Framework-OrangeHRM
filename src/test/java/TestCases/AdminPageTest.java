package TestCases;

import Util.TestUtil;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestUtil.class)
public class AdminPageTest extends TestBase {

    @Test
    public void adminPageTest() {
        startLoginPage()
                .loginToPIMPage()
                .clickOnAdminPage()
                .verifyAdminLabel()
                .selectAdminName("Aaliyah.Haq");
    }
}