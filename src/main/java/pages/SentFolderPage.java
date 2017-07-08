package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dina_Abdykasheva on 6/16/2017.
 */
public class SentFolderPage extends AbstractPage{
    private static final By SENT_MAIL_LOCATOR = By.xpath(".//span[contains(text(), 'mentoring task')]");

    public SentFolderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMailSent() {
        return !driver.findElements(SENT_MAIL_LOCATOR).isEmpty();
    }
}
