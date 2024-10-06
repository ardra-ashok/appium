package ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class mobileBrowser extends browserBaseTest {
    @Test
    public void browserTest() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//span[contains(@class,'navbar-toggler-icon')]")).click();
        driver.findElement(By.cssSelector(".nav-link[routerlink*='products']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
        Assert.assertEquals(driver.findElement(By.xpath("//a[@href='/angularAppdemo/products/3']")).getText(), "Devops");
    }

}
