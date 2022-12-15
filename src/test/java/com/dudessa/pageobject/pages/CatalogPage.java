package com.dudessa.pageobject.pages;

import com.dudessa.pageobject.constants.PageNaming;
import com.dudessa.pageobject.constants.TestConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.dudessa.pageobject.constants.PageNaming.CATALOG_PAGE_URL;
import static com.dudessa.pageobject.constants.TestConstants.SUGGESTION_INPUT;


public class CatalogPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(className = "toggleProductInWishlist")
    List<WebElement> listOfStars;

    @FindBy(className = "item__info")
    WebElement infoOfProduct;

    @FindBy(className = "imageWrapper")
    WebElement imageWrapper;


    public CatalogPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CatalogPage clickSearchButton(int limitOfProduct){
        listOfStars.stream().limit(limitOfProduct).forEach(WebElement::click);
        return this;
    }

    public String infoCheck(){
        logger.info("waiting for " + imageWrapper.getTagName() + " to load");
        wait.until(ExpectedConditions.elementToBeClickable(imageWrapper));
        return infoOfProduct.getText().contains(SUGGESTION_INPUT) ? SUGGESTION_INPUT : "";
    }


    @Override
    public CatalogPage openPage() {
        driver.navigate().to(CATALOG_PAGE_URL);
        return this;
    }
}
