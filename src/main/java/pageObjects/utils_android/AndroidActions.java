package pageObjects.utils_android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class AndroidActions {

    AndroidDriver driver;
    public AndroidActions(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    public void longPressAction(WebElement elem){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)elem).getId(),
                        "duration",2000));
    }
    public void scrollToAnElement(String elementText){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+elementText+"\"));"));
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
    }
    public void scrollToEnd(){
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));
        }while (canScrollMore);
    }

    public void swipeAction(WebElement element,String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "direction", direction,
                "percent", 0.10
        ));
    }

    public void dragDropDemo(WebElement element, int[] coords){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", coords[0],
                "endY", coords[1]
        ));
    }
}
