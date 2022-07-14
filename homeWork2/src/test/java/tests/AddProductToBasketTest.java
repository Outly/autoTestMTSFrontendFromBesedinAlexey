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
        basketPage.setNameField("Тестов Тест Тестович")
                .setPhoneField("0000000000")
                .setRegionField("Камчатский край")
                .setAddressField("Беринга 1")
                .setTownField("Петропавловск-Камчатский")
                .setAddresseeField("Тестов Тест Тестович")
                .setStreetField("ул Беринга")
                .setHouseField("д. 1")
                .setOfficeField("1")
                .finishButtonClick()
                .checkMassage("Укажите, пожалуйста, корректный номер телефона");

    }
}
