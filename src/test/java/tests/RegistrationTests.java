package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;
import utils.HeaderMenuItem;

import java.util.Random;

import static pages.BasePage.clickButtonsOnHeader;
import static utils.RandomUtils.generateString;

public class RegistrationTests extends ApplicationManager {

    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000);
        String email = "frodo_baggins" + i + "@gmail.com";
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnRegistration()
                .typeRegistrationForm("Alex", "Med", email, "Qwerty123!")
                .clickCheckBox()
                .clickBtnYalla()
                .isTextInElementPresent_regSuccess())
        ;
    }

    @Test
    public void registrationNegativeTest_wrongEmailWOAt_Enum() {
        UserDto user = new UserDto(generateString(5), generateString(7),
                generateString(10), "Qwerty123!");
        new HomePage(getDriver());
        RegistrationPage registrationPage = clickButtonsOnHeader(HeaderMenuItem.SIGN_UP);
        registrationPage.typeRegistrationForm(user)
                .clickCheckBox()
                .clickBtnYalla()
                .isTextInElementPresent_ErrorEmail("Wrong email format")
        ;
    }
}
