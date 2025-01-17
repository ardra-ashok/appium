package appium_android;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropDemo extends  baseTest{
    @Test
    public void DragDropTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        int[] coords = {657,584};
        dragDropDemo(element,coords);
        Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText(),"Dropped!");
    }
}
