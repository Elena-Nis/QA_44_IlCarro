package pages;

import org.openqa.selenium.JavascriptExecutor;
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

   // @FindBy(xpath = "//input[@formcontrolname='termsOfUse']")
   // WebElement inputCheckBox;

    //@FindBy(xpath = "//label[contains(text(), ' I gree to the ')]")
    //WebElement inputCheckBox;

  //  @FindBy(xpath = "//label[contains(@class, 'checkbox-label') and contains(@class, 'terms-label')]")
  //  WebElement inputCheckBox;

    public LoginPage typeName(String name) {
        if(inputName.isDisplayed()) {
            inputName.sendKeys(name);
        }
        return this;
    }

    public LoginPage typeLastName(String lastName) {
        if(inputLastName.isDisplayed()) {
            inputLastName.sendKeys(lastName);
        }
        return this;
    }

    public LoginPage typeEmail(String email) {
        if(inputEmail.isDisplayed()) {
            inputEmail.sendKeys(email);
        }
        return this;
    }

    public LoginPage typePassword(String password) {
        if(inputEmail.isDisplayed()) {
            inputPassword.sendKeys(password);
        }
        return this;
    }

    public void clickCheckBox () {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",inputCheckBox);
       // inputCheckBox.click();

        }

        public void clickbtnYalla () {
        btnYalla.click();
        }

    }

