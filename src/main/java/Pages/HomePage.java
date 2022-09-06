package Pages;

import Browser.Browser;
import Utilities.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver = Browser.driver;

    @FindBy(css = "a[title='Contacts']")
    WebElement contactLink;

    @FindBy(css = "a[title='New Contact']")
    WebElement newContactLink;

    @FindBy(xpath = "//a[contains(text(), 'Calendar')]")
    WebElement CalendarLink;

    @FindBy(xpath = "//a[contains(text(), 'New Event')]")
    WebElement NewEventLink;

    @FindBy(xpath = "//a[contains(text(), 'View Today')]")
    WebElement ViewTodayLink;

    @FindBy(xpath = "//a[contains(text(), 'Month View')]")
    WebElement MonthViewLink;

    public ContactPage navigateToContactPage() {
        Util.switchFrame();
        contactLink.click();
        return PageFactory.initElements(driver, ContactPage.class);
    }

    public NewContactPage navigateToNewContactPage() {
        Util.switchFrame();
        Actions action = new Actions(driver);
        action.moveToElement(contactLink).build().perform();
        newContactLink.click();
        return PageFactory.initElements(driver, NewContactPage.class);
    }

    public CalenderPage navigateToCalendar(){
        Util.switchFrame();
        Actions actions=new Actions(driver);
        actions.moveToElement(CalendarLink).build().perform();
        CalendarLink.click();
        return PageFactory.initElements(driver, CalenderPage.class);
    }
}