package pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.BaseTest.cfg;

public class HomePage {

    private final SelenideElement GO_TO_WEAR = $("[data-elem-id='1627449302046'] .tn-atom[href='/wear']");

    public HomePage openPage() {
        open(cfg.baseUrl());
        return this;
    }

    public HomePage clickGoToWear() {
        GO_TO_WEAR.shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        return this;
    }
}
