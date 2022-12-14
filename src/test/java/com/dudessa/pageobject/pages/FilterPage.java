package com.dudessa.pageobject.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.dudessa.pageobject.constants.PageNaming.FILTER_CATALOG_PAGE;

public class FilterPage extends AbstractPage {

    @FindBy(id = "accordionLabel_343")
    WebElement filtration;

    @FindBy(xpath = "//*[@id=\"accordionControl_962\"]/fieldset/ul/li[3]/label")
    WebElement collectionParam;

    @FindBy(className = "item__info")
    WebElement productInfo;

    @FindBy(className = "cause")
    WebElement err;

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public FilterPage openCollectionFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(filtration)).click();
        return this;
    }

    public FilterPage scrollDown(int px) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0," + px + ")");
        return this;
    }

    public FilterPage selectCollection() {
        collectionParam.click();
        return this;
    }

    public String checkProductAfterFilter(String requiredCollection) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(err));
        } catch (TimeoutException e) {
            String res = productInfo.getText();
            return res.contains(requiredCollection) ? requiredCollection : "";
        }
        return "";
    }

    @Override
    public FilterPage openPage() {
        driver.navigate().to(FILTER_CATALOG_PAGE);
        return this;
    }
}
