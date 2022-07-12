package pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static tests.BaseTest.cfg;

public class WearPage {

    private final SelenideElement GO_TO_BLACK_POLO_M = $x("//div[text()='Футболка поло черная (м)']");

    public WearPage openPage() {
        open(cfg.baseUrl() + "/wear");
        return this;
    }
    public WearPage goToBlackPoloMClick() {
        GO_TO_BLACK_POLO_M.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        return this;
    }

}
