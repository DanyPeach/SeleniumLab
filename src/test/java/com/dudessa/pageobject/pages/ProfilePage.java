package com.dudessa.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends AbstractPage{

    @FindBy(className = "ctaButton--fullArea")
    WebElement viewMoreLink;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage waitForLoading(){
        wait.until(ExpectedConditions.elementToBeClickable(viewMoreLink));
        return this;
    }

    @Override
    protected ProfilePage openPage() {
        return null;
    }
}
