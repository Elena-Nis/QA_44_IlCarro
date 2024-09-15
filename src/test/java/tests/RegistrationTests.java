package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.RegistrationPage;

import java.util.Random;


public class RegistrationTests extends ApplicationManager {

   @Test
   public void registrationTestPositive() {
       int i = new Random().nextInt(1000);
       String email = "may" + i + "@gmail.com";
      Assert.assertTrue (new HomePage(getDriver())
               .clickSignUpLink()
               .typeName("May1111")
               .typeLastName("Ivanova1111")
               .typeEmail(email)
               .typePassword("May11112234$")
               .clickCheckBox()
               .clickbtnYalla()
               .isElementLogOutPresent());
   }
}
