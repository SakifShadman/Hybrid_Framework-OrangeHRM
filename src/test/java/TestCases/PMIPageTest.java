package TestCases;

import Screenshot.Util.TestUtil;
import org.testng.annotations.*;

@Listeners(TestUtil.class)
public class PMIPageTest extends TestBase {

    @Test
    public void employeeListTest() {
        startLoginPage()
                .loginToPIMPage()
                .verifyEmployeeList()
                .searchEmployeeId("0221")
                .validateFirstAndLastName("Alice", "Duval");
    }
}