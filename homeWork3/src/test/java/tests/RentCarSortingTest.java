package tests;

import org.junit.Test;
import pages.CarMapPage;
import pages.HomePage;
import pages.RentCarPage;

public class RentCarSortingTest extends BaseTest {

    @Test
    public void rentCarSortTest() throws InterruptedException {

        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToRentCar();

        RentCarPage rentCarPage = new RentCarPage();
        rentCarPage.sendDestination("Барселона")
                   .searchBoxButton();

        CarMapPage carMapPage = new CarMapPage();
        carMapPage.checkSortingPrices();

        Thread.sleep(5000);
    }
}
