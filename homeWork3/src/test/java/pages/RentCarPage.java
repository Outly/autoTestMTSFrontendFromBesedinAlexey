package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RentCarPage {

    private final By DESTINATION_INPUT = By.cssSelector(".sb-destination-label-sr input");
    private final By DESTINATION_TOWN = By.cssSelector("li[data-i='0'] span[class=sb-autocomplete--photo]");
    private final By SEARCH_BOX_BUTTON = By.cssSelector(".sb-searchbox__button ");

    public RentCarPage sendDestination(String destinationTown) {
        $(DESTINATION_INPUT).shouldBe(visible).sendKeys(destinationTown);
        $(DESTINATION_TOWN).shouldBe(visible).click();
        return this;
    }

    public RentCarPage searchBoxButton() {
        $(SEARCH_BOX_BUTTON).shouldBe(visible).click();
        return this;
    }

}
