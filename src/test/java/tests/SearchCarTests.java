package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SearchCarTests extends ApplicationManager {

    HomePage homePage;

    @Description("positive methode search car")
    @Owner("QA ALex")
    @Test
    public void searchCarPositiveTest(){
        Allure.step("fill search car form");
        homePage = new HomePage(getDriver());
        homePage.fillSearchCarFormCalendar("Haifa", "22 May 2025", "10 Dec 2024");
        Assert.assertTrue(homePage.validateUrlContainsResults());
    }

    @Description("Positive methode search car without using calendar")
    @Owner("Elena Nisnevich")
    @Test
    public void searchCarPositiveTestWithoutCalendar(){
        Allure.step("Fill search car form");
        homePage = new HomePage(getDriver());
        homePage.fillSearchCarFormWithoutCalendar("Tel Aviv", "10 Nov 2024", "17 Dec 2024");
        Assert.assertTrue(homePage.validateUrlContainsResults());
    }

    @Description("negative methode search car")
    @Owner("QA not Alex")
    @Test(expectedExceptions = {org.openqa.selenium.NoSuchElementException.class, IndexOutOfBoundsException.class})
    public void searchCarNegativeTest_wrongDate(){
        Allure.step("fill search car form");
        homePage = new HomePage(getDriver());
        Allure.step("create home page");
        homePage.fillSearchCarFormCalendar("Haifa", "22 May 2023", "10 Dec 2024");
    }
}