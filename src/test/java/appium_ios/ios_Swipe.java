package appium_ios;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ios_Swipe extends InbuiltAppBase{

    @Test
    public void IOSSwipeTest(){
        Map<String,String> params =  new HashMap<String,String>();
        params.put("bundleId","com.apple.mobileslideshow");
        driver.executeScript("mobile:launchApp",params);
    }
}
