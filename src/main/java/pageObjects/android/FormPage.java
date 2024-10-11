package pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.utils_android.AndroidActions;

public class FormPage extends AndroidActions {
    AndroidDriver driver;
    public FormPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
    private WebElement femaleOption;
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
    private WebElement maleOption;
    @AndroidFindBy(id="android:id/text1")
    private WebElement countrySelection;
    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopBtn;


    public void setNameField(String name){
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }
    public void setGender(String gender){
        if(gender.contains("female"))
            femaleOption.click();
        else
            maleOption.click();
    }

    public void setCountry(String country){
        countrySelection.click();
        scrollToAnElement(country);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();

    }

    public void submitForm(){
        shopBtn.click();
    }




}
