package myproject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchFlight extends BasePage {
    public SearchFlight() {
        super();
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement oneTrustCookieButton;

    @FindBy(xpath = "//input[@name='Departure airport']")
    private WebElement departureAirport;

    @FindBy(xpath = "//section[@class='location global']")
    private WebElement depDropDown;

    @FindBy(xpath = "//input[@name='Arrival airport']")
    private WebElement arrivalAirport;

    @FindBy(xpath = "//input[@class = 'textfield__input textfield__input--start']")
    private WebElement dateInput;

    @FindBy(xpath = "//div[contains(@class, 'label-month')]")
    private WebElement datePickerMonth;

    public void clickOnOneTrustCookieButton()
    {
        click(oneTrustCookieButton);
    }
    public void selectDepartureAirport(String depAirport) {
        type(departureAirport, depAirport);
    }

    public void selectDepOption(){
        WebElement torontoOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//li[@data-dropdown-id='YYZ' and @data-dropdown-display='Toronto (YYZ)']")
                )
        );
        js.executeScript("arguments[0].scrollIntoView(true);", torontoOption);
        js.executeScript("arguments[0].click();", torontoOption);
    }


    public void selectArrOption() throws InterruptedException {
        // Select Kochi from dropdown
        WebElement kochiOption = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//li[@data-dropdown-id='COK' and contains(@data-dropdown-display, 'Kochi')]")
                )
        );
        js.executeScript("arguments[0].scrollIntoView(true);", kochiOption);
        Thread.sleep(500);
        js.executeScript("arguments[0].click();", kochiOption);
        }

    public void selectArrivalAirport(String arAirport) {
        type(arrivalAirport, arAirport);
    }

    public void clickDateInput(){
        click(dateInput);
    }
    public void selectDatePickerDropdown(String date) {

        while(true){
           // waitForVisibility(datePickerMonth);
            wait.until(ExpectedConditions.visibilityOf(datePickerMonth));
            if(datePickerMonth.getText().equalsIgnoreCase("January")){
                break;
            }

        }
        driver.findElement(By.xpath("//button[contains(text(),'Next month')]")).click();
        //driver.findElement(By.cssSelector(".eol-calendar--visible")).sendKeys(date);
    }
}
