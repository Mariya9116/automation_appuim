package pages.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class splashPage {

    public AppiumDriver driver1;

    public splashPage(AppiumDriver driver) {
        this.driver1 = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    //*********MobileElements by using Page Factory*********
    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/btn_skip")
    public MobileElement btnSkip;


    //*********Page Methods*********
    public void clickOnSkipButton() throws InterruptedException {
        Thread.sleep(5000);
        btnSkip.click();
    }
}
