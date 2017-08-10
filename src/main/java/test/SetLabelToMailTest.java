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
public class SetLabelToMailTest extends BaseTest {
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

    @Test(description = "setLabelToMail", dependsOnMethods = "verifySentMail")
    public void setLabelToMailTest(){
        sentMailPage = sentFolderPage.openSentMail().setLabel();
        boolean isLabelSet = sentMailPage.isLabelSet();
        Assert.assertTrue(isLabelSet, "Label to mail wasn't set");
    }
}
