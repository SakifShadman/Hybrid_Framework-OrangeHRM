package TestCases;

import Util.TestUtil;
import org.testng.annotations.*;

@Listeners(TestUtil.class)
public class PMIPageTest extends TestBase {

    @Test(priority = 1)
    public void employeeListTest() {
        startLoginPage()
                .navigateToPIMPage()
                .verifyEmployeeList();
    }

    @Test(priority = 2)
    public void employeeIdTest() {
        startLoginPage()
                .navigateToPIMPage()
                .searchEmployeeId("0083")
                .validateFirstAndLastName("Joe", "Root");
    }
}