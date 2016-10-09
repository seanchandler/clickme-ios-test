package com.ex;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.logging.Logger;

public class TestBase {

    protected final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    protected static IOSDriver<MobileElement> driver;
    protected static AppiumDriverLocalService service;

    @BeforeClass
    public static void startAppium() throws Exception {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withArgument(GeneralServerFlag.LOG_LEVEL, "debug")
                .usingAnyFreePort();
        service = builder.build();
        service.start();
    }

    @Before
    public void setup() throws Exception {
        File appDir = new File("src/test/resources");
        File app = new File(appDir, "TestApp.app.zip");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("deviceName", "iPhone 6");
        capabilities.setCapability("browserName", "Safari");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("automationName", "XCUITest");
        //sometimes environment has performance problems
        capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new IOSDriver<>(service.getUrl(), capabilities);
    }

    @After
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

    @AfterClass
    public  static  void stopAppium(){
        service.stop();
    }
}
