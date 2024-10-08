package appium_android;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollDemo extends baseTest {
    @Test
    public void scrollDemoTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        scrollToAnElement("WebView");
        scrollToEnd();
    }
}
