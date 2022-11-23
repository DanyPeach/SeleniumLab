package com.dudessa.pageobject;

import com.dudessa.pageobject.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        webDriver.get("https://www.valentino.com/en-ca");
        HomePage homePage = new HomePage(webDriver);
    }
}
