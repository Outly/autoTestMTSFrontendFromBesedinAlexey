package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    private final By HOTEL_NAME = By.cssSelector(".pp-header__title");

    public ProductPage checkHotelName(String hotelName) {
        $(HOTEL_NAME).shouldBe(visible).shouldBe(text(hotelName));
        return this;
    }
}
