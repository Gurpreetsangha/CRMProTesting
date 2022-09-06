package Pages;

import Browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalenderPage {
    WebDriver driver = Browser.driver;

    @FindBy(xpath = "//a[contains(text(), 'New Event')]")
    WebElement NewEventLink;

    @FindBy(className = "calendarcellfull")
    WebElement FirstEvent;

    @FindBy(name = "slctMonth")
    WebElement MonthPicker;

    @FindBy(name = "slctYear")
    WebElement YearPicker;

    @FindBy(className = "calendarcellfull")
    WebElement NewYearEvent;

}