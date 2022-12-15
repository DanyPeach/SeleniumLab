package com.dudessa.pageobject.test;

import com.dudessa.pageobject.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BackToTopTest extends CommonConditions{
    @Test
    public void testBackToTop(){
        HomePage homePage = new HomePage(driver);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        homePage.openPage();
        javascriptExecutor.executeScript("scroll(0, 6000);");
        homePage.backToTopCheck();
        boolean t = homePage.isBtnVisible();
        Assert.assertTrue(t);
    }
}
