package tests;

import dataProvider.DPLetTheCarWork;
import dataProvider.DPLetTheCarWorkNegative;
import dto.LetTheCarDtoLombok;
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

import java.lang.reflect.Method;

import static pages.BasePage.clickButtonsOnHeader;
import static utils.RandomUtils.*;

public class LetTheCarWorkTests extends ApplicationManager {

    UserDto user = new UserDto("Oly", "Gran", "oly112@gmail.com", "Oly1234$");
    LetTheCarWorkPage letTheCarWorkPage;

    @BeforeMethod
    public void login() {
        logger.info("start method --> startAddCar" + " user: oly112@gmail.com");
        new HomePage(getDriver());
        LoginPage loginPage = clickButtonsOnHeader(HeaderMenuItem.LOGIN);
        loginPage.typeLoginForm(user).clickBtnYalla();
        letTheCarWorkPage = clickButtonsOnHeader(HeaderMenuItem.LET_THE_CAR_WORK);
    }

    @Test
    public void addNewCarPositiveTest(Method method) {
        LetTheCarDtoLombok car = LetTheCarDtoLombok.builder()
                .city("Tel ")
                .manufacture("Toyota")
                .model("Prius.jpg")
                .year("2019")
                .fuel(FuelType.PETROL.getValue())
                .seats(5)
                .carClass("C-class")
                .serialNumber(generateNumber(12))
                .price(1000)
                .about(generateString(20))
                .carPhotoPath("Prius.jpg")
                .build();
        logger.info("start --> " + method.getName() + "with data: " + car.toString());
        Assert.assertTrue(letTheCarWorkPage.fillCarCityForm(car)
                .fillCarContinueForm(car)
                .loadCarPhoto(car)
                .clickBtnSubmitCarPositive()
                .isTextInElementPresentSuccessful())
        ;
        letTheCarWorkPage.clickShowCar();


    }
//***********************************************************************************
//***********************************************************************************

    @Test(dataProvider = "addNewCarDP", dataProviderClass = DPLetTheCarWork.class)
    public void addNewCarPositiveTestDP(LetTheCarDtoLombok car) {
        System.out.println("--> " + car);
        Assert.assertTrue(letTheCarWorkPage.fillCarCityForm(car)
                .fillCarContinueForm(car)
                .loadCarPhoto(car)
                .clickBtnSubmitCarPositive()
                .isTextInElementPresentSuccessful())
        ;
    }

    @Test(dataProvider = "addNewCarDPFile", dataProviderClass = DPLetTheCarWork.class)
    public void addNewCarPositiveTestDPFile(LetTheCarDtoLombok car) {
        System.out.println("--> " + car);
        Assert.assertTrue(letTheCarWorkPage.fillCarCityForm(car)
                .fillCarContinueForm(car)
                .loadCarPhoto(car)
                .clickBtnSubmitCarPositive()
                .isTextInElementPresentSuccessful())
        ;
    }

    @Test(dataProvider = "addNewCarDPNegative", dataProviderClass = DPLetTheCarWorkNegative.class)
    public void addNewCarNegativeTestDP(LetTheCarDtoLombok car) {
        System.out.println("--> " + car);
        Assert.assertTrue(letTheCarWorkPage.fillCarCityForm(car)
                .fillCarContinueForm(car)
                .loadCarPhoto(car)
                .clickBtnSubmitCarPositive()
                .isTextInElementPresentNegative())
        ;
    }

}

