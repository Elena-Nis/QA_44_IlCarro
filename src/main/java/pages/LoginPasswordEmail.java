package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPasswordEmail extends BasePage {
    public LoginPasswordEmail(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;

    public LoginPasswordEmail typeEmail(String email) {
        if(inputEmail.isDisplayed()) {
            inputEmail.sendKeys(email);
        }
        return this;
    }

    public LoginPasswordEmail typePassword(String password) {
        if(inputPassword.isDisplayed()) {
            inputPassword.sendKeys(password);
        }
        return this;
    }

    public LogoutPage clickbtnYalla () {
        btnYalla.click();
        return  new LogoutPage(driver);
    }

}