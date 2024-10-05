package ecommerce;

import appium.baseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ecommerce extends baseTest {

    @Test
    public void fillForm() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")).sendKeys("Test Name");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Antarctica\"]")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(3000);
    }

}
