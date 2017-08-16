package app.pages;

import app.business_objects.Mail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import core.driver.WebDriverSingleton;

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

    public boolean isMailPresent(By locator, Mail mail) {
        boolean s = false;
        if (driver.findElement(locator).getText().equals(mail.getSubject()))
            s=true;
        return s;
    }

}
