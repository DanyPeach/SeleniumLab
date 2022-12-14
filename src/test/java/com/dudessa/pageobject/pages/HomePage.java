package com.dudessa.pageobject.pages;

import com.dudessa.pageobject.constants.TestConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Time;

public class HomePage extends AbstractPage {

    private final String PAGE_URL = "https://www.valentino.com/en-ca";

    @FindBy(xpath = "//button[@aria-controls='panelSearchMobile']")
    WebElement searchButton;

    @FindBy(id = "textSearch")
    WebElement inputLine;

    @FindBy(xpath = "//*[@id=\"panelSearch\"]/div[2]/div[3]/form/div[3]/div/ul/li/a")
    WebElement productLink;

    @FindBy(className = "vHeaderIcons__item--cyc")
    WebElement worldButton;

    @FindBy(id = "cycLabel--europe")
    WebElement europeLocator;

    @FindBy(className = "at")
    WebElement ausria;

    @FindBy(className = "lt")
    WebElement lithuania;

    @FindBy(className = "de")
    WebElement denmark;

    @FindBy(className = "shippingCountry")
    WebElement countryShop;

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
        }catch (TimeoutException e){
            searchButton.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(inputLine));
        inputLine.sendKeys(inputCode, Keys.ENTER);
        return this;
    }

    public HomePage enterKeys() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(inputLine));
        }catch (TimeoutException e) {
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
            wait.until(ExpectedConditions.elementToBeClickable(countryShop)).click();
        } catch (TimeoutException | ElementNotInteractableException e) {
            countryShop.click();
        }
        return this;
    }

    public HomePage chooseEurope() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(europeLocator));
        }catch (NoSuchElementException | TimeoutException  | ElementNotInteractableException r){
            countryShop.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(europeLocator));
        europeLocator.click();
        return this;
    }

    public HomePage chooseCoutry() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(ausria));
        } catch (NoSuchElementException | TimeoutException  | ElementNotInteractableException r){
            europeLocator.click();
            wait.until(ExpectedConditions.elementToBeClickable(lithuania)).click();
        }

        return this;
    }

    public String waitForNewCountry() {
        wait.until(ExpectedConditions.elementToBeClickable(countryShop));
        return countryShop.getText().contains("AT") || countryShop.getText().contains("LT") ? "AT" : "LT";
    }
}
