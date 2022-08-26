package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Browser {
    public static WebDriver driver;
    public static Properties prop;

    public static String getPropertyValue(String propertyName) {
        String propertyValue = "";

        try {
            prop = new Properties();
            InputStream ip = new FileInputStream("src/main/java/Config/config.properties");
            prop.load(ip);
            propertyValue = prop.getProperty(propertyName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return propertyValue;
    }

    public static WebDriver initialization() {
        String browserName = getPropertyValue("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
}