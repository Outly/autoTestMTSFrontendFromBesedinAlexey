package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    private final By DESTINATION_TOWN = By.cssSelector("[name='ss']");
    private final By DATE_DISPLAY = By.cssSelector("[data-testid=date-display-field-start]");
    private final By NIGHTS_DISPLAY = By.cssSelector("[data-testid='price-for-x-nights']");
    private final By OCCUPANCY_CONFIG = By.cssSelector("[data-testid='occupancy-config']");
    private final By SEARCH_RESULT = By.cssSelector(".e1f827110f.d3a14d00da");

    public SearchResultPage checkDestinationTown(String destinationTown) {
        $(DESTINATION_TOWN).shouldBe(visible).getAttribute("value").equals(destinationTown);
        return this;
    }

    public SearchResultPage dateDisplayClick() {
        $(DATE_DISPLAY).click();
        return this;
    }

    public SearchResultPage dateCheck(String checkIn) {
        $(String.format("[data-date='%s']", checkIn))
                .shouldBe(attribute("aria-checked", "true"));
        return this;
    }

    public SearchResultPage checkNightsCount(int nightsCount) {
        $(NIGHTS_DISPLAY).shouldBe(visible).getText().contains(nightsCount + " ночей");
        return this;
    }

    public SearchResultPage checkAdultsChildrenRoomCount(int adults, int children, int rooms) {
        $(OCCUPANCY_CONFIG).shouldBe(visible).getText().equals(String.format("%s взрослый · %s детей · %s номер", adults, children, rooms));
        return this;
    }

    public SearchResultPage checkHotelCount() {
        int hotelCount = Integer.parseInt($(SEARCH_RESULT).shouldBe(visible).getText().split(" ")[2]);
        Assert.assertTrue(hotelCount > 0);
        return this;
    }
}
