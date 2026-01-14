package myproject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebForm {

    public static String textBox = "//input[@name='my-text']";
    public static String submitButton = "//button[contains(@class, 'btn')]";
    public static String message = "message";

    public static WebElement getTextBox(WebDriver driver) {
        return driver.findElement(By.xpath(textBox));
    }

    public static WebElement getSubmitButton(WebDriver driver) {
        return driver.findElement(By.xpath(submitButton));
    }

    public static WebElement getMessage(WebDriver driver) {
        return driver.findElement(By.id(message));
    }
}
