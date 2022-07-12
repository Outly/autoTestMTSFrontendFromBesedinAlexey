package tests;
import org.junit.Test;
import pages.BasketPage;
import pages.BlackPoloMPage;
import pages.HomePage;
import pages.WearPage;

public class AddProductToBasketTest {

    @Test
    public void addProductToBasketAndFillingFields() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .clickGoToWear();

        WearPage wearPage = new WearPage();
            wearPage.goToBlackPoloMClick();

        BlackPoloMPage blackPoloMPage = new BlackPoloMPage();
        blackPoloMPage.addToBasketClick();

        BasketPage basketPage = new BasketPage();
        basketPage.fillingFields()
                .PressFinishAndCheckMassage("Укажите, пожалуйста, корректный номер телефона");

    }
}
