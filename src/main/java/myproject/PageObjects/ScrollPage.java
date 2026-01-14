package myproject.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScrollPage extends BasePage{
    public ScrollPage(WebDriver driver) {
        super();
    }
    @FindBy(xpath = "//input[@name='checkbox']")
    private WebElement checkbox;

    public void scrollCheckbox() throws InterruptedException {
        //click(checkbox);
        scrollToBottom(checkbox);
    }
}
