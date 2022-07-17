package tests;
import org.junit.Test;
import pages.HomePage;
import pages.SearchResultPage;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CheckOrderTest extends BaseTest{

    @Test
    public void checkOrder() {

        String destinationTown = "Барселона";
        String checkIn = "2022-08-01";
        String checkOut = "2022-08-08";
        int adultCount = 1;
        int childrenCount = 0;
        int roomCount = 1;

        LocalDate fromDate = LocalDate.parse(checkIn);
        LocalDate toDate = LocalDate.parse(checkOut);
        int nightCount = (int) ChronoUnit.DAYS.between(fromDate, toDate);

        HomePage homePage = new HomePage();
        homePage.openPage()
                .sendDestination(destinationTown)
                .sendCheckInCheckOutDates(checkIn, "2022-08-08")
                .sendGuestsAndRooms(adultCount, childrenCount, roomCount)
                .searchBoxButtonClick();

        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.checkDestinationTown(destinationTown)
                        .dateDisplayClick()
                        .dateCheck(checkIn)
                        .dateCheck(checkOut)
                        .checkNightsCount(nightCount)
                        .checkAdultsChildrenRoomCount(adultCount, childrenCount, roomCount)
                        .checkHotelCount();
    }
}
