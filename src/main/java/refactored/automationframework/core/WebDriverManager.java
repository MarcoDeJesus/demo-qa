package refactored.automationframework.core;

import org.openqa.selenium.WebDriver;
import refactored.automationframework.configurations.ChromeDriverConfigurations;
import refactored.automationframework.configurations.DriverConfigurations;
import refactored.automationframework.configurations.FirefoxDriverConfigurations;
import refactored.automationframework.enums.WebBrowsers;
import refactored.automationframework.exceptions.WebDriverNotImplementedException;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private final int TIME_TO_WAIT_FOR_ELEMENT_LOAD = 5;
    private WebDriver driver;

    public WebDriver getWebDriverInstance(DriverConfigurations configurations) throws WebDriverNotImplementedException {

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
