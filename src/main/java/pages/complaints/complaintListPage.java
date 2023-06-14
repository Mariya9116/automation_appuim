package pages.complaints;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pages.utility.waitUtility;

import java.util.List;

public class complaintListPage {

    private AndroidDriver driver;

    //*********Constructor*********
    public complaintListPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    //*********MobileElements by using Page Factory*********
    @AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView[3]")
    public MobileBy txtComplaintNameLocator;


    //*********Page Methods*********
    public boolean findCreatedComplaintName(String complaintTitle) {
        waitUtility.waitImplicitlyWebDriverWait(driver, 6);
        for (int i = 1; i <= 30; i++) {

            List<MobileElement> complaintList = driver.findElements(By.id("com.iitdh.sonusourav.instigo:id/status_complain_title"));
            for (MobileElement ListItem : complaintList) {
                boolean ComplaintTitle = ListItem.getText().equalsIgnoreCase(complaintTitle);
                return ComplaintTitle;
            }
            (new TouchAction(driver)).press(PointOption.point(543, 1883)).moveTo(PointOption.point(543, 642)).release().perform();
            System.out.println("Scroll" + i);
    }
        return false;
    }
}
