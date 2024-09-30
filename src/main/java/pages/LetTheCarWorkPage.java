package pages;

import dto.LetTheCarDtoLombok;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.nio.file.Path;
import java.nio.file.Paths;


public class LetTheCarWorkPage extends BasePage {
    public LetTheCarWorkPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@id='pickUpPlace']")
    WebElement inputCity;
    @FindBy(xpath = "//div[@class='pac-item'][1]")
    WebElement inputCityInList;
    @FindBy(xpath = "//input[@id='make']")
    WebElement inputManufacture;
    @FindBy(xpath = "//input[@id='model']")
    WebElement inputModel;
    @FindBy(xpath = "//input[@id='year']")
    WebElement inputYear;
    @FindBy(xpath = "//select[@id='fuel']")
    WebElement inputFuel;
    @FindBy(xpath = "//input[@id='seats']")
    WebElement inputSeats;
    @FindBy(xpath = "//input[@id='class']")
    WebElement inputCarClass;
    @FindBy(xpath = "//input[@id='serialNumber']")
    WebElement inputCarRegNumber;
    @FindBy(xpath = "//input[@id='price']")
    WebElement inputPrice;
    @FindBy(xpath = "//textarea[@id='about']")
    WebElement inputAbout;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSubmitCarPositive;
    @FindBy(xpath = "//input[@type='file']")
    WebElement inputPathPhoto;
    @FindBy(xpath = "//h2[@class='message']")
    WebElement carAddedMessage;
    @FindBy(xpath = "//button[@type='button'][3]")
    WebElement showCar;
    @FindBy(xpath = "//button[@type='submit' and @disabled]")
    WebElement errorElement;

    public LetTheCarWorkPage fillCarCityForm(LetTheCarDtoLombok car) {
        if (car.getCity() == "") {
            inputCity.click();
            inputManufacture.click();
        } else {
            inputCity.sendKeys(car.getCity());
            inputCityInList.click();
        }
        return this;
    }


    public LetTheCarWorkPage fillCarContinueForm(LetTheCarDtoLombok car) {
        inputManufacture.sendKeys(car.getManufacture());
        inputModel.sendKeys(car.getModel());
        inputYear.sendKeys(car.getYear());
        inputFuel.sendKeys(car.getFuel());
        inputSeats.sendKeys(String.valueOf(car.getSeats()));
        inputCarClass.sendKeys(car.getCarClass());
        inputCarRegNumber.sendKeys(car.getSerialNumber());
        inputPrice.sendKeys(String.valueOf(car.getPrice()));
        inputAbout.sendKeys(car.getAbout());
        return this;

    }

    public LetTheCarWorkPage loadCarPhoto(LetTheCarDtoLombok car) {
        // inputPathPhoto.sendKeys("C:\\Users\\e4887\\Documents_Auto\\GitHub\\QA_44_IlCarro\\src\\main\\resources\\Prius.jpg");
        String fileName = car.getCarPhotoPath();
        Path relativePath = Paths.get("src/main/resources/" + fileName);
        String absolutePath = relativePath.toAbsolutePath().toString();
        inputPathPhoto.sendKeys(absolutePath);
        return this;
    }

    public LetTheCarWorkPage clickBtnSubmitCarPositive() {
        pause(5);
        btnSubmitCarPositive.click();
        return this;
    }

    public boolean isTextInElementPresentSuccessful() {
        return isTextInElementPresent(carAddedMessage, "Toyota Prius.jpg added successful")
                || isTextInElementPresent(carAddedMessage, "Toyota Prius added successful")
                || isTextInElementPresent(carAddedMessage, "Opel Astra added successful")
                || isTextInElementPresent(carAddedMessage, "Opel Astra.jpg added successful")
                ;
    }

    public CarAddPage clickShowCar() {
        pause(5);
        showCar.click();
        return new CarAddPage(driver);
    }

    public boolean isTextInElementPresentNegative() {
        boolean btnIsDisplayed = errorElement.isDisplayed();
        return btnIsDisplayed;

    }

}