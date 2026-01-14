package myproject.Tests;

import myproject.Engine.DriverManager;
import myproject.Listeners.LoggerListener;
import myproject.PageObjects.WebFormPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(LoggerListener.class)
public class WebFormTest extends BaseTest {

    @Test
    public void verifyWebFormSubmission() {

        SoftAssert softAssert = new SoftAssert();
        WebFormPage webFormPage = new WebFormPage();

        DriverManager.getDriver().get("https://www.selenium.dev/selenium/web/web-form.html");
        //Select dropdown
        webFormPage.selectDropdownValue("Two");
        //Enter Text
        webFormPage.enterText("PageFactory Example");
        // Submit form
        webFormPage.submitForm();

        softAssert.assertEquals(webFormPage.getConfirmationMessage(),
                "Received!", "Submit Failed");

        /*Assert.assertEquals(
                webFormPage.getConfirmationMessage(),
                "Received!"
        );*/
        softAssert.assertTrue(true);
        softAssert.assertAll();
    }
}
