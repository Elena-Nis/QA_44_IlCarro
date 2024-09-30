package manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class ApplicationManager {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    @BeforeMethod
    public void setUp(Method method) {
        logger.info("Start method --> setup");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().window().setSize(new Dimension(1204, 768));
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Start method --> tearDown");
//        if(driver != null){
//            driver.quit();
//        }
    }
}
