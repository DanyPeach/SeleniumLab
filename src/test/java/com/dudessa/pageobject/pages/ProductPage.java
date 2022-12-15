package com.dudessa.pageobject.pages;

import com.dudessa.pageobject.constants.PageNaming;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[4]/div[6]/div/div[3]/p")
    WebElement codeOfProduct;

    @FindBy(className = "addProductToShoppingBagButton")
    WebElement addToCartButton;

    @FindBy(className = "vpanel__title")
    WebElement cartTitle;

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public ProductPage openPage() {
        driver.navigate().to(PageNaming.PRODUCT_TO_CART_PAGE);
        return this;
    }

    public String getCodeOfProduct(String mydata) {
        Pattern pattern = Pattern.compile("[A-Z0-9]{14}");
        Matcher matcher = pattern.matcher(mydata);
        return matcher.find() ? matcher.group() : null;
    }

    public ProductPage addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        return this;
    }

    public boolean checkCart() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cartTitle));
        }catch (TimeoutException e){
            logger.info("getting amount of products");
            return cartTitle.getText().contains("1");
        }
        return false;
    }

    public WebElement findCodeOnPage() {
        return codeOfProduct;
    }

}
