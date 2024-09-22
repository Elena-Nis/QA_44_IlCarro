package tests;

import dto.LetCarDtoLombok;
import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetTheCarWorkPage;
import pages.LoginPage;
import utils.FuelType;
import utils.HeaderMenuItem;

import java.util.Random;

import static pages.BasePage.clickButtonsOnHeader;
import static utils.RandomUtils.*;

public class LetTheCarWorkTests extends ApplicationManager {

    UserDto user = new UserDto("Oly","Gran", "oly112@gmail.com", "Oly1234$");
    LetTheCarWorkPage letTheCarWorkPage;

        @BeforeMethod
        public void login() {
            new HomePage(getDriver());
            LoginPage loginPage = clickButtonsOnHeader(HeaderMenuItem.LOGIN);
            loginPage.typeLoginForm(user).clickBtnYalla();
            letTheCarWorkPage = clickButtonsOnHeader(HeaderMenuItem.LET_THE_CAR_WORK);
        }

        @Test
        public void addNewCarPositiveTest() {

        LetCarDtoLombok car = LetCarDtoLombok.builder()
        .city("Tel ")
        .manufacture("Toyota")
        .model("Prius.jpg")
        .year("2019")
        .fuel(FuelType.PETROL.getValue())
        .seats("5")
        .carClass("C-class")
        .carRegNumber(generateNumber(12))
        .price("1000")
        .about(generateString(20))
        .carPhotoPath("Prius.jpg")
        .build();

        Assert.assertTrue( letTheCarWorkPage.fillCarCityForm(car)
                          .fillCarContinueForm(car)
                          .loadCarPhoto(car)
                          .clickBtnSubmitCarPositive()
                          .isTextInElementPresentSuccessful())
                ;
                          letTheCarWorkPage.clickShowCar();


    }

}

