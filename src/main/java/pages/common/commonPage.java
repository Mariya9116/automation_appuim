package pages.common;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class commonPage {
    private AndroidDriver driver;

    //*********Constructor*********
    public commonPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    //*********MobileElements by using Page Factory*********

    //*********Page Methods*********

    //Hide Keyboard
    public void hideKeyboard() {
        driver.hideKeyboard();
    }
}
