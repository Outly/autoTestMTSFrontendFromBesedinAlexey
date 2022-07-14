package tests;
import org.junit.Test;
import pages.BasketPage;
import pages.ProductPage;
import pages.HomePage;
import pages.WearPage;

public class AddProductToBasketTest {

    @Test
    public void addProductToBasketAndFillingFields() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .clickGoToWear();

        WearPage wearPage = new WearPage();
            wearPage.goToProduct("Футболка поло черная (м)");

        ProductPage productPage = new ProductPage();
        productPage.addToBasketClick();

        BasketPage basketPage = new BasketPage();
        basketPage.setNameField()
                .setPhoneField()
                .setRegionField()
                .setAddressField()
                .setTownField()
                .setAddresseeField()
                .setStreetField()
                .setHouseField()
                .setOfficeField()
                .finishButtonClick()
                .CheckMassage("Укажите, пожалуйста, корректный номер телефона");

    }
}
