package manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ApplicationManager {
    private WebDriver driver;
    public WebDriver getDriver(){
        return driver;
    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().window().setSize(new Dimension(1204, 768));
    }

    @AfterMethod
    public void tearDown(){
//        if(driver != null){
//            driver.quit();
//        }
    }
}
