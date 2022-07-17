package tests;

import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.OrderPage;
import pages.ProductPage;
import pages.WearPage;

public class CancelOrderTest extends BaseTest {
    private final String PRODUCT_NAME = "Футболка оверсайз белая";
    private static ProductPage productPage;

    @Before
    public void preview() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .openCatalogWear();

        WearPage wearPage = new WearPage();
        wearPage.openProductCard(PRODUCT_NAME);

        productPage = new ProductPage();
        productPage.addToCart();
    }

    @Test
    public void cancelOrder() {
        OrderPage orderPage = new OrderPage();
        orderPage.cancelOrder()
                .checkTimerIsExist()
                .checkTimerTitle(String.format("Вы удалили \"%s\"", PRODUCT_NAME))
                .checkTimerIsNotExist();

        productPage.checkTitle(PRODUCT_NAME)
                .checkCartIconIsNotVisible();
    }
}
