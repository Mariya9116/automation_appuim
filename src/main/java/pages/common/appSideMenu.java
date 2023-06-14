package pages.common;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pages.utility.waitUtility;

public class appSideMenu {
    private AndroidDriver driver;

    //*********Constructor*********
    public appSideMenu(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    //*********MobileElements by using Page Factory*********
    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/imagebt_bp")
    public MobileElement btnComplaints;

    //*********Page Methods*********
    public void clickOnComplaintsButton() {
        btnComplaints.click();
    }
}
