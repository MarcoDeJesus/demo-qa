package com.printapp;

import org.openqa.selenium.WebDriver;
import refactored.automationframework.configurations.ChromeWebDriverConfigurations;
import refactored.automationframework.core.WebDriverManager;

public class BaseTest {

    private final String WEB_APPLICATION_URL = "http://manual01.qaminds.com/ManualT/";
    protected WebDriver driver;

    public void SetUp(){
        driver = new WebDriverManager().getWebDriverInstance(new ChromeWebDriverConfigurations());
        driver.navigate().to(WEB_APPLICATION_URL);
    }

    public void CleanUp(){
        driver.quit();
    }
}
