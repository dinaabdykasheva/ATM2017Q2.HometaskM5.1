package app.pages;

import org.openqa.selenium.By;
import core.utils.Logger;

/**
 * Created by Dina_Abdykasheva on 6/15/2017.
 */
public class AccountPage extends AbstractPage {
    private static final By ACCOUNT_ICON_LOCATOR = By.xpath(".//span [@class='gb_7a gbii']");
    private static final By WRITE_MAIL_BUTTON_LOCATOR = By.xpath(".//div[@class='T-I J-J5-Ji T-I-KE L3']");
    private static final By DRAFTS_FOLDER_LOCATOR = By.xpath(".//a[contains(text(), 'Черновики')]");
    private static final By SENT_MAIL_FOLDER_LOCATOR = By.xpath(".//a[contains(text(), 'Отправленные')]");
    private static final By EXIT_BUTTON_LOCATOR = By.xpath(".//a[contains(text(), 'Выйти')]");

    public WriteMailPage clickWriteMailButton() {
        driver.findElement(WRITE_MAIL_BUTTON_LOCATOR).click();
        driver.switchTo().activeElement();
        return new WriteMailPage();
    }

    public boolean isAccountIconPresent() {
        Logger.info("User successfully logged in");
        return isElementPresent(ACCOUNT_ICON_LOCATOR);
    }

    public DraftsFolderPage openDrafts() {
        driver.findElement(DRAFTS_FOLDER_LOCATOR).click();
        return new DraftsFolderPage();
    }

    public SentFolderPage openSentMail() {
        driver.findElement(SENT_MAIL_FOLDER_LOCATOR).click();
        return new SentFolderPage();
    }

    public LoginToGMailPage exitGMail() {
        driver.findElement(ACCOUNT_ICON_LOCATOR).click();
        driver.findElement(EXIT_BUTTON_LOCATOR).click();
        return new LoginToGMailPage();
    }
}
