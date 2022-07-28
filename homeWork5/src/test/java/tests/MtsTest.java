package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.HomePage;

public class MtsTest extends BaseTest {


//    @Test
//    public void productInBasketTest() {
//        HomePage homePage = new HomePage();
//        homePage.openPage()
//                .goToSmartPhone();
//    }

    @Test
    @Owner("Долженко Артём")
    @Description("Выполняется проверка автоматической смены картинок в карусели на главной странице." +
            "Для каждого баннера проверяем, что ссылка отличается от ссылки предыдущего")
    @DisplayName("Прогкрутка промо баннеров")
    public void promoBannersTest() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .carouselCheck();
    }

}
