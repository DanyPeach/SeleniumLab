package com.dudessa.pageobject.test;

import com.dudessa.pageobject.pages.CatalogPage;
import com.dudessa.pageobject.pages.WishListPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class AddToFavoriteTest extends CommonConditions {
    @Test
    public void testAddItemToFavorite(){
        CatalogPage catalogPage = new CatalogPage(driver);
        WishListPage wishListPage = new WishListPage(driver);
        int amountOfProducts = 5;

        driver.manage().window().maximize();
        catalogPage.openPage().clickSearchButton(amountOfProducts);

        int resultativeSize = wishListPage
                .openPage()
                .findWishProducts()
                .size();
        Assert.assertTrue(amountOfProducts >= resultativeSize);
    }
}
