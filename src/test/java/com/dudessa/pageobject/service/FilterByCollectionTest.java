//package com.dudessa.pageobject.test;
//
//import com.dudessa.pageobject.pages.FilterPage;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import static com.dudessa.pageobject.constants.TestConstants.PRODUCT_COLLECTION;
//
//public class FilterByCollectionTest extends CommonConditions {
//    @Test
//    public void testFilterByCollection() {
//        FilterPage filterPage = new FilterPage(driver);
//        driver.manage().window().maximize();
//
//        filterPage.openPage()
//                .scrollDown(250)
//                .openCollectionFilter()
//                .scrollDown(200)
//                .selectCollection();
//
//        String result = filterPage.checkProductAfterFilter(PRODUCT_COLLECTION);
//
//        Assert.assertEquals(result, PRODUCT_COLLECTION);
//    }
//}
