package TestCases;

import Util.TestUtil;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestUtil.class)
public class AdminPageTest extends TestBase {

    @Test(priority = 1)
    public void adminLabelTest() {
        startLoginPage()
                .navigateToPIMPage()
                .navigateToAdminPage()
                .verifyAdminLabel();
    }

    @Test(priority = 2)
    public void selectAdminNameTest() {
        startLoginPage()
                .navigateToPIMPage()
                .navigateToAdminPage()
                .selectAdminName("David.Morris")
                .selectAdminName("Joe.Root");
    }
}