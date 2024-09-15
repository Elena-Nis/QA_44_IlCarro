package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {
    public LoginPage (WebDriver driver) {
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

    @FindBy(xpath = "//h2[@class='message']")
    WebElement textPopUp_Login;

    @FindBy(xpath = "//div[contains(text(), 'not look like email')]")
    WebElement errorMessage;

    @FindBy(xpath = "//div[contains(text(), 'Email is required')]")
    WebElement errorMessage1;

    @FindBy(xpath = "//div[contains(text(), 'Password is required')]")
    WebElement errorMessage2;

    public LoginPage typeEmail(String email) {
        if(inputEmail.isDisplayed()) {
            inputEmail.clear();
            inputEmail.sendKeys(email);
        }
        return this;
    }

    public  LoginPage typePassword(String password) {
        if(inputPassword.isDisplayed()) {
            inputPassword.sendKeys(password);
        }
        return this;
    }

    public LogoutPage clickbtnYalla () {
        btnYalla.click();
        pause(3);
        return  new LogoutPage(driver);
    }

    public boolean isTextInElementPresent_LoginSuccess(){
        return isTextInElementPresent(textPopUp_Login, "Logged in success");
    }


    public boolean isErrorEmailMessageDisplayed() {
        //pause(3);
        try {
            if (errorMessage.isDisplayed()) {
                pause(3);
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException");
        }
        try {
            if (errorMessage1.isDisplayed()) {
               return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException");
        }
          return false;
}

    public boolean isErrorPasswordMessageDisplayed() {
        //pause(3);
        try {
            if (errorMessage2.isDisplayed()) {
                pause(3);
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException");
        }

        return false;
    }


    public LoginPage clickbtnYallaNegative() {
        btnYalla.click();
        return this;
    }

    public boolean isTextInElementPresent_LogIncorrect(){
        return isTextInElementPresent(textPopUp_Login, "Login or Password incorrect");
    }

}