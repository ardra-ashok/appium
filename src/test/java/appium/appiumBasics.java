package appium;

import java.io.File;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class appiumBasics {
    @Test
    public void appiumTest() throws MalformedURLException, URISyntaxException {
        File logDir = new File("/Users/aashok/IdeaProjects/appium_learnings/appium_logs");
        if (!logDir.exists()) {
            logDir.mkdirs();
        }

        File logFile = new File(logDir, "appium-logfile.log");

        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .withLogFile(logFile)
                .usingPort(4723)
                .build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel_3a_testEmulator");
        options.setApp("//Users//aashok//IdeaProjects//appium_learnings//src//test//resources//ApiDemos-debug.apk");
//		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.quit();
        service.stop();
    }
}


