package pages;

import dto.UserDto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "email")
    WebElement inputEmail;
    @FindBy(id = "password")
    WebElement inputPassword;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;
    @FindBy(xpath = "//h2[@class='message']")
    WebElement textPopUp_LoginSuccess;
    @FindBy(xpath = "//input[@id='email']/..//div[@class='error']/div")
    WebElement errorMessageInputEmail;
    @FindBy(xpath = "//input[@id='password']/following-sibling::div[@class = 'error']")
    WebElement errorMessageInputPassword;

    public LoginPage typeLoginForm(String email, String password) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        return this;
    }
    public LoginPage typeLoginForm(UserDto user) {
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
        return this;
    }

    public LoginPage clickBtnYalla() {
        pause(2);
        btnYalla.click();
        return this;
    }

    public boolean isTextInElementPresent_LoginSuccess(){
        return isTextInElementPresent(textPopUp_LoginSuccess, "Logged in success");
    }
    public boolean isTextInElementPresent_ErrorEmail(String text){
        return isTextInElementPresent(errorMessageInputEmail, text);
    }
    public boolean isTextInElementPresent_ErrorPasswordEmpty(String text){
        return isTextInElementPresent(errorMessageInputPassword, text);
    }

}