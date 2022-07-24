package pages;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MapPage {

    private final By STARS_CHECK_BOX = By.cssSelector("label[class='efeda70352'] span[class='bbdb949247']");
    private final By FILTERS_GROUP_CLASS = By.cssSelector("div[class='map_left_filters'] div[data-filters-group='class'] div[data-filters-item]");
    private final By LEFT_FILTERS_CONTAINER = By.cssSelector(".map_left_filters__container");
    private final By RATING_STARS_BOX = By.cssSelector(".bui-rating.bui-rating--smaller");
    private final By MAP_LEFT_CARD_CONTAINER = By.cssSelector(".map_left_cards__container a");
    private final By MARKER_HOTELS = By.cssSelector(".svg-marker.svg-poi.atlas-marker.hotel.fading:not([class*='soldout'])");
    private final By LOADING_MASSAGE = By.cssSelector(".map_left_cards__loading-spinner");
    private final By MAP_SIZE_DECREMENT = By.cssSelector(".map_atlas_custom_zoom_decrement.notranslate");

    public MapPage sendStatsFilter(int starsCount) {
        $(LEFT_FILTERS_CONTAINER).shouldBe(visible).hover();
        $$(FILTERS_GROUP_CLASS).shouldHave(sizeGreaterThan(0))
                .filterBy(attribute("data-filters-item", String.format("class:class=%s", "" + starsCount)))
                .first().$(STARS_CHECK_BOX).scrollIntoView(true).click();
        return this;
    }

    public MapPage checkStarsCount(int starsCount) {
        $$(RATING_STARS_BOX).shouldBe(sizeGreaterThan(0)).stream()
                .forEach(x -> x.$$("span").shouldBe(size(starsCount)));
        return this;
    }

    public MapPage loadingMassageWait() {
        $(LOADING_MASSAGE).shouldBe(visible).shouldBe(not(visible), Duration.ofSeconds(15));
        return this;
    }

    public MapPage checkLeftCardsContainersCountAndMarkerCount() {
        int containerCardCount = $$(MAP_LEFT_CARD_CONTAINER).shouldBe(sizeGreaterThan(0)).size();
        $$(MARKER_HOTELS).shouldBe(sizeGreaterThan(0))
                .shouldBe(size(containerCardCount));
        return this;
    }

    public MapPage mapSizeDecrement() {
        $(MAP_SIZE_DECREMENT).shouldBe(visible).click();
        return this;
    }
}
