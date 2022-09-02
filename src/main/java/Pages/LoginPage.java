package Pages;

import Browser.Browser;
import Informations.Info;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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

    public LoginPage brokenLinkAndActiveLink() {
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        allLinks.addAll(driver.findElements(By.tagName("//img")));
        //System.out.println("Size of full links and images---> " + allLinks.size());

        List<WebElement> activeLinks = new ArrayList<>();

        for (WebElement element : allLinks) {
            //System.out.println(element.getAttribute("href"));
            if ((element.getAttribute("href") != null) && (!element.getAttribute("href").contains("javascript"))) {
                activeLinks.add(element);
            }
        }
        //System.out.println("Size of active links and images---> " + activeLinks.size());

        Assert.assertEquals(allLinks.size(), activeLinks.size());

        for (WebElement element : activeLinks) {
            HttpURLConnection connection = null;

            try {
                connection = (HttpURLConnection) new URL(element.getAttribute("href")).openConnection();
                connection.connect();
                String response = connection.getResponseMessage();
                connection.disconnect();
                System.out.println(element.getAttribute("href") + " ---> " + response);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return this;
    }

    public HomePage login() {
        userName.sendKeys(Info.USER_NAME);
        passWord.sendKeys(Info.PASS_WORD);
        loginButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }
}