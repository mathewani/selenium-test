package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumClassic {

    public static void main(String[] args) {

       // System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harvester\\IdeaProjects\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        driver.getTitle();
        System.out.println("Title is: " + driver.getTitle());
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));


        textBox.sendKeys("Google");
        submitButton.click();
        WebElement message = driver.findElement(By.id("message"));

        System.out.println("Title is: " + driver.getTitle() + " " + message.getText());

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.close();
        //driver.quit();

    }
}
