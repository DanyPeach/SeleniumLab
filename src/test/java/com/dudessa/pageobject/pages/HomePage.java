package com.dudessa.pageobject.pages;

import com.dudessa.pageobject.constants.TestConstants;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        wait.until(ExpectedConditions.elementToBeClickable(inputLine));
        inputLine.sendKeys(inputCode, Keys.ENTER);
        return this;
    }

    public HomePage enterKeys() {
        wait.until(ExpectedConditions.elementToBeClickable(inputLine));
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
            wait.until(ExpectedConditions.elementToBeClickable(worldButton)).click();
        } catch (TimeoutException e) {
            worldButton.click();
        }
        return this;
    }

    public HomePage chooseEurope() {
        wait.until(ExpectedConditions.elementToBeClickable(europeLocator)).click();
        return this;
    }

    public HomePage chooseCoutry() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(ausria));
        } catch (TimeoutException e) {
            lithuania.click();
        }

        return this;
    }

    public String waitForNewCountry() {
        wait.until(ExpectedConditions.elementToBeClickable(countryShop));
        return countryShop.getText().contains("AT") || countryShop.getText().contains("LT") ? "AT" : "";
    }
}
