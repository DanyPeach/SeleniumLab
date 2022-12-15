package com.dudessa.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        String address = locatorResult.getText();
        return !address.contains("sorry");
    }
}
