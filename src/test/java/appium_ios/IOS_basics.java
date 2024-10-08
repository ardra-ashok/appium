package appium_ios;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IOS_basics extends iosBaseTest {
    @Test
    public void ios_basicTest(){
//      Selectors -  xpath, className, IOS , IOSClassChain, IOSPredicateString, accessibilityId , id
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
//        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hey there!");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
//          // [c] both cases
//        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value== 'Confirm / Cancel'")).click();
//        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'm / Cancel'")).click();
        System.out.println(driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'")).getText());
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();
    }
}
