package appium;

import java.io.File;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class appiumBasics extends baseTest{
    @Test
    public void appiumTest() throws MalformedURLException, URISyntaxException {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
    }

}


