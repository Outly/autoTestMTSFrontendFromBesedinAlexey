package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static tests.BaseTest.cfg;

public class HomePage {

    private final SelenideElement BUTTON_CATALOG = $("[data-elem-id='1628140756306'] [href='/wear']");
    private final SelenideElement CATALOG_WEAR = $("[data-elem-id='1627449302046'] [href='/wear']");

    public HomePage openPage() {
        open(cfg.baseUrl());
        return this;
    }

    public void openCatalogWear() {
        // TODO Unstable issue Unable to locate element
        sleep(3000);
        CATALOG_WEAR.shouldBe(Condition.appear).click();
    }
}
