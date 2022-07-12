package pages;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.List;
import java.util.stream.Collectors;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static tests.BaseTest.cfg;

public class WearPage {

    private final SelenideElement SORT_BUTTON = $(".t-store__sort-select");
    private final List<SelenideElement> PRODUCTS_PRICE_TEXT = $$(".js-product-price[data-product-price-def]");

    public WearPage openPage() {
        open(cfg.baseUrl() + "/wear");
        return this;
    }

    public WearPage selectSortProduct(String value) {
        SORT_BUTTON.click();
        SORT_BUTTON.findAll(By.cssSelector("option")).filterBy(attribute("value", value)).first().click();
        return this;
    }

    public WearPage checkFirstPriceAndSorting(String expectedPrice) {
        PRODUCTS_PRICE_TEXT.get(0).shouldHave(text(expectedPrice));

        List<Integer> actualPrices = PRODUCTS_PRICE_TEXT.stream()
                .map(x -> Integer.parseInt(x.getAttribute("data-product-price-def-str")))
                .collect(Collectors.toList());

        List<Integer> expectedPrices = actualPrices.stream()
                .sorted()
                .collect(Collectors.toList());

        Assert.assertEquals(actualPrices, expectedPrices);

        //System.out.println(actualPrices);
        //System.out.println(expectedPrices);

        return this;
    }
}
