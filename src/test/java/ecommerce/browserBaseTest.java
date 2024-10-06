package ecommerce;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class browserBaseTest {
    public static AppiumDriverLocalService service;
    public static AndroidDriver driver;
    @BeforeClass
    public void configureAppium() throws MalformedURLException {

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
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel_3a_testEmulator");
        options.setChromedriverExecutable("/Users/aashok/IdeaProjects/appium_learnings/drivers/chromedriver");
        options.setCapability("browserName","Chrome");
        options.setApp("//Users//aashok//IdeaProjects//appium_learnings//src//test//resources//General-Store.apk");
//      Xpath, id, accessibilityId, className , androidUiAutomator
//		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
