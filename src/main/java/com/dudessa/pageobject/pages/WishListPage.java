package com.dudessa.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WishListPage {
    private WebDriver webDriver;

    public WishListPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(className = "wishList-item")
    List<WebElement> wishProducts;

    @FindBy(className = "wish-list-items")
    WebElement wishCatalog;

    public List<WebElement> findWishProducts() {
        return wishProducts;
    }

    public WebElement findWishCatalog(){
        return wishCatalog;
    }

    public WishListPage pause(WebElement webElement){
        new WebDriverWait(webDriver, Duration.ofMillis(5000)).until(ExpectedConditions.elementToBeClickable(webElement));
        return this;
    }
}
