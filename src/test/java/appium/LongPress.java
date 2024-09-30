package appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class LongPress  extends baseTest{
    @Test
    public void longPressGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId(("1. Custom Adapter"))).click();
        WebElement elem = driver.findElement((By.xpath("//android.widget.TextView[@text='People Names']")));

        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)elem).getId(),
                        "duration",2000));
        driver.findElement(By.id(""))
        Thread.sleep(2000);
    }
}
