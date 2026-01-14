package myproject.Tests;

import myproject.Engine.DriverManager;
import myproject.PageObjects.SearchFlight;
import org.testng.annotations.Test;

public class SearchFlightTests extends BaseTest {
    @Test
    public void searchFlightTests() {

        try {
            SearchFlight searchFlight = new SearchFlight();
            DriverManager.getDriver().get("https://www.emirates.com/ca/english/");
            searchFlight.clickOnOneTrustCookieButton();

            searchFlight.selectDepartureAirport("Toronto (YYZ)");
            searchFlight.selectDepOption();
            searchFlight.selectArrivalAirport("Kochi (Cochin) (COK)");
            searchFlight.selectArrOption();
            searchFlight.clickDateInput();
            //searchFlight.selectDatePickerDropdown("2026/01/18");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
