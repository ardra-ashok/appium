package appium_ios;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ios_Slider extends iosBaseTest{
    @Test
    public void IOSSliderTest(){
        WebElement slider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == 'AppElem'`]"));
        slider.sendKeys("0%");
        Assert.assertEquals(slider.getAttribute("value"),"0%");
        slider.sendKeys("1%");
        Assert.assertEquals(slider.getAttribute("value"),"100%");

    }
}
