package appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class LongPress  extends baseTest{
    @Test
    public void longPressGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId(("1. Custom Adapter"))).click();
        WebElement elem = driver.findElement((By.xpath("//android.widget.TextView[@text='People Names']")));
        longPressAction(elem);
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("android:id/title")).getText(),"Sample menu");
    }
}
