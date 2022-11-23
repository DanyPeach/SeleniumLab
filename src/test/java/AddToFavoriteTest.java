import com.dudessa.pageobject.pages.CatalogPage;
import com.dudessa.pageobject.pages.WishListPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class AddToFavoriteTest {
    private static WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void initWebDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver.get("https://www.valentino.com/en-ca/women/new-arrivals");
        driver.manage().deleteAllCookies();
    }

    @Test
    public void testAddItemToFavorite(){
        CatalogPage catalogPage = new CatalogPage(driver);
        WishListPage wishListPage = new WishListPage(driver);
        int amountOfProducts = 5;

        driver.manage().window().maximize();
        catalogPage.clickSearchButton(amountOfProducts).goToFavPage();

        List<WebElement> wishProducts = wishListPage.pause(wishListPage.findWishCatalog()).findWishProducts();
        Assert.assertEquals(amountOfProducts, wishProducts.size());

    }

    @AfterTest
    public void exitDriver(){
        driver.quit();
    }
}
