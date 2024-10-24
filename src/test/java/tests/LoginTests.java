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
