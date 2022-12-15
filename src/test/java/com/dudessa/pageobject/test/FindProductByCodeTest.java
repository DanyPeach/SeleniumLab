package com.dudessa.pageobject.test;
import static com.dudessa.pageobject.constants.TestConstants.*;

import com.dudessa.pageobject.constants.TestConstants;
import com.dudessa.pageobject.pages.HomePage;
import com.dudessa.pageobject.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindProductByCodeTest extends CommonConditions {

    @Test
    public void testFindProductByCode(){
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage.openPage()
                .clickSearchButton()
                .enterKeys()
                .goToProductPage();

        String res = productPage.getCodeOfProduct(
                productPage
                        .findCodeOnPage()
                        .getAttribute("innerHTML")
        );
        Assert.assertEquals(res, PRODUCT_CODE);
    }
}
