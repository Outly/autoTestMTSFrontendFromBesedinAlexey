package tests;

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
    public void promoBannersTest() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .carouselCheck();
    }

}
