package com.dudessa.pageobject.test;

import com.dudessa.pageobject.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCountryTest extends CommonConditions{
    @Test
    public void testChangeCountryMethod(){
        HomePage homePage = new HomePage(driver);
        driver.manage().window().maximize();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("scroll(0, 5500);");
        homePage.openPage().clickOnWorld().chooseInterCite();
        String result = homePage.waitForNewCountry();
        Assert.assertEquals(result, "wb");
    }
}
