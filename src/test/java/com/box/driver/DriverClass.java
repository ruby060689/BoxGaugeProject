package com.box.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverClass {
    private static DriverClass instance =  new DriverClass();
    public WebDriver driver;
    public WebDriverWait wait;

    private DriverClass() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setCapability(CapabilityType.ForSeleniumServer.PROXYING_EVERYTHING, true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,100);
    }

    public static DriverClass getInstance() {
        return instance;
    }
}
