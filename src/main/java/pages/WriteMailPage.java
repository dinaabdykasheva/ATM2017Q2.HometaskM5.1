package pages;

import business_objects.Mail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Logger;

/**
 * Created by Dina_Abdykasheva on 6/15/2017.
 */
public class WriteMailPage extends AbstractPage{
    private static final By TO_FIELD_LOCATOR = By.name("to");
    private static final By SUBJECT_FIELD_LOCATOR = By.name("subjectbox");
    private static final By BODY_FIELD_LOCATOR = By.xpath(".//div[@role='textbox']");
    private static final By CLOSE_WRITE_MAIL_WINDOW_LOCATOR = By.xpath(".//img[@class='Ha']");
    private static final By SEND_MAIL_BUTTON_LOCATOR = By.xpath(".//div[@class = 'T-I J-J5-Ji aoO T-I-atl L3']");
    private static final By DRAFTS_FOLDER_LOCATOR = By.xpath(".//div[@class = 'TN GLujEb aHS-bnq']");
    private static final By SAVING_LABEL_LOCATOR = By.xpath(".//span[@class = 'oG aOy']");
    private static final By TO_FIELD_IN_DRAFT_LOCATOR = By.xpath(".//span[@class='vN bfK a3q']");
    private static final By MAIL_IS_SENT_LOCATOR = By.xpath(".//div[contains (text(), 'Письмо отправлено')]");
    private static final By DIALOG_WINDOW_LOCATOR = By.xpath(".//div[@role = 'dialog']");

    public WriteMailPage(WebDriver driver) {
        super(driver);
    }

    public DraftsFolderPage writeMailAndSaveToDraft(Mail mail) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(DIALOG_WINDOW_LOCATOR));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TO_FIELD_LOCATOR)).sendKeys(mail.getRECIPIENT());
        driver.findElement(SUBJECT_FIELD_LOCATOR).sendKeys(mail.getSUBJECT());
        driver.findElement(BODY_FIELD_LOCATOR).sendKeys(mail.getBODY());
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVING_LABEL_LOCATOR));
        driver.findElement(CLOSE_WRITE_MAIL_WINDOW_LOCATOR).click();
        driver.findElement(DRAFTS_FOLDER_LOCATOR).click();
        return new DraftsFolderPage(driver);
    }

    public String getReceiver() {
        return driver.findElement(TO_FIELD_IN_DRAFT_LOCATOR).getAttribute("email");
    }

    public String getSubject() {
        return driver.findElement(SUBJECT_FIELD_LOCATOR).getAttribute("value");
    }

    public String getBody() {
        return driver.findElement(BODY_FIELD_LOCATOR).getText();
    }

    public AccountPage sendMail() {
        driver.findElement(SEND_MAIL_BUTTON_LOCATOR).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MAIL_IS_SENT_LOCATOR));
        Logger.info("Mail was successfully sent");
        return new AccountPage(driver);
    }

}
