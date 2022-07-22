package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MapPage {

    private final By STARS_CHECK_BOX = By.cssSelector("label[class='efeda70352'] span[class='bbdb949247']");
    private final By FILTERS_GROUP_CLASS = By.cssSelector("div[class='map_left_filters'] div[data-filters-group='class'] div[data-filters-item]");
    private final By LEFT_FILTERS_CONTAINER = By.cssSelector(".map_left_filters__container");
    private final By RATING_STARS_BOX = By.cssSelector(".bui-rating.bui-rating--smaller");

    public MapPage sendStatsFilter(int starsCount) {
        $(LEFT_FILTERS_CONTAINER).shouldBe(visible).hover();
        $$(FILTERS_GROUP_CLASS).shouldHave(sizeGreaterThan(0))
                .filterBy(attribute("data-filters-item", String.format("class:class=%s", "" + starsCount)))
                .first().$(STARS_CHECK_BOX).scrollIntoView(true).click();
        sleep(4000);
        return this;
    }

    public MapPage checkStarsCount(int starsCount) {
        $$(RATING_STARS_BOX).shouldBe(sizeGreaterThan(0)).stream()
                .forEach(x -> x.$$("span").shouldBe(size(starsCount)));
        return this;
    }
}
