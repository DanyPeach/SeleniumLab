package com.dudessa.pageobject.pages;

import org.apache.commons.lang3.exception.ExceptionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FoundAdressPage extends AbstractPage{
    @FindBy(className = "Locator-results")
    WebElement locatorResult;

    public FoundAdressPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FoundAdressPage openPage() {
        return null;
    }

    public boolean checkResults(){
        wait.until(ExpectedConditions.visibilityOf(locatorResult));
        String address = locatorResult.getText();
        return !address.contains("sorry");
    }
}
