package pages;

import org.openqa.selenium.By;

/**
 * Created by Dina_Abdykasheva on 6/16/2017.
 */
public class DraftsFolderPage extends AbstractPage {
    private static final By DRAFT_MAIL_LOCATOR = By.xpath(".//span[contains(text(), 'mentoring task')]");

    public boolean isDraftMailDisplayed() {
        return isElementPresent(DRAFT_MAIL_LOCATOR);
    }

    public WriteMailPage openDraftMail() {
        driver.findElement(DRAFT_MAIL_LOCATOR).click();
        return new WriteMailPage();
    }
}
