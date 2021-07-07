package refactored.automationframework.configurations;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriverConfigurations implements WebDriverConfigurations {
    private static final String WEB_DRIVER_CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String CHROMEDRIVER_PATH = "src/main/resources/chromedriver";

    @Override
    public ChromeDriver getWebDriverInstance(){
        var options = settingWebDriverOptions();
        return new ChromeDriver(options);
    }

    private ChromeOptions settingWebDriverOptions(){
        System.setProperty(WEB_DRIVER_CHROME_DRIVER_PROPERTY, CHROMEDRIVER_PATH);
        return new ChromeOptions();
    }
}
