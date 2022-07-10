import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddProductToBucketTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://homebrandofficial.ru/wear");
    }

    @Test
    public void checkingFindProduct() {

        String productName = "ФУТБОЛКА ПОЛО ЧЕРНАЯ (М)";
        String priceExpected = "2 800";

        WebElement findInput = driver.findElement(By.xpath("//input[@placeholder='Поиск']")); // .t-store__filter__input.js-store-filter-search
        findInput.sendKeys(productName);

        WebElement findButton = driver.findElement(By.cssSelector(".t-store__search-icon.js-store-filter-search-btn")); // //*[@class='t-store__search-icon js-store-filter-search-btn']
        findButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".js-store-filters-prodsnumber"))); // Ожидаем, что элемент видимый и можно ли по нему кликнуть
        int count = Integer.parseInt(driver.findElement(By.cssSelector(".js-store-filters-prodsnumber")).getText()); // //span[@class='js-store-filters-prodsnumber']
        String productNameActual = driver.findElement(By.cssSelector(".js-store-prod-name.js-product-name.t-store__card__title.t-name.t-name_xs")).getText(); // //div[contains(@class, 'js-store-prod-name')][1]
        String priceActual = driver.findElement(By.cssSelector(".js-product-price.js-store-prod-price-val.t-store__card__price-value.notranslate")).getText(); // //div[@class= 'js-product-price js-store-prod-price-val t-store__card__price-value notranslate']

        Assert.assertEquals(1, count);
        Assert.assertEquals(productName, productNameActual);
        Assert.assertEquals(priceExpected, priceActual);
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
