package Pages;

import Browser.Browser;
import Informations.Info;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver = Browser.driver;

    @FindBy(linkText = "Home")
    WebElement homeLink;

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement passWord;

    @FindBy(css = ".btn.btn-small")
    WebElement loginButton;

    public LoginPage verifyHomeLink() {
        Assert.assertTrue(homeLink.isDisplayed(), "Home link is not found");
        return this;
    }

    public LoginPage pageTitle() {
        Assert.assertEquals(driver.getTitle(),
                "Free CRM - CRM software for customer relationship management, sales, and support.",
                "Page title is not matched");
        return this;
    }

    public HomePage login() {
        userName.sendKeys(Info.USER_NAME);
        passWord.sendKeys(Info.PASS_WORD);
        loginButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }
}