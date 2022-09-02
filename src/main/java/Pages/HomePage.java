package Pages;

import Browser.Browser;
import Utilities.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.sql.rowset.BaseRowSet;

public class HomePage {
    WebDriver driver = Browser.driver;

    @FindBy(css = "a[title='Contacts']")
    WebElement contactLink;

    @FindBy(css = "a[title='New Contact']")
    WebElement newContactLink;

    public ContactPage navigateToContactPage() {
        Util.switchFrame();
        Actions action = new Actions(driver);
        action.moveToElement(contactLink).build().perform();
        newContactLink.click();
        return PageFactory.initElements(driver, ContactPage.class);
    }
}
