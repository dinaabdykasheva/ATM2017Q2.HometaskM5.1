package pages;

import business_objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Dina_Abdykasheva on 6/15/2017.
 */
public class LoginToGMailPage extends AbstractPage{
    private static final By USERNAME_INPUT_LOCATOR = By.name("identifier");
    private static final By NEXT_BUTTON_LOCATOR = By.id("identifierNext");
    private static final By PASSWORD_INPUT_LOCATOR = By.name("password");
    private static final By NEXT_BUTTON_LOCATOR1 = By.id("passwordNext");
    private static final By LOGIN_PAGE_LOCATOR = By.xpath(".//*[@class= 'sfYUmb']");
    private static final By PROFILE_IDENTIFIER_LOCATOR = By.id("profileIdentifier");

    public AccountPage loginToGMail(User user) {
        driver.get("https://www.google.com/gmail");
        driver.findElement(USERNAME_INPUT_LOCATOR).sendKeys(user.getUsername());
        driver.findElement(NEXT_BUTTON_LOCATOR).click();
        waitForElementPresent(ExpectedConditions.visibilityOfElementLocated(PROFILE_IDENTIFIER_LOCATOR));
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(user.getPassword());
        driver.findElement(NEXT_BUTTON_LOCATOR1).click();
        return new AccountPage();
    }

    public boolean isUserLoggedOff() {
        return isElementPresent(LOGIN_PAGE_LOCATOR);
    }
}
