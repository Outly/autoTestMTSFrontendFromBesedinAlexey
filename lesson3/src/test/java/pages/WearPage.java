package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static tests.BaseTest.cfg;

public class WearPage {

    private final SelenideElement BUTTON_SORTING = $(".t-store__sort-select");
    private final List<SelenideElement> PRODUCTS_PRICE_TEXT = $$("div[data-product-price-def]");
    private final List<SelenideElement> PRODUCT_LIST_BY_NAME = $$(".js-store-prod-name");
    Logger logger = Logger.getLogger(getClass().getName());

    public WearPage openPage() {
        open(cfg.baseUrl() + "/wear");
        return this;
    }

    public void openProductCard(String productName) {
        $$(PRODUCT_LIST_BY_NAME).shouldBe(sizeGreaterThan(0)).find(text(productName)).click();
    }

    public WearPage selectSortingOrder(String value) {
        BUTTON_SORTING.click();
        // TODO Заменить String.format на методы Selenide
        BUTTON_SORTING.$(String.format("option[value='%s']", value)).click();
        return this;
    }

    public boolean checkPricesOrder() {
        // TODO Issue Element is not attached to the page document
        sleep(2000);
        $$(PRODUCTS_PRICE_TEXT).shouldBe(sizeGreaterThan(0));
        List<Integer> actualPricesOrder = PRODUCTS_PRICE_TEXT.stream()
                .map(e -> e.getAttribute("data-product-price-def")).filter(Objects::nonNull)
                .map(Integer::parseInt).toList();
        logger.log(Level.INFO, PRODUCTS_PRICE_TEXT.toString());
        List<Integer> expectedPricesOrder = actualPricesOrder.stream().sorted().toList();
        return expectedPricesOrder.equals(actualPricesOrder);
    }
}