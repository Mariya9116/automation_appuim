package pages.mess;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pages.utility.waitUtility;

public class messLandingPage {


    private AndroidDriver driver;

    //*********Constructor*********
    public messLandingPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    //*********MobileElements by using Page Factory*********
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"FEEDBACK\"]/android.widget.TextView")
    public MobileElement btnFeedBack;


    //*********Page Methods*********

    //Click on FeedBack button
    public void clickOnFeedBackButton() {
        waitUtility.waitForElementToBeClickable(driver, btnFeedBack, 3);
        btnFeedBack.click();
    }


}
