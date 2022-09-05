package PageTests;

import Base.TestBase;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void contactPageTest() {
        crmPro()
                .login()
                .navigateToContactPage();
    }

    @Test
    public void newContactPageTest() {
        crmPro()
                .login()
                .navigateToNewContactPage();
    }
}
