package myproject.Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static myproject.PageObjects.WebForm.*;


public class HomePageTests {

    WebDriver driver;

    @BeforeEach
    public void Setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void Teardown(){
        driver.quit();
    }
    @Test
    public void PageLoadTest(){
        driver.get("https://www.selenium.dev");
        Assertions.assertEquals("https://www.selenium.dev/", driver.getCurrentUrl());
    }

    @Test
    public void WebFormTest(){

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.getTitle();
        System.out.println("Title is: " + driver.getTitle());
        getTextBox(driver).sendKeys("Google");
        getSubmitButton(driver).click();
        System.out.println("Title is: " + driver.getTitle() + " " + getMessage(driver).getText());

    }
}
