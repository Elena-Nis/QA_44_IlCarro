package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        setDriver(driver);
        driver.get("https://ilcarro.web.app/search");
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//a[text()='Sign up']")
    WebElement linkSignUp;

    @FindBy(xpath = "//a[text()='Log in']")
    WebElement logIn;


    public RegistrationPage clickSignUpLink() {
        linkSignUp.click();
        return new RegistrationPage(driver);
    }

    public LoginPage clickBtnLogin() {
        logIn.click();
        return new LoginPage(driver);
    }

}
