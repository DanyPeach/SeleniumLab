package com.dudessa.pageobject.test;

import com.dudessa.pageobject.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCountryTest extends CommonConditions{
    @Test
    public void testChangeCountryMethod(){
        HomePage homePage = new HomePage(driver);
        driver.manage().window().maximize();
        homePage.openPage().clickOnWorld().chooseEurope().chooseCoutry();
        String result = homePage.waitForNewCountry();
        Assert.assertEquals(result, "AT");
    }
}
