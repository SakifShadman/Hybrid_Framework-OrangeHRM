package Pages;

import Browser.Browser;
import Screenshot.Util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DataImportPage {
    WebDriver driver = Browser.driver;

    @FindBy(css = ".oxd-file-div.oxd-file-div--active")
    WebElement browseButton;

    @FindBy(css = "button[type='submit']")
    WebElement uploadButton;

    public DataImportPage uploadFile() {
        TestUtil.explicitWait(browseButton).sendKeys("src/main/java/TestData/ImportData.csv");
        uploadButton.click();
        return this;
    }
}