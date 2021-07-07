package refactored.automationframework.core;

import org.openqa.selenium.WebDriver;
import refactored.automationframework.configurations.WebDriverConfigurations;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static final int TIME_TO_WAIT_FOR_ELEMENT_LOAD = 5;
    private WebDriver driver;

    public WebDriver getWebDriverInstance(WebDriverConfigurations configurations){

        driver = configurations.getWebDriverInstance();

        settingImplicitlyWaitingTime();
        maximizeWindow();

        return driver;
    }

    private void settingImplicitlyWaitingTime(){
        driver.manage().timeouts().implicitlyWait(TIME_TO_WAIT_FOR_ELEMENT_LOAD, TimeUnit.SECONDS);
    }

    private void maximizeWindow(){
        driver.manage().window().maximize();
    }
}
