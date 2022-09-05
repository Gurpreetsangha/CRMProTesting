package Pages;

import Browser.Browser;
import Informations.RegisterInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
    WebDriver driver = Browser.driver;

    @FindBy(id = "payment_plan_id")
    WebElement dropDown;

    @FindBy(name = "first_name")
    WebElement firstName;

    @FindBy(name = "surname")
    WebElement lastName;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "email_confirm")
    WebElement confirmEmail;

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement passWord;

    @FindBy(name = "passwordconfirm")
    WebElement confirmPassWord;

    @FindBy(name = "agreeTerms")
    WebElement checkBox;

    @FindBy(id = "submitButton")
    WebElement submitButton;

    public void register() {
        Select select = new Select(dropDown);
        select.selectByVisibleText("Free Edition");

        firstName.sendKeys(RegisterInformation.FIRST_NAME);
        lastName.sendKeys(RegisterInformation.LAST_NAME);
        email.sendKeys(RegisterInformation.Email);
        confirmEmail.sendKeys(RegisterInformation.Email);
        userName.sendKeys(RegisterInformation.USER_NAME);
        passWord.sendKeys(RegisterInformation.PASS_WORD);
        confirmPassWord.sendKeys(RegisterInformation.PASS_WORD);
        //checkBox.click();
    }
}