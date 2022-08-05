package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {

    private final By STARS_CHECK_BOX = By.cssSelector("label[class='efeda70352'] span[class='bbdb949247']");
    private final By FILTERS_GROUP_CLASS = By.cssSelector("div[data-filters-group='class'] div[data-filters-item]");
    private final By RATING_STARS_BOX = By.cssSelector(".fbb11b26f5");
    private final By MAP = By.cssSelector("[data-testid='map-trigger']");
    private final By LOADING_WINDOW = By.cssSelector("div[data-testid='overlay-message-title']");

    public SearchResultPage sendStatsFilter(int starsCount) {
        $$(FILTERS_GROUP_CLASS).shouldHave(sizeGreaterThan(0))
                .filterBy(attribute("data-filters-item", String.format("class:class=%s", "" + starsCount)))
                .first().$(STARS_CHECK_BOX).scrollTo().click();
        return this;
    }

    public SearchResultPage loadingWait() {
        $(LOADING_WINDOW).shouldBe(visible).shouldBe(not(visible));
        return this;
    }

    public SearchResultPage checkStarsCount(int starsCount) {
        $$(RATING_STARS_BOX).shouldBe(sizeGreaterThan(0)).stream()
                .forEach(x -> x.$$("span").shouldBe(size(starsCount)));
        return this;
    }

    public SearchResultPage mapClick() {
        $(MAP).shouldBe(visible).click();
        return this;
    }
}
