package appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ScrollDemo extends baseTest {
    @Test
    public void scrollDemoTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        scrollToAnElement("WebView");
        scrollToEnd();
    }

}
