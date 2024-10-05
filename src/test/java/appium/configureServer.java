package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class configureServer {
    AppiumDriverLocalService service;
    AndroidDriver driver;

    @Test
    public void configServer() throws MalformedURLException, InterruptedException {
        File logDir = new File("/Users/aashok/IdeaProjects/appium_learnings/appium_logs");
        if (!logDir.exists()) {
            logDir.mkdirs();
        }

        File logFile = new File(logDir, "appium-logfile.log");
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .withLogFile(logFile)
                .usingPort(4723)
                .build();

        service.start();
        Thread.sleep(5000);
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel_3a_testEmulator");
        options.setApp("//Users//aashok//IdeaProjects//appium_learnings//src//test//resources//ApiDemos-debug.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.quit();
        service.stop();
    }
}
