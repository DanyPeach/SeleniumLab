package com.dudessa.pageobject.pages;

import com.dudessa.pageobject.constants.PageNaming;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BoutiquePage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "DirectorySearchInput")
    WebElement searchBoutiqueLine;

    public BoutiquePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BoutiquePage openPage() {
        driver.navigate().to(PageNaming.BOUTIQUES_SEARCH_PAGE);
        return this;
    }

    public BoutiquePage enterAddress(String address){
        wait.until(ExpectedConditions.elementToBeClickable(searchBoutiqueLine));
        logger.info("entering address");
        searchBoutiqueLine.clear();
        searchBoutiqueLine.sendKeys(address, Keys.ENTER);
        return this;
    }
}
