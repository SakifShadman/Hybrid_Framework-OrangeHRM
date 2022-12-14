package TestCases;

import Util.TestUtil;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestUtil.class)
public class DataImportPageTest extends TestBase{

    @Test
    public void validateDataImport() {
        startLoginPage()
                .navigateToPIMPage()
                .navigateToDataImportPage()
                .uploadFile();
    }
}