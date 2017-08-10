package test;

import business_objects.User;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

/**
 * Created by User on 06.08.2017.
 */
public class DeleteSentMailTest extends BaseTest {
    public AccountPage accountPage;
    public SentFolderPage sentFolderPage;
    public SentMailPage sentMailPage;
    public LoginToGMailPage login;

    @Test(description = "loginToAccountTest", priority = 0)
    @Parameters({"username", "password"})
    public void loginToAccountTest(String username, String password) {
        accountPage = login.loginToGMail(new User(username, password));
        boolean isAccountIconPresent = accountPage.isAccountIconPresent();
        Assert.assertTrue(isAccountIconPresent, "User isn't logged in");
    }

    @Test(description = "verifySentMail", dependsOnMethods = "loginToGMailTest")
    public void verifySentMail() {
        sentFolderPage = accountPage.openSentMail();
        boolean isMailSent = sentFolderPage.isMailSent();
        Assert.assertTrue(isMailSent, "Mail wasn't sent");
    }

    @Test(description = "deleteSentMail", dependsOnMethods = "verifySentMail")
    public void deleteSentMail() {
        sentMailPage = sentFolderPage.openSentMail().deleteSentMail();
        boolean isMailDeleted = sentMailPage.isMailDeleted();
        Assert.assertTrue(isMailDeleted, "Mail wasn't deleted");

    }
}

