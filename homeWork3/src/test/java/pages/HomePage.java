package pages;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.BaseTest.cfg;

public class HomePage {

    private final By DESTINATION_INPUT = By.cssSelector(".c-autocomplete__input.sb-searchbox__input.sb-destination__input");
    private final By DATES_INPUT = By.cssSelector(".sb-date-field__icon.sb-date-field__icon-btn.bk-svg-wrapper.calendar-restructure-sb");
    private final By GUESTS_TOGGLE = By.cssSelector("#xp__guests__toggle");
    private final By ADULTS_DESC = By.xpath("//button[@data-bui-ref='input-stepper-subtract-button'][@aria-describedby='group_adults_desc']");
    private final By ADULTS_ADD = By.xpath("//button[@data-bui-ref='input-stepper-add-button'][@aria-describedby='group_adults_desc']");
    private final By CHILD_ADD = By.xpath("//button[@data-bui-ref='input-stepper-add-button'][@aria-describedby='group_children_desc']");
    private final By ROOM_ADD = By.xpath("//button[@data-bui-ref='input-stepper-add-button'][@aria-describedby='no_rooms_desc']");
    private final By SEARCH_BOX_BUTTON = By.cssSelector(".sb-searchbox__button ");


    public HomePage openPage() {
        open(cfg.baseUrl());
        return this;
    }

    public HomePage sendDestination(String destinationTown) {
        $(DESTINATION_INPUT).shouldBe(visible).sendKeys(destinationTown);
        return this;
    }

    public HomePage sendCheckInCheckOutDates(String checkIn, String checkOut) {
        $(DATES_INPUT).shouldBe(visible).click();
        $( String.format("td[data-date='%s']", checkIn)).click();
        $( String.format("td[data-date='%s']", checkOut)).click();
        return this;
    }

    public HomePage sendGuestsAndRooms(int adultCount, int childCount, int roomCount) {
        $(GUESTS_TOGGLE).shouldBe(visible).click();
        $(ADULTS_DESC).click();
        for (int i = 1; i < adultCount; i++) {
            $(ADULTS_ADD).click();
        };
        for (int i = 0; i < childCount; i++) {
            $(CHILD_ADD).click();
        };
        for (int i = 1; i < roomCount; i++) {
            $(ROOM_ADD).click();
        };
        return this;
    }

    public HomePage searchBoxButtonClick() {
        $(SEARCH_BOX_BUTTON).click();
        return this;
    }

}
