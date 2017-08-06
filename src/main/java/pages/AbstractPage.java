package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import utils.WebDriverSingleton;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dina_Abdykasheva on 6/15/2017.
 */
public class AbstractPage {

    protected WebDriver driver;

    protected AbstractPage() {
        this.driver = WebDriverSingleton.getWebDriverInstance();
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    public void waitForElementPresent(ExpectedCondition<WebElement> expectedConditions) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(expectedConditions);
    }

    @AfterClass(description = "closeDriver")
    public void closeDriver() {
        driver.close();
    }
}
