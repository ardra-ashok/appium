package appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class appProperties extends baseTest{
    @Test
    public void appPropertiesTest(){
//        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
//        driver.startActivity(activity);
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
        driver.findElement(By.id("android:id/checkbox")).click();
        DeviceRotation landscape = new DeviceRotation(0,0,90);
        driver.rotate(landscape);
        DeviceRotation portrait = new DeviceRotation(0,0,0);
        driver.rotate(portrait);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(),"WiFi settings");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.setClipboardText("Test Wifi");
        WebElement inputField = driver.findElement(By.id("android:id/edit"));
        wait.until(ExpectedConditions.elementToBeClickable(inputField));
        inputField.clear();
        inputField.sendKeys(driver.getClipboardText());

//        driver.pressKey(new KeyEvent((AndroidKey.ENTER)));
        driver.hideKeyboard();
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent((AndroidKey.BACK)));
        driver.pressKey(new KeyEvent((AndroidKey.HOME)));
    }

}
