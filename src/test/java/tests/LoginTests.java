package tests;

import dto.UserDto;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.HeaderMenuItem;
import utils.PropertiesReader;
import utils.RetryAnalyzer;
import utils.TestNGListener;

import static utils.RandomUtils.*;
import static pages.BasePage.clickButtonsOnHeader;

@Listeners(TestNGListener.class)

public class LoginTests extends ApplicationManager {

    @Description("loginPositiveMethod")
    @Owner("QA Elena")
    @Test
    public void loginPositiveTest() {
        Allure.step("fill loginForm");
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnLogin()
                .typeLoginForm("alexmed123@gmail.com", "Qwerty123!")
                .clickBtnYalla()
                .isTextInElementPresent_LoginSuccess())
        ;
    }

    @Description("loginPositiveMethodProperties")
    @Owner("Elena Nisnevich")
    @Test
    public void loginPositiveTestProperties () {
        Allure.step("Fill loginForm from file.properties");
        String email = PropertiesReader.getProperty("data.properties", "email");
        String password = PropertiesReader.getProperty("data.properties", "password");
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnLogin()
                .typeLoginForm(email, password)
                .clickBtnYalla()
                .isTextInElementPresent_LoginSuccess())
        ;
    }

    @Description("loginTestRetryAnalyzer")
    @Owner("Elena Nisnevich")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginTestRetryAnalyzer () {
        Allure.step("Login Test with RetryAnalyzer");
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnLogin()
                .typeLoginForm("alexmed123gmail.com", "Qwerty123!")
                .clickBtnYalla()
                .isTextInElementPresent_LoginSuccess())
        ;
    }


    @Test
    public void loginNegativeTest_wrongEmailWOAt() {
        UserDto user = new UserDto(generateString(5), generateString(7),
                generateString(10), "Qwerty123!");
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnLogin()
                .typeLoginForm(user)
                .clickBtnYalla()
                .isTextInElementPresent_ErrorEmail("It'snot look like email"))
        ;
    }
    @Test
    public void loginNegativeTest_wrongEmailWOAt_Enum() {
        UserDto user = new UserDto(generateString(5), generateString(7),
                generateString(10), "Qwerty123!");
        new HomePage(getDriver());
        LoginPage loginPage = clickButtonsOnHeader(HeaderMenuItem.LOGIN);
        loginPage.typeLoginForm(user)
                .clickBtnYalla()
                .isTextInElementPresent_ErrorEmail("It'snot look like email")
        ;
    }

    @Test
    public void loginNegativeTest_wrongPasswordEmpty_Enum() {
        UserDto user = new UserDto(generateString(5), generateString(7),
                generateEmail(10), "");
        new HomePage(getDriver());
        LoginPage loginPage = clickButtonsOnHeader(HeaderMenuItem.LOGIN);
        loginPage.typeLoginForm(user)
                .clickBtnYalla()
                .isTextInElementPresent_ErrorPasswordEmpty("Password is required")
        ;
    }
}
