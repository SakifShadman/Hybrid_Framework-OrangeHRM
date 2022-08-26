package TestCases;

import Screenshot.Util.TestUtil;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestUtil.class)
public class DataImportPageTest extends TestBase{

    @Test
    public void validateDataImport() {
        startLoginPage()
                .loginToPIMPage()
                .navigateToDataImportPage()
                .uploadFile();
    }
}