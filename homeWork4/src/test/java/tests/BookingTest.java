package tests;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.MapPage;
import pages.ProductPage;
import pages.SearchResultPage;
import java.time.LocalDate;
import static com.codeborne.selenide.Selenide.*;

public class BookingTest extends BaseTest {

    final String destinationTown = "Барселона";
    final int countOfNight = 7;
    final LocalDate dateStart = LocalDate.now();
    final LocalDate dateFinish = dateStart.plusDays(countOfNight);
    final String checkIn = dateStart.toString();
    final String checkOut = dateFinish.toString();
    final int adultCount = 1;
    final int childrenCount = 0;
    final int roomCount = 1;
    final int starsCount = 5;

    @Before
    public void someName() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .sendDestination(destinationTown)
                .sendCheckInCheckOutDates(checkIn, checkOut)
                .sendGuestsAndRooms(adultCount, childrenCount, roomCount)
                .searchBoxButtonClick();
    }

    @Test
    public void hotelStarsCountTest() {
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.sendStatsFilter(starsCount)
                        .loadingWait()
                        .checkStarsCount(starsCount);
    }

    //@Test
    public void hotelStarsCountOnMapTest() {
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.mapClick();

        MapPage mapPage = new MapPage();
        mapPage.sendStatsFilter(starsCount)
                .loadingMassageWait()
                .checkStarsCount(starsCount);
    }

    //@Test
    public void mapMarkerCountTest() {
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.mapClick();

        MapPage mapPage = new MapPage();
        mapPage.loadingMassageWait()
                .checkLeftCardsContainersCountAndMarkerCount()
                .mapSizeDecrement()
                .loadingMassageWait()
                .checkLeftCardsContainersCountAndMarkerCount();
    }

    //@Test
    public void hotelNameTest() {
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.mapClick();

        MapPage mapPage = new MapPage();
        String hotelName = mapPage.loadingMassageWait()
                                  .getFirstHotelName();
                           mapPage.openProduct();

        switchTo().window(1);

        ProductPage productPage = new ProductPage();
        productPage.checkHotelName(hotelName);
    }
}
