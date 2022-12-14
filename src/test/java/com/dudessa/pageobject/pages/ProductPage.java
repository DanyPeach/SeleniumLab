package com.dudessa.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductPage extends AbstractPage{
    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[4]/div[6]/div/div[3]/p")
    WebElement codeOfProduct;

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected ProductPage openPage() {
        return null;
    }

    public String getCodeOfProduct(String mydata){
        Pattern pattern = Pattern.compile("[A-Z0-9]{14}");
        Matcher matcher = pattern.matcher(mydata);
        return matcher.find() ? matcher.group() : null;
    }

    public WebElement findCodeOnPage(){
        return codeOfProduct;
    }

}
