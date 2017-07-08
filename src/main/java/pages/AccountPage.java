package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Logger;

/**
 * Created by Dina_Abdykasheva on 6/15/2017.
 */
public class AccountPage extends AbstractPage {
    private static final By ACCOUNT_ICON_LOCATOR = By.xpath(".//span [@class='gb_8a gbii']");
    private static final By WRITE_MAIL_BUTTON_LOCATOR = By.xpath(".//div[@class='T-I J-J5-Ji T-I-KE L3']");
    private static final By DRAFTS_FOLDER_LOCATOR = By.xpath(".//a[contains(text(), 'Черновики')]");
    private static final By SENT_MAIL_FOLDER_LOCATOR = By.xpath(".//a[contains(text(), 'Отправленные')]");
    private static final By EXIT_BUTTON_LOCATOR = By.xpath(".//a[contains(text(), 'Выйти')]");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public WriteMailPage clickWriteMailButton() {
        driver.findElement(WRITE_MAIL_BUTTON_LOCATOR).click();
        driver.switchTo().activeElement();
        return new WriteMailPage(driver);
    }

    public boolean isAccountIconPresent() {
        Logger.info("User successfully logged in");
        return !driver.findElements(ACCOUNT_ICON_LOCATOR).isEmpty();
    }

    public DraftsFolderPage openDrafts() {
        driver.findElement(DRAFTS_FOLDER_LOCATOR).click();
        return new DraftsFolderPage(driver);
    }

    public SentFolderPage openSentMail() {
        driver.findElement(SENT_MAIL_FOLDER_LOCATOR).click();
        return new SentFolderPage(driver);
    }

    public AccountPage exitGMail() {
        driver.findElement(ACCOUNT_ICON_LOCATOR).click();
        driver.findElement(EXIT_BUTTON_LOCATOR).click();
        return this;
    }
}
