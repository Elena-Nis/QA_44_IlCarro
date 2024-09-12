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
      LoginPage loginPage = new HomePage(getDriver())
               .clickSignUpLink();
               loginPage.typeName("Oly1111");
               loginPage.typeLastName("Ivanova1111");
               loginPage.typeEmail("oly1111122@gmail.com");
               loginPage.typePassword("Oly11112234$");
               loginPage.clickCheckBox();
       LogoutPage res =  loginPage.clickbtnYalla();
       Assert.assertTrue(res.isElementLogOutPresent(), "Not success");

   }
}
