package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.WearPage;

public class SortProductsTest extends BaseTest {

    @Test()
    public void checkSortAscByPrice() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .openCatalogWear();

        WearPage wearPage = new WearPage();
        wearPage.selectSortingOrder("price:asc");

        Assert.assertTrue(wearPage.checkPricesOrder());
    }
}
