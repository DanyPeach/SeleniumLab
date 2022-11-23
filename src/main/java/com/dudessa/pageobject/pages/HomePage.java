package com.dudessa.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.dudessa.pageobject.constants.PageNaming.HOME_PAGE_NAME;

public class HomePage {

    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;

        if(!HOME_PAGE_NAME.equals(webDriver.getTitle())){
            throw new IllegalStateException("Not that page stupid");
        }
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(className = "vHeaderIcons__item--textSearch")
    WebElement searchButton;

    @FindBy(id = "textSearch")
    WebElement inputLine;

    @FindBy(xpath = "//*[@id=\"panelSearch\"]/div[2]/div[3]/form/div[3]/div/ul/li/a")
    WebElement productLink;

    public HomePage clickSearchButton(){
        searchButton.click();
        return this;
    }

    public HomePage enterKeys(String inputCode){
        inputLine.sendKeys(inputCode);
        return this;
    }

    public HomePage goToProductPage(){
        productLink.click();
        return this;
    }


    public HomePage pause(WebElement webElement){
        new WebDriverWait(webDriver, Duration.ofMillis(5000)).until(ExpectedConditions.elementToBeClickable(webElement));
        return this;
    }

    public WebElement findButton(){
        return searchButton.findElement(By.tagName("button"));
    }

    public WebElement getInputLine() {
        return inputLine;
    }

    public WebElement getProductLink() {
        return productLink;
    }
}
