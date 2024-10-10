package appium_ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ios_Swipe extends InbuiltAppBase{

    @Test
    public void IOSSwipeTest(){
        Map<String,String> params =  new HashMap<String,String>();
        params.put("bundleId","com.apple.mobileslideshow");
        Map<String,Object> scrollParams = new HashMap<>();
        driver.executeScript("mobile:launchApp",params);
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Albums Album, 6 assets.'")).click();
        List<WebElement> photos = driver.findElements(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeImage' AND name BEGINSWITH[c] 'Photo'"));

        driver.findElement(By.xpath("//XCUIElementTypeImage[1]")).click();
        Map<String,Object> swipeParams = new HashMap<>();
        swipeParams.put("direction","left");
        for(WebElement elem: photos)
            driver.executeScript("mobile:swipe",swipeParams);
    }
}
