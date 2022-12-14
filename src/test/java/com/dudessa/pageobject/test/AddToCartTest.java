package com.dudessa.pageobject.test;

import com.dudessa.pageobject.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends CommonConditions{
    @Test
    public void testAddToCart(){
        ProductPage productPage = new ProductPage(driver);
        boolean res = productPage
                .openPage()
                .addToCart()
                .checkCart();
        Assert.assertFalse(res);
    }
}
