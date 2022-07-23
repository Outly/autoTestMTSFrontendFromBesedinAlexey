package tests;
import org.junit.Test;
import pages.HomePage;
import pages.SearchResultPage;

public class StarsCountTest extends BaseTest {

    @Test
    public void HotelStarsCountTest() {

        String destinationTown = "Барселона";
        String checkIn = "2022-08-01";
        String checkOut = "2022-08-08";
        int adultCount = 1;
        int childrenCount = 0;
        int roomCount = 1;

        int starsCount = 5;

        HomePage homePage = new HomePage();
        homePage.openPage()
                .sendDestination(destinationTown)
                .sendCheckInCheckOutDates(checkIn, checkOut)
                .sendGuestsAndRooms(adultCount, childrenCount, roomCount)
                .searchBoxButtonClick();

        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.sendStatsFilter(starsCount)
                        .loadingWait()
                        .checkStarsCount(starsCount);

    }
}
