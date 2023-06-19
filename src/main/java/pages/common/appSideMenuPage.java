package pages.common;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


import java.util.Arrays;
import java.util.List;


public class appSideMenuPage {
    private AndroidDriver driver;

    //*********Constructor*********
    public appSideMenuPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    //*********MobileElements by using Page Factory*********

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/nav_home")
    public MobileElement btnHome;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/nav_mess")
    public MobileElement btnMess;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/nav_complaint")
    public MobileElement btnComplaints;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/nav_resource")
    public MobileElement btnResource;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/nav_council")
    public MobileElement btnCouncil;

    //*********Page Methods*********
//    public boolean validateSideMenuItemsVisibility() {
//        waitUtility.waitForElementToBeClickable(driver, btnHome, 3);
//        boolean isHomeVisible = btnHome.isDisplayed();
//        boolean isMessVisible = btnMess.isDisplayed();
//        boolean isComplaintsVisible = btnComplaints.isDisplayed();
//        boolean isResourceVisible = btnResource.isDisplayed();
//        boolean isCouncilVisible = btnCouncil.isDisplayed();
//
//        if (!isHomeVisible || !isMessVisible || !isComplaintsVisible || !isResourceVisible || !isCouncilVisible) {
//            return false;
//        }
//
//        return true;
//    }

    //Validate Side Menu Items Visibility Using List
    public boolean validateSideMenuItemsVisibility() {

        List<MobileElement> elementList = Arrays.asList(btnHome, btnMess, btnComplaints, btnResource, btnCouncil);
        for (MobileElement element : elementList) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean validateSideMenuHomeItem() {
        boolean isHomeTextVisible = btnHome.findElement(By.className("android.widget.CheckedTextView")).getText().equalsIgnoreCase("Home");
        return isHomeTextVisible;
    }

    public boolean validateSideMessHomeItem() {
        boolean isMessTextVisible = btnMess.findElement(By.className("android.widget.CheckedTextView")).getText().equalsIgnoreCase("Mess");
        return isMessTextVisible;
    }

    public boolean validateSideMenuComplaintsItem() {
        boolean isComplaintsTextVisible = btnComplaints.findElement(By.className("android.widget.CheckedTextView")).getText().equalsIgnoreCase("Home");
        return isComplaintsTextVisible;
    }

    public boolean validateSideMenuResourceItem() {
        boolean isResourceTextVisible = btnResource.findElement(By.className("android.widget.CheckedTextView")).getText().equalsIgnoreCase("Resource");
        return isResourceTextVisible;
    }

    public boolean validateSideMenuCouncilItem() {
        boolean isCouncilTextVisible = btnCouncil.findElement(By.className("android.widget.CheckedTextView")).getText().equalsIgnoreCase("Student Council");
        return isCouncilTextVisible;
    }





}
