package pages;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    private final By NAME_INPUT = By.xpath("//input[@placeholder='Ваше имя'][@data-tilda-req='1']");
    private final By PHONE_INPUT = By.xpath("//input[@class='t-input t-input-phonemask'][@style]");
    private final By REGION_INPUT = By.xpath("//input[@name='Карта региона или страны. Мы добавим её в логотип']");
    private final By ADDRESS_INPUT = By.xpath("//textarea[@name='Адрес для доставки'] ");
    private final By TOWN_INPUT = By.cssSelector(".searchbox-input.js-tilda-rule.t-input");
    private final By ADDRESSEE_INPUT = By.xpath("//input[@data-service-id='1444328482'][@data-tilda-rule='name']");
    private final By STREET_INPUT = By.xpath("//input[@name='tildadelivery-street']");
    private final By HOUSE_INPUT = By.xpath("//input[@name='tildadelivery-house']");
    private final By OFFICE_INPUT = By.xpath("//input[@name='tildadelivery-aptoffice']");
    private final By FINISH_BUTTON = By.xpath("//button[text()='ОФОРМИТЬ ЗАКАЗ']");
    private final By PHONE_MASSAGE = By.xpath("//p[@class='t-form__errorbox-item js-rule-error js-rule-error-phone'][@style]");

    public BasketPage setNameField() {
        $(NAME_INPUT).shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys("Тестов Тест Тестович");
        return this;
    }

    public BasketPage setPhoneField() {
        $(PHONE_INPUT).shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys("0000000000");
        return this;
    }

    public BasketPage setRegionField() {
        $(REGION_INPUT).shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys("Камчатский край");
        return this;
    }

    public BasketPage setAddressField() {
        $(ADDRESS_INPUT).shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys("Беринга 1");
        return this;
    }

    public BasketPage setTownField() throws InterruptedException {
        $(TOWN_INPUT).shouldBe(Condition.visible, Duration.ofSeconds(5))
                .sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE + "Петропавловск-Камчатский");
        Thread.sleep(500);
        $(TOWN_INPUT).sendKeys(Keys.TAB);
        return this;
    }

    public BasketPage setAddresseeField() {
        $(ADDRESSEE_INPUT).shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys("Тестов Тест Тестович");
        return this;
    }

    public BasketPage setStreetField() {
        $(STREET_INPUT).shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys("ул Беринга" + Keys.TAB);
        return this;
    }

    public BasketPage setHouseField() {
        $(HOUSE_INPUT).shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys("д. 1" + Keys.TAB);
        return this;
    }

    public BasketPage setOfficeField() {
        $(OFFICE_INPUT).shouldBe(Condition.visible, Duration.ofSeconds(5)).sendKeys("1");
        return this;
    }

    public BasketPage finishButtonClick() {
        $(FINISH_BUTTON).shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        return this;
    }

    public BasketPage CheckMassage(String extendingMassage) {
        $(PHONE_MASSAGE).shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(Condition.text(extendingMassage));
        return this;
    }
}
