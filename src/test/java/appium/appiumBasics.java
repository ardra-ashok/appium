package appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;


public class appiumBasics extends baseTest{
    @Test
    public void appiumTest() throws MalformedURLException, URISyntaxException {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(),"WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("test wifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }

}


