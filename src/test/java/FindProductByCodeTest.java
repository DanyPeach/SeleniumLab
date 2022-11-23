import com.dudessa.pageobject.pages.HomePage;
import com.dudessa.pageobject.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindProductByCodeTest {
    private static WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void initWebDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver.get("https://www.valentino.com/en-ca");
    }

    @Test
    public void testSortingByPrice(){
        String codeOfProductStr = "1W0S0FQ4XTMUWT";
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage.pause(homePage.findButton())
                .clickSearchButton()
                .pause(homePage.getInputLine())
                .enterKeys(codeOfProductStr)
                .pause(homePage.getProductLink())
                .goToProductPage();

        String mydata = productPage.findCodeOnPage().getAttribute("innerHTML");
        Pattern pattern = Pattern.compile("[A-Z0-9]{14}");
        Matcher matcher = pattern.matcher(mydata);
        String res = matcher.find() ? matcher.group() : null;

        Assert.assertEquals(res, codeOfProductStr);

    }


    @AfterTest
    public void exitDriver(){
        driver.quit();
    }
}
