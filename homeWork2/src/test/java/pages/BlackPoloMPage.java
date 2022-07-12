package pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;

public class BlackPoloMPage {

    private final SelenideElement ADD_TO_BASKET_BUTTON = $(".js-store-prod-popup-buy-btn-txt");

    public BlackPoloMPage addToBasketClick() {
        ADD_TO_BASKET_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        return this;
    }
}
