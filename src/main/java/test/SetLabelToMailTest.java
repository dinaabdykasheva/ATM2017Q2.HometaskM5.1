package test;

import business_objects.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by User on 06.08.2017.
 */
public class SetLabelToMailTest extends AbstractPage {
    public AccountPage accountPage;
    public SentFolderPage sentFolderPage;
    public SentMailPage sentMailPage;

    public SetLabelToMailTest() {}

    @Test(description = "loginToAccountTest", priority = 0)
    @Parameters({"username", "password"})
    public void loginToAccountTest(String username, String password) {
        accountPage = new LoginToGMailPage().loginToGMail(new User(username, password));
        boolean isAccountIconPresent = accountPage.isAccountIconPresent();
        Assert.assertTrue(isAccountIconPresent, "User isn't logged in");
    }

    @Test(description = "verifySentMail", dependsOnMethods = "loginToGMailTest")
    public void verifySentMail() {
        sentFolderPage = new AccountPage().openSentMail();
        boolean isMailSent = sentFolderPage.isMailSent();
        Assert.assertTrue(isMailSent, "Mail wasn't sent");
    }

    @Test(description = "setLabelToMail", dependsOnMethods = "verifySentMail")
    public void setLabelToMailTest(){
        sentMailPage = new SentFolderPage().openSentMail().setLabel();
        boolean isLabelSet = sentMailPage.isLabelSet();
        Assert.assertTrue(isLabelSet, "Label to mail wasn't set");
    }
}