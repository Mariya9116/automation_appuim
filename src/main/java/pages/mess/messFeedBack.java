package pages.mess;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pages.utility.waitUtility;

public class messFeedBack {

    private AndroidDriver driver;

    //*********Constructor*********
    public messFeedBack(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    //*********MobileElements by using Page Factory*********
    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/mess_feedback_fab")
    public MobileElement btnPlusIcon;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/add_feedback_title")
    public MobileElement lblPopupheader;


    //*********Page Methods*********

    //Click on btnPlusIcon button
    public void clickOnbtnPlusIcon() {
        waitUtility.waitForElementToBeClickable(driver, btnPlusIcon, 3);
        btnPlusIcon.click();
    }

    //Verify the btnPlusIcon Enable

    public boolean VerifyPlusIconEnable() {
        boolean isPlusIconEnabled = btnPlusIcon.isEnabled();
        return isPlusIconEnabled;
    }

    //Verify the Feedback Heading
    public boolean VerifyFeedbackPopupHeader() {
        boolean isPopupheaderVisible = lblPopupheader.getText().equalsIgnoreCase("Feedback");
        return isPopupheaderVisible;

    }
}
