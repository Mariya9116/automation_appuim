package pages.complaints;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pages.utility.waitUtility;

public class complaintLandingPage {

    private AndroidDriver driver;

    //*********Constructor*********
    public complaintLandingPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    //*********MobileElements by using Page Factory*********
    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/maintenance_register")
    public MobileElement btnRegisterComplaint;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/maintenance_status")
    public MobileElement btnStatus;


    //*********Page Methods*********

    //Click on Register Complaint button
    public void clickOnRegisterComplaintButton() {
        waitUtility.waitForElementToBeClickable(driver, btnRegisterComplaint, 3);
        btnRegisterComplaint.click();
    }

    //Click on Status button
    public void clickOnStatusButton() {
        waitUtility.waitForElementToBeClickable(driver, btnStatus, 4);
        btnStatus.click();
    }


}
