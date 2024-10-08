package appium_android;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
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
