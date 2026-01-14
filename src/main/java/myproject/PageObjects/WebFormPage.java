package myproject.PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebFormPage extends BasePage {

    public WebFormPage() {
        super();
    }

    @FindBy(xpath = "//input[@name='my-text']")
    private WebElement textBox;

    @FindBy(xpath = "//button[contains(@class, 'btn')]")
    private WebElement submitButton;

    @FindBy(id = "message")
    private WebElement message;

    @FindBy(name = "my-select")
    private WebElement dropdown;

    // Page Actions
    public void enterText(String text) {
        type(textBox, text);
    }

    public void submitForm() {
        click(submitButton);
    }

    public String getConfirmationMessage() {
        return getText(message);
    }

    public void selectDropdownValue(String value) {
        Select select = getSelectValue(dropdown, value);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }
}