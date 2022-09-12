package Pages;

import Browser.Browser;
import Util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class RecruitmentPage {
    WebDriver driver = Browser.driver;

    @FindBy(xpath = "//div[@role='listbox']//div//span")
    List<WebElement> listOfJobTitleDropDown;

    @FindBy(css = ".oxd-select-text.oxd-select-text--active")
    List<WebElement> listOfDropDownBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='oxd-table-card']//div//div[3]")
    List<WebElement> listOfCandidateName;

    public RecruitmentPage validateSearchByJobTitle(String title) {
        listOfDropDownBox.get(0).click();

        for (WebElement element : listOfJobTitleDropDown) {
            if (element.getText().equalsIgnoreCase(title)) {
                element.click();
                break;
            }
        }
        searchButton.click();
        return this;
    }

    public RecruitmentPage validateCandidateName(String name) {
        boolean isPresent = false;

        for (WebElement element : listOfCandidateName) {
            if (element.getText().equalsIgnoreCase(name)) {
                isPresent = true;
            }
        }
        Assert.assertTrue(isPresent);
        return this;
    }

    public RecruitmentPage selectCandidateName(String name) {
        List<WebElement> allRows = driver.findElements(By.xpath("//div[@class='oxd-table-card']"));

        for (WebElement row: allRows) {
            //System.out.println(row.get);
//            String cName = row.findElement(By.xpath("//div[3]")).getText();
//            System.out.println("************" + cName);

            if (row.getText().equalsIgnoreCase(name)) {
                row.findElement(By.xpath("//div[@class='oxd-table-card']//div[1]//div")).click();
            }
        }

        //TestUtil.explicitWait(element).click();
        return this;
    }
}