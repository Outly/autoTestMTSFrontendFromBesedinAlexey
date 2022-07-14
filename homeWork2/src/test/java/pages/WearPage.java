package pages;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;
import static tests.BaseTest.cfg;

public class WearPage {

    //private final By GO_TO_BLACK_POLO_M = By.xpath("//div[text()='Футболка поло черная (м)']");

    public WearPage openPage() {
        open(cfg.baseUrl() + "/wear");
        return this;
    }
    public WearPage goToProduct(String productName) {
        $(By.xpath("//div[text()='" + productName + "']")).shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        return this;
    }

}
