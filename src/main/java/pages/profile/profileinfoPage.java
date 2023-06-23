package pages.profile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.events.Event;
import pages.utility.waitUtility;

import java.security.Key;

public class profileinfoPage {

    private AndroidDriver driver2;
    public profileinfoPage(AndroidDriver driver) {
        this.driver2 = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //*********MobileElements by using Page Factory*********

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/pro_edit_name")
    public MobileElement txtProEditName;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/pro_edit_branch")
    public MobileElement txtProEditBranch;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/til3")
    public MobileElement txtProEditCurrentYear;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/pro_edit_mob")
    public MobileElement txtProEditMob;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/pro_edit_dob")
    public MobileElement txtProEditDOB;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"15 June 2023\"]")
    public MobileElement lblDate;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement btnOk;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/pro_edit_gender")
    public MobileElement ddProEditGender;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
    public MobileElement ddOptionMale;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    public MobileElement ddOptionFemale;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")
    public MobileElement ddOptionOthers;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/pro_edit_hostel")
    public MobileElement ddProEditHostel;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/pro_edit_save")
    public MobileElement btnProEditSave;




    //*********Page Methods*********

    //Verify Profile Info Page
    public boolean verifyProfileInfoPage() {
        return txtProEditName.isDisplayed();
    }


    //Enter Profile Name
    public void enterProfileName(String ProfileName) throws InterruptedException {
        Thread.sleep(3000);
        txtProEditName.click();
        txtProEditName.clear();
        txtProEditName.sendKeys(ProfileName);
    }

    //Enter Profile Branch
    public void enterProfileBranch(String ProfileBranch) {
        txtProEditBranch.click();
        txtProEditBranch.clear();
        txtProEditBranch.sendKeys(ProfileBranch);
    }

    //Enter Profile CurrentYear
    public void enterProfileCurrentYear(String ProfileCurrentYear) {
        txtProEditCurrentYear.click();
        txtProEditCurrentYear.clear();
        txtProEditCurrentYear.sendKeys(ProfileCurrentYear);
    }

    //Enter Profile Mob
    public void enterProfileMob(String ProfileCurrentYearMob) {
        txtProEditMob.click();
        txtProEditMob.clear();
        txtProEditMob.sendKeys(ProfileCurrentYearMob);
    }

    //click on Profile DOB
    public void clickOnProfileDOB() {
        txtProEditDOB.click();
    }

    //click on Profile DOB Date
    public void clickOnProfileDOBDate() {
        lblDate.click();
    }

    //click on OK button
    public void clickOnOkBtn() {
        btnOk.click();
    }


    //Click Profile Gender
    public void clickOnProfileGender() {
        ddProEditGender.click();
    }

    //Select Gender
    public void SelectGender(String Gender) {
        if (Gender.equalsIgnoreCase("Male")) {
            ddOptionMale.click();
        } else if (Gender.equalsIgnoreCase("Female")) {
            ddOptionFemale.click();
        } else if (Gender.equalsIgnoreCase("Others")) {
            ddOptionOthers.click();
        }
    }


    //Click Profile Hostel
    public void clickOnProfileHostel() {
        ddProEditHostel.click();
    }

    //Select Hostel
    public void SelectHostel(int Hostel) {
        By locator = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView["+Hostel+"]");
       driver2.findElement(locator).click();
    }

    public int SelectHostelType(String HostelType) {
        if (HostelType.equalsIgnoreCase("Freshers Hostel")) {
            return 1;
        } else if (HostelType.equalsIgnoreCase("Hostel 1")) {
            return 2;
        } else if (HostelType.equalsIgnoreCase("Hostel 2")) {
            return 3;
        } else if (HostelType.equalsIgnoreCase("Hostel 3")) {
            return 4;
        }
        else if (HostelType.equalsIgnoreCase("Hostel 4")) {
            return 5;
        }
        else if (HostelType.equalsIgnoreCase("Hostel 5")) {
            return 6;
        }
        else if (HostelType.equalsIgnoreCase("Hostel 6")) {
            return 7;
        }
        else if (HostelType.equalsIgnoreCase("Hostel 7")) {
            return 8;
        }
        else if (HostelType.equalsIgnoreCase("Hostel 8")) {
            return 9;
        }
        else if (HostelType.equalsIgnoreCase("Hostel 9")) {
            return 10;
        }
        else if (HostelType.equalsIgnoreCase("Hostel 10")) {
            return 11;
        }
        return 0;
    }
    //Click on Save
    public void clickOnProEditSave() {
        btnProEditSave.click();
    }
}
