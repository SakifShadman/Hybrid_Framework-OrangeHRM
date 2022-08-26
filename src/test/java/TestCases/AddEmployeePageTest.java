package TestCases;

import Pages.AddEmployeePage;
import Util.TestUtil;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestUtil.class)
public class AddEmployeePageTest extends TestBase{

    @Test(dataProvider = "newEmployeeData", dataProviderClass = AddEmployeePage.class)
    public void validateAddNewEmployeeTest(String firstName, String middleName, String lastName) {
        startLoginPage()
                .loginToPIMPage()
                .clickOnAddEmployeePage()
                .addNewEmployee(firstName, middleName, lastName);
    }
}