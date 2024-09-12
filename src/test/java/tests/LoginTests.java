package tests;

import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends ApplicationManager {

   @Test
   public void loginTestPositive() {
      LoginPage loginPage = new HomePage(getDriver())
               .clickSignUpLink();
               loginPage.typeName("Oly");
               loginPage.typeLastName("Ivanova");
               loginPage.typeEmail("oly112@gmail.com");
               loginPage.typePassword("Oly1234$");
               loginPage.clickCheckBox();
               loginPage.clickbtnYalla();
   }
}
