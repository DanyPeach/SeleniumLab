package com.dudessa.pageobject.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.dudessa.pageobject.constants.PageNaming.FILTER_CATALOG_PAGE;

public class FilterPage extends AbstractPage{

    @FindBy(className = "Linea")
    WebElement filtration;

    @FindBy(xpath = "/html/body/div[1]/main/section/section[1]/section[5]/div/fieldset/ul/li[3]/label")
    WebElement collectionParam;

    @FindBy(className = "item__info")
    WebElement productInfo;

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public FilterPage openCollectionFilter(){
        wait.until(ExpectedConditions.elementToBeClickable(filtration)).click();
        return this;
    }

    public FilterPage scrollDown(int px){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0," + px + ")");
        return this;
    }

    public FilterPage selectCollection(){
        wait.until(ExpectedConditions.elementToBeClickable(collectionParam)).click();
        return this;
    }

    public String checkProductAfterFilter(String requiredCollection){
        wait.until(ExpectedConditions.elementToBeClickable(productInfo));
        String res = productInfo.getText();
        return res.contains(requiredCollection) ? requiredCollection : "";
    }

    @Override
    public FilterPage openPage() {
        driver.navigate().to(FILTER_CATALOG_PAGE);
        return this;
    }
}
