package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.OrderPage;
import pages.ProductPage;
import pages.WearPage;

public class SendOrderTest extends BaseTest {
    private final String PRODUCT_NAME = "Футболка поло черная (м)";
    private final String TEST_NAME = "Тестов Тест Тестович";
    private final String TEST_PHONE = "0000000000";
    private final String TEST_TEXT = "Тест";
    private final String ERROR_PHONE_TEXT = "Укажите, пожалуйста, корректный номер телефона";

    @Test
    public void orderWithPhoneError() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .openCatalogWear();

        WearPage wearPage = new WearPage();
        wearPage.openPage().openProductCard(PRODUCT_NAME);

        ProductPage productPage = new ProductPage();
        productPage.addToCart();

        OrderPage orderPage = new OrderPage();
        orderPage.enterData(orderPage.FIELD_NAME, TEST_NAME)
                .enterData(orderPage.FIELD_PHONE, TEST_PHONE)
                .enterData(orderPage.FIELD_REGION, TEST_TEXT)
                .enterData(orderPage.FIELD_ADDRESS, TEST_TEXT)
                .enterData(orderPage.FIELD_DELIVERY_USER, TEST_NAME)
                .enterData(orderPage.FIELD_DELIVERY_STREET)
                .enterData(orderPage.FIELD_DELIVERY_HOUSE)
                .enterData(orderPage.FIELD_DELIVERY_APTOFFICE, String.format("%f", 10 * Math.random() + 1))
                .submitOrder();

        Assert.assertTrue(orderPage.checkErrorIsDisplayed(ERROR_PHONE_TEXT));
    }
}
