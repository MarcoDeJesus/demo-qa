package refactored.automationframework.configurations;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverConfigurations implements DriverConfigurations{
    private final String WEB_DRIVER_CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private final String CHROMEDRIVER_PATH = "src/main/resources/chromedriver";

    @Override
    public ChromeDriver getWebDriverInstance(){
        ChromeOptions options = settingWebDriverOptions();
        return new ChromeDriver(options);
    }

    private ChromeOptions settingWebDriverOptions(){
        System.setProperty(WEB_DRIVER_CHROME_DRIVER_PROPERTY, CHROMEDRIVER_PATH);
        ChromeOptions options = new ChromeOptions();

        return options;
    }
}
