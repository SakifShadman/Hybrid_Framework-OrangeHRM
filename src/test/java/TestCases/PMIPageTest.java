package TestCases;

import Util.TestUtil;
import org.testng.annotations.*;

@Listeners(TestUtil.class)
public class PMIPageTest extends TestBase {

    @Test(priority = 1)
    public void employeeListTest() {
        startLoginPage()
                .loginToPIMPage()
                .verifyEmployeeList();
    }
}