package appium_ios;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class scrollDemo extends iosBaseTest{
    @Test
    public void scrollDemoTest() throws InterruptedException {
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Web View"));


        Map<String, Object> scrollParams = new HashMap<>();
        scrollParams.put("predicateString", "label == 'Web View'");
        scrollParams.put("direction", "down");
//        scrollToElement(scrollParams);
        scrollToEnd(scrollParams);
        element.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='UIKitCatalog']")).click();
    }
}
