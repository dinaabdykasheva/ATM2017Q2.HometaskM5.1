package test;

import core.driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

/**
 * Created by Dina_Abdykasheva on 8/10/2017.
 */
public class BaseTest {
    public WebDriver driver;

    public BaseTest() {
        this.driver = WebDriverSingleton.getWebDriverInstance();
    }

    @AfterClass(description = "closeDriver")
    public void closeDriver() {
        driver.close();
    }
}
