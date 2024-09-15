package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage {
    public RegistrationPage (WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements (new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@id='name']")
    WebElement inputName;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement inputLastName;

    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;

   @FindBy(xpath = "//label[@for='terms-of-use']")
   WebElement inputCheckBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;

    public RegistrationPage typeName(String name) {
        if(inputName.isDisplayed()) {
            inputName.sendKeys(name);
        }
        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        if(inputLastName.isDisplayed()) {
            inputLastName.sendKeys(lastName);
        }
        return this;
    }

    public RegistrationPage typeEmail(String email) {
        if(inputEmail.isDisplayed()) {
            inputEmail.sendKeys(email);
        }
        return this;
    }

    public RegistrationPage typePassword(String password) {
        if(inputEmail.isDisplayed()) {
            inputPassword.sendKeys(password);
        }
        return this;
    }

    public RegistrationPage clickCheckBox() {
        System.out.println(inputCheckBox.getRect().getWidth() +" X "+inputCheckBox.getRect().getHeight());
        int width= inputCheckBox.getRect().getWidth();
        int height = inputCheckBox.getRect().getHeight();
        Actions actions = new Actions(driver);
        actions.moveToElement(inputCheckBox, -width/4, -height/4).click().perform();
        return this;
    }

//    public RegistrationPage clickCheckBox () {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();",inputCheckBox);
//        return this;
//        }

        public LogoutPage clickbtnYalla () {
        btnYalla.click();
        return new LogoutPage(driver);
        }

    }

