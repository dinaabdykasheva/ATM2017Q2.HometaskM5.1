package test;

import core.driver.WebDriverSingleton;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by Dina_Abdykasheva on 8/10/2017.
 */
public class BaseTest {
    @BeforeClass
    public void startDriver() {
        WebDriverSingleton.getWebDriverInstance();
    }

    @AfterClass(description = "closeDriver")
    public void closeDriver() {
        WebDriverSingleton.kill();
    }
}
