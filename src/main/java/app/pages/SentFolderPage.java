package app.pages;

import app.business_objects.Mail;
import org.openqa.selenium.By;

/**
 * Created by Dina_Abdykasheva on 6/16/2017.
 */
public class SentFolderPage extends AbstractPage {
    private static final By SENT_MAIL_LOCATOR = By.className("bog");

    public boolean isMailSent(Mail mail) {
        return isMailPresent(SENT_MAIL_LOCATOR, mail);
    }

    public SentMailPage openSentMail() {
        driver.findElement(SENT_MAIL_LOCATOR).click();
        return new SentMailPage();
    }
}
