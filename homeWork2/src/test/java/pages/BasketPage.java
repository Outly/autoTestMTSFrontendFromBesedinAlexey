package pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BasketPage {

    private final SelenideElement NAME_INPUT = $x("//input[@placeholder='Ваше имя'][@data-tilda-req='1']");
    private final SelenideElement PHONE_INPUT = $x("//input[@class='t-input t-input-phonemask'][@style]");
    private final SelenideElement REGION_INPUT = $x("//input[@name='Карта региона или страны. Мы добавим её в логотип']");
    private final SelenideElement ADDRESS_INPUT = $x("//textarea[@name='Адрес для доставки'] ");
    private final SelenideElement TOWN_INPUT = $(".searchbox-input.js-tilda-rule.t-input");
    private final SelenideElement ADDRESSEE_INPUT = $x("//input[@data-service-id='1444328482'][@data-tilda-rule='name']");
    private final SelenideElement STREET_INPUT = $x("//input[@name='tildadelivery-street']");
    private final SelenideElement HOUSE_INPUT = $x("//input[@name='tildadelivery-house']");
    private final SelenideElement OFFICE_INPUT = $x("//input[@name='tildadelivery-aptoffice']");
    private final SelenideElement FINISH_BUTTON = $x("//button[text()='ОФОРМИТЬ ЗАКАЗ']");
    private final SelenideElement PHONE_MASSAGE = $x("//p[@class='t-form__errorbox-item js-rule-error js-rule-error-phone'][@style]");


    public BasketPage fillingFields() {
        NAME_INPUT.shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys("Тестов Тест Тестович");
        PHONE_INPUT.shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys("0000000000");
        REGION_INPUT.shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys("Камчатский край");
        ADDRESS_INPUT.shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys("Беринга 1");
        TOWN_INPUT.shouldBe(Condition.visible, Duration.ofSeconds(5))
                .sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE + "Петропавловск-Камчатский");
        ADDRESSEE_INPUT.shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys("Тестов Тест Тестович");
        STREET_INPUT.shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys("ул Беринга" + Keys.TAB);
        HOUSE_INPUT.shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys("д. 1" + Keys.TAB);
        OFFICE_INPUT.shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys("1");
        return this;
    }

    public BasketPage PressFinishAndCheckMassage(String extendingMassage) {
        FINISH_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        PHONE_MASSAGE.shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(Condition.text(extendingMassage));

        return this;
    }
}
