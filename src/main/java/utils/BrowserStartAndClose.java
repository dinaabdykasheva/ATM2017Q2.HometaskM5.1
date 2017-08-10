package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

/**
 * Created by Dina_Abdykasheva on 8/10/2017.
 */
public class BrowserStartAndClose {
    public WebDriver driver;

    public BrowserStartAndClose() {
        this.driver = WebDriverSingleton.getWebDriverInstance();
    }

    @AfterClass(description = "closeDriver")
    public void closeDriver() {
        driver.close();
    }
}
