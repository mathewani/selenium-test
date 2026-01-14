package myproject.Tests;
import myproject.Engine.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
public class BaseTest {

    protected WebDriver driver;

    @Parameters({"url"})
    @BeforeMethod
    public void setUp(@Optional String url) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        //driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_height_above_2000.html");
        //driver.get(url);
        //driver.get(ConfigReader.get("app.url"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            // driver.quit();
            DriverManager.getDriver().quit();
            DriverManager.quitDriver();
    }
}
