package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static tests.BaseTest.cfg;

public class HomePage {

    private final By MAIN_MENU_SHOP = By.cssSelector("[data-alias='smartfoni-i-gadzheti']");
    private final By MENU_SMARTPHONE = By.cssSelector("div[class='header__submenu-inner'] a[data-label='Интернет-магазин|Смартфоны'] span");
    private final By PROMO_WRAPPER = By.cssSelector("[class='promo-cover__wrapper'] a[style*='opacity']");
    private final By ACTIVE_BANNER = By.cssSelector("[class='promo-cover__item js__promo-content-item slick-slide promo-cover__item_dark slick-current slick-active']");
    private final By SPINNER = By.cssSelector("circle");

    @Step("Открыть домашнюю страницу")
    public HomePage openPage() {
        open(cfg.baseUrl());
        return this;
    }

    public HomePage goToSmartPhone() {
        $(MAIN_MENU_SHOP).shouldBe(visible).hover();
        $(MENU_SMARTPHONE).shouldBe(visible).click();
        return this;
    }

    @Step("Проверить, что баннеры сменяют друг друга")
    public HomePage carouselCheck() {
        int bannerCount = $$(PROMO_WRAPPER).shouldBe(sizeGreaterThan(0)).size();
        String hrefActiveBanner = $(ACTIVE_BANNER).shouldBe(exist, Duration.ofSeconds(15)).getAttribute("href");
        for (int i = 0; i < bannerCount; i++) {
            $(SPINNER).shouldBe(visible).shouldBe(attribute("style", "stroke-dashoffset: 180;"), Duration.ofSeconds(10));
            hrefActiveBanner = $(ACTIVE_BANNER).shouldBe(exist, Duration.ofSeconds(15)).shouldNotBe(attribute("href", hrefActiveBanner)).getAttribute("href");
        }
        return this;
    }
}
