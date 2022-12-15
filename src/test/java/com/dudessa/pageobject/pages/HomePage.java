package com.dudessa.pageobject.pages;

import com.dudessa.pageobject.constants.TestConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;

public class HomePage extends AbstractPage {

    private final String PAGE_URL = "https://www.valentino.com/en-ca";

    @FindBy(xpath = "//button[@aria-controls='panelSearchMobile']")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"textSearch\"]")
    WebElement inputLine;

    @FindBy(xpath = "//*[@id=\"panelSearch\"]/div[2]/div[3]/form/div[3]/div/ul/li/a")
    WebElement productLink;

    @FindBy(xpath = "//*[@id=\"home\"]/footer/div[3]/div[2]/button")
    WebElement worldButton;

    @FindBy(id = "cycLabel--europe")
    WebElement europeLocator;

    @FindBy(className = "at")
    WebElement ausria;

    @FindBy(className = "gb")
    WebElement lithuania;

    @FindBy(className = "backToTop")
    WebElement backToTopButton;

    @FindBy(className = "chooseYourCountry__wxLink")
    WebElement internationalCite;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return this;
    }

    @Override
    public HomePage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public HomePage enterKeys(String inputCode) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(inputLine));
        } catch (TimeoutException e) {
            searchButton.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(inputLine));
        inputLine.sendKeys(inputCode, Keys.ENTER);
        return this;
    }

    public HomePage enterKeys() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(inputLine));
        } catch (TimeoutException e) {
            searchButton.click();
        }
        inputLine.sendKeys(TestConstants.PRODUCT_CODE);
        return this;
    }

    public HomePage goToProductPage() {
        wait.until(ExpectedConditions.elementToBeClickable(productLink));
        productLink.click();
        return this;
    }

    public HomePage clickOnWorld() {
        try {
            wait.until(ExpectedConditions.visibilityOf(worldButton)).click();
        } catch (TimeoutException e) {
            worldButton.click();
        }
        return this;
    }

    public HomePage chooseInterCite() {
        try {
            wait.until(ExpectedConditions.visibilityOf(worldButton));
        } catch (TimeoutException e) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("scroll(0, 500);");
            internationalCite.click();
        }
        return this;
    }

//    public HomePage chooseEurope() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(europeLocator));
//        } catch (NoSuchElementException | TimeoutException | ElementNotInteractableException r) {
//            worldButton.click();
//        }
//        wait.until(ExpectedConditions.elementToBeClickable(europeLocator));
//        europeLocator.click();
//        return this;
//    }
//
//    public HomePage chooseCoutry() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(ausria)).click();
//        } catch (NoSuchElementException | TimeoutException | ElementNotInteractableException r) {
//            europeLocator.click();
//            try {
//                wait.until(ExpectedConditions.elementToBeClickable(ausria)).click();
//            } catch (NoSuchElementException | TimeoutException | ElementNotInteractableException e) {
//                lithuania.click();
//            }
//        }
//
//        return this;
//    }

    public HomePage backToTopCheck() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(inputLine));
        }catch (TimeoutException e){
            backToTopButton.click();
        }
        return this;
    }

    public boolean isBtnVisible() {
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        return searchButton.isDisplayed();
    }

    public String waitForNewCountry() {
        String currentURL = driver.getCurrentUrl();
        return currentURL.toLowerCase(Locale.ROOT).contains("wb") ? "at" : "wb";
    }
}
