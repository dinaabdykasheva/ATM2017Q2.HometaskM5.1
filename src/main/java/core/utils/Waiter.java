package core.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Dina_Abdykasheva on 8/15/2017.
 */
public class Waiter {
    public static void waitForElementPresent(WebDriver driver, ExpectedCondition<WebElement> expectedConditions) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(expectedConditions);
    }
}
