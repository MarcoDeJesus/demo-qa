package com.printapp;

import org.openqa.selenium.WebDriver;
import refactored.automationframework.configurations.ChromeDriverConfigurations;
import refactored.automationframework.core.WebDriverManager;
import refactored.automationframework.enums.WebBrowsers;
import refactored.automationframework.exceptions.WebDriverNotImplementedException;

public class BaseTest {

    private final String WEB_APPLICATION_URL = "http://manual01.qaminds.com/ManualT/";
    protected WebDriver driver;

    public void SetUp(){
        try {
            driver = new WebDriverManager().getWebDriverInstance(new ChromeDriverConfigurations());
            driver.navigate().to(WEB_APPLICATION_URL);
        } catch (WebDriverNotImplementedException e) {
            e.printStackTrace();
        }
    }

    public void CleanUp(){
        driver.quit();
    }
}
