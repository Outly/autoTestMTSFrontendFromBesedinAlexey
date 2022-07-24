package tests;

import org.junit.Test;
import pages.HomePage;
import pages.MapPage;
import pages.SearchResultPage;

import java.time.LocalDate;

public class MapMarkerCountTest extends BaseTest{
    @Test
    public void mapMarkerCountTest() {

        String destinationTown = "Мадрид";
        int countOfNight = 7;
        LocalDate dateStart = LocalDate.now();
        LocalDate dateFinish = dateStart.plusDays(countOfNight);
        String checkIn = dateStart.toString();
        String checkOut = dateFinish.toString();
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
        searchResultPage.mapClick();

        MapPage mapPage = new MapPage();
        mapPage.loadingMassageWait()
                .checkLeftCardsContainersCountAndMarkerCount()
                .mapSizeDecrement()
                .loadingMassageWait()
                .checkLeftCardsContainersCountAndMarkerCount();

    }
}
