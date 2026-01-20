package myproject.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchSortProduct {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            driver.get("https://www.amazon.ca/");
            driver.manage().window().maximize();
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
            searchBox.sendKeys("iPhone");

            WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
            searchButton.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.s-pagination-item.s-pagination-selected")));

            WebElement sortDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("s-result-sort-select")));

            Select selectSortType = new Select(sortDropdown);

            selectSortType.selectByVisibleText("Price: High to low");

            System.out.println("Step 3: Selected 'Price: High to low' sorting");
            Thread.sleep(2000);

            List<WebElement> priceList = driver.findElements(By.cssSelector("span.a-price-whole"));
            ArrayList<Double> prices = new ArrayList<>();

            for(int i = 0; i < priceList.size(); i++){
              String priceText = priceList.get(i).getText().replace(",","");
              if(!priceText.isEmpty()){
                  try{
                      double price = Double.parseDouble(priceText);
                      prices.add(price);
                      System.out.println("Item" + (i +1) + ", Price: " + price);
                  }
                  catch(NumberFormatException e){
                      System.out.println("Item" + (i+1) + ", Price: " + priceText);
                  }
              }
            }
            System.out.println("Step 4: Started validation sorting");
            //Validate sorting
            boolean isSorted = true;
            for(int i = 0; i < prices.size() - 1; i++){
                if(prices.get(i) < prices.get(i+1)){
                    isSorted = false;
                    System.out.println("Step 4: Sorting validation FAILED  Price at index " + i +
                            " ($" + prices.get(i) + ") is less than price at index " +
                                    (i + 1) + " ($" + prices.get(i + 1) + ")");
                    break;
                }
            }
            if(isSorted){
                System.out.println("Step 4: Sorting validation PASSED - Prices are sorted from high to low");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            driver.quit();
        }
    }
}
