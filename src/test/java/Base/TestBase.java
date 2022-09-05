package Base;

import Browser.Browser;
import Informations.LoginInformation;
import Pages.LoginPage;
import Utilities.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Browser.initializeBrowser();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT));
        driver.navigate().to(LoginInformation.URL);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public LoginPage crmPro() {
        return PageFactory.initElements(driver, LoginPage.class);
    }
}