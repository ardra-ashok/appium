package ecommerce;

import appium.baseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ecommerce extends baseTest {

    @Test
    public void fillForm() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")).sendKeys("Test Name");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        scrollToAnElement("Argentina");
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Antarctica\"]")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(3000);
//        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name"),"Please enter your name");
        scrollToAnElement("Jordan 6 Rings");
        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for(int i=0;i<productCount;i++){
            if(driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText().equals("Jordan 6 Rings"))
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);
    }


}