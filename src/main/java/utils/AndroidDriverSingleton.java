package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

public class AndroidDriverSingleton {
    private static AndroidDriver<MobileElement> driver;

    public AndroidDriverSingleton() {
    }

    public static AndroidDriver getDriver() {
        if (driver == null){
            driver = new AndroidDriver<>(CapabilitiesFactory.getAppiumServerURL(), CapabilitiesFactory.getCapabilities());
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
    }
}
