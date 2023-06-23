package pages.profile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class profilePage {

    private AndroidDriver driver2;

    //*********Constructor*********
    public profilePage(AndroidDriver driver) {
        this.driver2 = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //*********MobileElements by using Page Factory*********
    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/profile_name")
    public MobileElement lblProfileName;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/profile_edit")
    public MobileElement btnProfileEdit;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/alertTitle")
    public MobileElement lblProfileUpdatePopupHeader;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement btnPROFILEPIC;
    @AndroidFindBy(id = "android:id/button2")
    public MobileElement btnPROFILEINFO;
    @AndroidFindBy(id = "android:id/button3")
    public MobileElement btnCOVERPIC;


    //*********Page Methods*********

    //Verify Profile Page
    public boolean verifyProfilePage() {
        return lblProfileName.isDisplayed();

    }

    //Verify Profile Name
    public boolean verifyProfileName(String Name) {
        return lblProfileName.getText().equalsIgnoreCase(Name);

    }

    //click on Profile Edit button
    public void clickOnProfileEditBtn() {
        btnProfileEdit.click();
    }
    //Verify Profile Update Popup
    public boolean verifyProfileUpdatePopup() {
        return lblProfileUpdatePopupHeader.isDisplayed();

    }

    public void SelectUpdateType(String UpdateType) {
        if (UpdateType.equalsIgnoreCase("PROFILE PIC")) {
            clickOnPROFILEPIC();
        } else if (UpdateType.equalsIgnoreCase("PROFILE INFO")) {
            clickOnPROFILEINFO();
        } else if (UpdateType.equalsIgnoreCase("COVER PIC")) {
            clickOnCOVERPIC();
        }
    }

    //Click on PROFILE PIC
    public void clickOnPROFILEPIC() {
        btnPROFILEPIC.click();
    }

    //Click on PROFILE INFO
    public void clickOnPROFILEINFO() {
        btnPROFILEINFO.click();

    }

    //Click on COVER PIC
    public void clickOnCOVERPIC() {
        btnCOVERPIC.click();
    }


}