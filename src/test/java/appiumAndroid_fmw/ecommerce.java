package appiumAndroid_fmw;

import appium_android.baseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.android.FormPage;

import java.time.Duration;
import java.util.List;

public class ecommerce extends baseTest {
    private static final FormPage formPage = new FormPage(driver);
    @Test
    public void fillForm() {
        formPage.setNameField("Test name");
        formPage.setGender("female");
        formPage.setCountry("Argentina");
        formPage.submitForm();


//        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name"),"Please enter your name");
        scrollToAnElement("Jordan 6 Rings");
        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for (int i = 0; i < productCount; i++) {
            if (driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText().equals("Jordan 6 Rings"))
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
        Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText(), "Jordan 6 Rings");
    }
    @Test
    public void verifyCartTotal() throws InterruptedException {
        formPage.setNameField("Test name");
        formPage.setGender("female");
        formPage.setCountry("Argentina");

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int productCount = productPrices.size();
        double total = 0;
        for(int i=0;i<productCount;i++){
            total+= Double.parseDouble(productPrices.get(i).getText().replace("$",""));
        }
        double displaySum = Double.parseDouble(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().replace("$",""));
        Assert.assertEquals(displaySum,total);
        longPressAction(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
        Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText(),"Terms Of Conditions");
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
    }


}