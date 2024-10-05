package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class testClass {

    public static AppiumDriverLocalService service;
    public static AndroidDriver driver;

    @Test
    public static void startAppiumServer() throws MalformedURLException {
        System.out.println("startAppiumServer");
        Map<String, String> env = new HashMap<>(System.getenv());
        env.put("ANDROID_HOME", "/Users/aashok/Library/Android/sdk");  // Correct path
        env.put("ANDROID_SDK_ROOT", "/Users/aashok/Library/Android/sdk");

        File logDir = new File("/Users/aashok/IdeaProjects/appium_learnings/appium_logs");
        if (!logDir.exists()) {
            logDir.mkdirs();
        }
        File logFile = new File(logDir, "appium-logfile.log");
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .withLogFile(logFile)
                .usingPort(4723)
                .build();
        service.start();
        System.out.println("startAppiumDriver");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel_3a_testEmulator");
        options.setApp("/Users/aashok/IdeaProjects/appium_learnings/src/test/resources/ApiDemos-debug.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
    }
}
