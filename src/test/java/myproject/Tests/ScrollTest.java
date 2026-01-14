package myproject.Tests;

import myproject.PageObjects.ScrollPage;
import org.testng.annotations.Test;


public class ScrollTest extends BaseTest{


    @Test
    public void scrollTest() throws InterruptedException {
        ScrollPage scrollPage = new ScrollPage(driver);
        scrollPage.scrollCheckbox();
    }

}
