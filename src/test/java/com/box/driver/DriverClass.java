package com.box.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverClass {
    private static DriverClass instance =  new DriverClass();
    public WebDriver driver;
    public WebDriverWait wait;

    private DriverClass() {
        if(driver==null) {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setPlatform(Platform.WINDOWS);
//            capabilities.setBrowserName("firefox");
//			capabilities.setCapability("marionette", true);

            FirefoxOptions ffOptions = new FirefoxOptions();
            ffOptions.setCapability(CapabilityType.ForSeleniumServer.PROXYING_EVERYTHING, true);
            ffOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            ffOptions.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
            ffOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
            ffOptions.setCapability("marionette", true);
            driver = new FirefoxDriver(ffOptions);

//			driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 50);
        }
    }

    public static DriverClass getInstance() {
        return instance;
    }
}
