package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;


public class appiumBasics {
    @Test
    public void appiumTest() throws MalformedURLException{
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel_3a_testEmulator");
        options.setApp("//Users//aashok//IdeaProjects//appium_learnings//src//test//resources//ApiDemos-debug.apk");
//		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/ "),options);
        driver.quit();
    }
}


