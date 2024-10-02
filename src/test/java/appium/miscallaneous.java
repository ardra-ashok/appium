package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class miscallaneous  extends baseTest{

    @Test
    public void miscallaneousTest() throws MalformedURLException, URISyntaxException, InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        DeviceRotation landscape = new DeviceRotation(0,0,90);
        driver.rotate(landscape);
        DeviceRotation portrait = new DeviceRotation(0,0,0);
        driver.rotate(portrait);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
//        Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(),"WiFi settings");
        driver.setClipboardText("Test Wifi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());

        driver.pressKey(new KeyEvent((AndroidKey.ENTER)));
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent((AndroidKey.BACK)));
        driver.pressKey(new KeyEvent((AndroidKey.HOME)));
    }
}
