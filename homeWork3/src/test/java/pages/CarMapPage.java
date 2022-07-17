package pages;
import com.codeborne.selenide.CollectionCondition;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import static com.codeborne.selenide.Selenide.$$;

public class CarMapPage {

    private final By PRICES = By.cssSelector(".result__price-total");

    public CarMapPage checkSortingPrices() {

        List<Double> actualPrices = $$(PRICES).shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(15))
                .stream().map(x -> Double.parseDouble(x.getText().split(" ")[1]))
                .collect(Collectors.toList());
        List<Double> expectedPrices = actualPrices.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(expectedPrices, actualPrices);
        return this;
    }
}
