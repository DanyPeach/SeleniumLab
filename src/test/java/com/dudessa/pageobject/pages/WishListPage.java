package com.dudessa.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WishListPage extends AbstractPage{
    private final String PAGE_URL = "https://www.valentino.com/en-ca/account/WishList";

    @FindBy(className = "wishList-item")
    List<WebElement> wishProducts;

    @FindBy(className = "wish-list-items")
    WebElement wishCatalog;

    public WishListPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public WishListPage openPage() {
        driver.navigate().to(PAGE_URL);
        wait.until(ExpectedConditions.elementToBeClickable(wishCatalog));
        return this;
    }

    public List<WebElement> findWishProducts() {
        return wishProducts;
    }
}