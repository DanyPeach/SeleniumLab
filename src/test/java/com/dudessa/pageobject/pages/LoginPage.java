package com.dudessa.pageobject.pages;

import com.dudessa.pageobject.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.dudessa.pageobject.constants.PageNaming.*;

public class LoginPage extends AbstractPage{

    @FindBy(name = "LoginViewModel.Email")
    WebElement emailInput;

    @FindBy(name = "LoginViewModel.Password")
    WebElement password;

    @FindBy(className = "login__form")
    WebElement loginForm;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage login(User user){
        emailInput.sendKeys(user.getUserMail());
        password.sendKeys(user.getPassword(), Keys.ENTER);
        return this;
    }

    @Override
    public LoginPage openPage() {
        driver.navigate().to(LOGIN_PAGE_URL);
        return this;
    }
}
