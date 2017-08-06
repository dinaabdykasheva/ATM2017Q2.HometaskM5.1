package test;

import business_objects.User;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by User on 06.08.2017.
 */
public class DeleteSentMailTest extends AbstractPage {
    public AccountPage accountPage;
    public SentFolderPage sentFolderPage;
    public SentMailPage sentMailPage;

    public DeleteSentMailTest() {
    }

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

    @Test(description = "deleteSentMail", dependsOnMethods = "verifySentMail")
    public void deleteSentMail() {
        sentMailPage = new SentFolderPage().openSentMail().deleteSentMail();
        boolean isMailDeleted = sentMailPage.isMailDeleted();
        Assert.assertTrue(isMailDeleted, "Mail wasn't deleted");

    }
}

