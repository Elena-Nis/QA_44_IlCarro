package tests;


import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;


public class LoginTests extends ApplicationManager {


    @Test
    public void loginTestPositive() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnLogin()
                .typeEmail("oly112@gmail.com")
                .typePassword("Oly1234$")
                .clickbtnYalla()
                .isElementLogOutPresent());


    }

//    @Test
//    public void loginTestNegative() {
//        HomePage homePage = new HomePage(getDriver());
//        LoginPage loginPage = homePage.clickBtnLogin();
//                  loginPage.typeEmail("oly@gmail.com");
//                  loginPage.typePassword("");
//                  if(loginPage.isErrorMessageDisplayed()) {
//                  loginPage.typeEmail("oly@gmail.com");
//                  }
//                  loginPage.clickbtnYallaNegative();
//                  if(loginPage.isErrorMessageDisplayed()) {
//                  loginPage.typePassword("Oly1234$");
//                  loginPage.clickbtnYallaNegative();
//        }
//        Assert.assertTrue(loginPage.isTextInElementPresent_LogIncorrect());

    @Test
    public void loginEmailTestNegative() {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = homePage.clickBtnLogin();
        loginPage.typeEmail("");
        //"@", "@gmail", "oly@", "olygmail.com", "oly112@gmail.com""
        loginPage.typePassword("Oly1234$");
        if (loginPage.isErrorEmailMessageDisplayed()) {
            loginPage.typeEmail("oly@gmail.com");
        }
        loginPage.clickbtnYallaNegative();
        Assert.assertTrue(loginPage.isTextInElementPresent_LogIncorrect());
    }

    @Test
    public void loginPasswordTestNegative() {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = homePage.clickBtnLogin();
        loginPage.typeEmail("oly112@gmail.com");
        loginPage.typePassword("");
        //"", "Oly1234#", "123g"
        loginPage.clickbtnYallaNegative();
        if (loginPage.isErrorPasswordMessageDisplayed()) {
            loginPage.typePassword("Oly1234");
            loginPage.clickbtnYallaNegative();
        }
        Assert.assertTrue(loginPage.isTextInElementPresent_LogIncorrect());

    }
}

