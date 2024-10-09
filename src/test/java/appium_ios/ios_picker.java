package appium_ios;

import io.appium.java_client.AppiumBy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ios_picker extends iosBaseTest {
    @Test
    public void iosPicker_test(){
        driver.findElement(AppiumBy.id("Picker View")).click();
        driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("80");
        driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("220");
        driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Blue color component value'")).sendKeys("105");
        Assert.assertEquals(driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).getText(),"105");
    }

}
