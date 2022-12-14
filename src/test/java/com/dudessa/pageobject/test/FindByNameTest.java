package com.dudessa.pageobject.test;

import static com.dudessa.pageobject.constants.TestConstants.*;

import com.dudessa.pageobject.pages.CatalogPage;
import com.dudessa.pageobject.pages.HomePage;
import com.dudessa.pageobject.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindByNameTest extends CommonConditions {
    @Test
    public void testFindProductByAbstractName(){
        String expectedSuggestion = SUGGESTION_INPUT;
        HomePage homePage = new HomePage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);

        homePage.openPage()
                .clickSearchButton()
                .enterKeys(expectedSuggestion);

        String res = catalogPage.infoCheck();

        Assert.assertEquals(res, expectedSuggestion);

    }
}
