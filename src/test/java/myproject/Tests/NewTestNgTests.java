package myproject.Tests;

import myproject.Listeners.LoggerListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

import static myproject.PageObjects.WebForm.*;

@Listeners(LoggerListener.class)
public class NewTestNgTests {

    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
    @Test
    public void newTestNgTest() {

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.getTitle();
        System.out.println("Title is: " + driver.getTitle());
        getTextBox(driver).sendKeys("Google");
        getSubmitButton(driver).click();
        System.out.println("Title is: " + driver.getTitle() + " " + getMessage(driver).getText());

    }
}
