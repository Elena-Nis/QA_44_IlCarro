package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LogoutPage extends BasePage  {

        public LogoutPage (WebDriver driver) {
            setDriver(driver);
            PageFactory.initElements(
                    new AjaxElementLocatorFactory(driver, 10), this);
        }

    @FindBy(xpath = "//a[text()=' Logout ']")
    WebElement btnLogout;

    public boolean isElementLogOutPresent(){
        return btnLogout.isDisplayed();
    }

}
