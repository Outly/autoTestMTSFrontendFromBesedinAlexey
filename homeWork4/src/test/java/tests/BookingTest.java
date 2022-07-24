package tests;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.MapPage;
import pages.SearchResultPage;
import java.time.LocalDate;

public class BookingTest extends BaseTest {

    String destinationTown = "Барселона";
    int countOfNight = 7;
    LocalDate dateStart = LocalDate.now();
    LocalDate dateFinish = dateStart.plusDays(countOfNight);
    String checkIn = dateStart.toString();
    String checkOut = dateFinish.toString();
    int adultCount = 1;
    int childrenCount = 0;
    int roomCount = 1;
    int starsCount = 5;

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

    @Test
    public void hotelStarsCountOnMapTest() {
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.mapClick();

        MapPage mapPage = new MapPage();
        mapPage.sendStatsFilter(starsCount)
                .loadingMassageWait()
                .checkStarsCount(starsCount);
    }

    @Test
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
}
