package tests;


import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPasswordEmail;
import pages.LogoutPage;


public class LoginPasswordEmailTests extends ApplicationManager {


        @Test
        public void loginPasEmailTestPositive() {
            LoginPasswordEmail loginPasswordEmail = new HomePage(getDriver())
                    .clickLoginPasswordEmail();

            loginPasswordEmail.typeEmail("oly112@gmail.com");
            loginPasswordEmail.typePassword("Oly1234$");
            LogoutPage res = loginPasswordEmail.clickbtnYalla();
            Assert.assertTrue(res.isElementLogOutPresent(), "Not success");


        }
    }
