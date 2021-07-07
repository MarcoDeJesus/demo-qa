package refactored.automationframework.configurations;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class FirefoxDriverConfigurations implements DriverConfigurations{

    private final String WEB_DRIVER_FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
    private final String FIREFOX_PATH = "src/main/resources/geckodriver";

    @Override
    public FirefoxDriver getWebDriverInstance(){
        settingWebDriverOptions();
        return new FirefoxDriver();
    }

    private void settingWebDriverOptions(){
        System.setProperty(WEB_DRIVER_FIREFOX_DRIVER_PROPERTY, FIREFOX_PATH);
        new FirefoxOptions().setBinary(new FirefoxBinary(new File(FIREFOX_PATH)));
    }
}
