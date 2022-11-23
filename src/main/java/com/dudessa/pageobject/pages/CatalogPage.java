package com.dudessa.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class CatalogPage {
    private WebDriver webDriver;

    public CatalogPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(className = "toggleProductInWishlist")
    List<WebElement> listOfStars;

    @FindBy(className = "wishListLink")
    WebElement favouritePage;

    public CatalogPage clickSearchButton(int limitOfProduct){
        listOfStars.stream().limit(limitOfProduct).forEach(starButton -> starButton.click());
        return this;
    }

    public CatalogPage goToFavPage(){
        favouritePage.click();
        return this;
    }

    public CatalogPage pause(WebElement webElement){
        new WebDriverWait(webDriver, Duration.ofMillis(5000)).until(ExpectedConditions.elementToBeClickable(webElement));
        return this;
    }

}
