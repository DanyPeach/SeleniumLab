package com.dudessa.pageobject.test;

import com.dudessa.pageobject.pages.BoutiquePage;
import com.dudessa.pageobject.pages.FoundAdressPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchForAddressTest extends CommonConditions{
    @Test
    public void testSearchForAddress(){
        BoutiquePage boutiquePage = new BoutiquePage(driver);
        FoundAdressPage foundAdressPage = new FoundAdressPage(driver);

        boutiquePage.openPage().enterAddress("New York");
        boolean resultOfSearch = foundAdressPage.checkResults();
        Assert.assertTrue(resultOfSearch);
    }
}
