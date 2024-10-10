package appium_ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class InbuiltAppBase{
    public AppiumDriverLocalService service;
    public IOSDriver driver;
    @BeforeClass
    public void configureAppium() throws MalformedURLException {

        File logDir = new File("/Users/aashok/IdeaProjects/appium_learnings/appium_logs");
        if (!logDir.exists()) {
            logDir.mkdirs();
        }

        File logFile = new File(logDir, "appium-logfile.log");
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .withLogFile(logFile)
                .usingPort(4725)
                .build();
        service.start();
        XCUITestOptions options = new XCUITestOptions();

        options.setDeviceName("iPhone 16");
//        options.setApp("//Users//aashok//IdeaProjects//appium_learnings//src//test//resources//UIKitCatalog.app");
        options.setPlatformVersion("18.0");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));
        driver = new IOSDriver(new URL("http://127.0.0.1:4725"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }

    public void scrollToEnd(Map<String,Object> params){
        driver.executeScript("mobile:scroll",params);
    }
    public void scrollToElement(Map<String, Object> scrollParams){
        driver.executeScript("mobile:scroll", scrollParams);
    }
}
