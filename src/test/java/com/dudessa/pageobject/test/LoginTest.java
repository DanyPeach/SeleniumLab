package com.dudessa.pageobject.test;

import com.dudessa.pageobject.constants.PageNaming;
import com.dudessa.pageobject.model.User;
import com.dudessa.pageobject.pages.LoginPage;
import com.dudessa.pageobject.pages.ProfilePage;
import com.dudessa.pageobject.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.dudessa.pageobject.constants.PageNaming.*;

public class LoginTest extends CommonConditions {
    @Test
    public void testUserLogin(){
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        User testUser = UserCreator.withCredentialsFromProperty();
        loginPage.openPage().login(testUser);
        profilePage.waitForLoading();
        Assert.assertEquals(PROFILE_PAGE_AFTER_LOGIN, driver.getCurrentUrl());
    }
}
