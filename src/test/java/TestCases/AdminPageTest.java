package TestCases;

import Util.TestUtil;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestUtil.class)
public class AdminPageTest extends TestBase {

    @Test
    public void adminLabelTest() {
        startLoginPage()
                .navigateToPIMPage()
                .navigateToAdminPage()
                .verifyAdminLabel();
    }

    @Test
    public void selectAdminNameTest() {
        startLoginPage()
                .navigateToPIMPage()
                .navigateToAdminPage()
                .selectAdminName("Aaliyah.Haq")
                .selectAdminName("Anthony.Nolan");
    }
}