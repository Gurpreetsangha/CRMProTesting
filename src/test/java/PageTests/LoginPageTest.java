package PageTests;

import Base.TestBase;
import Utilities.Util;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Util.class)
public class LoginPageTest extends TestBase {

    @Test(priority = 1)
    public void verifyPageTitleTest() {
        crmPro().pageTitle();
    }

    @Test(priority = 2)
    public void verifyHomeLinkTest() {
        crmPro().verifyHomeLink();
    }

    @Test(priority = 3)
    public void validateLoginTest() {
        crmPro().login();
    }
    
}