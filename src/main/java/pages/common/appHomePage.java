package pages.common;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pages.utility.waitUtility;

import java.util.List;

public class appHomePage {

    private final AndroidDriver driver1;

    //*********Constructor*********
    public appHomePage(AndroidDriver driver) {
        this.driver1 = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver1),this);
    }

    //*********MobileElements by using Page Factory*********
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Drawer Open\"]")
    public MobileElement btnHamburger;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/nav_header_email")
    public MobileElement lblEmailAddress;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/imagebt_bp")
    public MobileElement btnComplaints;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.TextView")
    public MobileElement lblInstiGoText;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/nav_home")
    public MobileElement btnHome;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/imagebt_hr")
    public MobileElement btnMess;


    //*********Page Methods*********

    //Get Landing Page Text
    public boolean verifyLandingPage(String InstiGoTest) {
        waitUtility.waitImplicitlyWebDriverWait(driver1, 10);
        String lblInstiGoGetText = lblInstiGoText.getText();
        System.out.println(lblInstiGoGetText);
        return lblInstiGoGetText.equalsIgnoreCase(InstiGoTest);
    }


    //Tab on hamburger menu
    public void clickOnHamburgerButton() {
        btnHamburger.click();
    }


    //Get Address contents
    public boolean verifyEmailAddressContents(String EmailAddress) {
        waitUtility.waitImplicitlyWebDriverWait(driver1, 3);
        String lblEmailAddressText = lblEmailAddress.getText();
        System.out.println(lblEmailAddressText);
        return lblEmailAddressText.equalsIgnoreCase(EmailAddress);
    }


    //Click on Complaints button
    public void clickOnComplaintsButton() {
        waitUtility.waitImplicitlyWebDriverWait(driver1, 5);
        btnComplaints.click();
    }

    //Click on Home
    public void navigateToHomePage() {
        waitUtility.waitImplicitlyWebDriverWait(driver1, 5);
        btnHome.click();
        waitUtility.waitImplicitlyWebDriverWait(driver1, 7);
    }

    //Click on btnMess button
    public void clickOnMessButton() {
        waitUtility.waitImplicitlyWebDriverWait(driver1, 5);
        btnMess.click();
    }


}