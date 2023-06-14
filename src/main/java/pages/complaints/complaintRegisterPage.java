package pages.complaints;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class complaintRegisterPage {

    private AndroidDriver driver;

    //*********Constructor*********
    public complaintRegisterPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    //*********MobileElements by using Page Factory*********
    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/complain_username")
    public MobileElement txtName;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/complain_title")
    public MobileElement txtComplainTitle;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/complain_house_no")
    public MobileElement txtHouseNo;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/add_complaint_hostel")
    public MobileElement ddHostelListView;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")
    public MobileElement lblHostelType;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/add_complaint_type")
    public MobileElement ddComplaintType;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")
    public MobileElement lblComplaintType;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/et_complain_desc")
    public MobileElement txtComplaintDescription;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/complain_is_private")
    public MobileElement chkboxMakeItPrivate;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/complain_submit")
    public MobileElement btnSubmit;

    //*********Page Methods*********

    //Fill ADD COMPLAINT
    //Enter Name
    public void enterComplaintName(String ComplaintName) {
        txtName.click();
        txtName.clear();
        txtName.sendKeys(ComplaintName);
    }

    //Enter Complain Title
    public void enterComplainTitle(String ComplainTitle) {
        txtComplainTitle.click();
        txtComplainTitle.clear();
        txtComplainTitle.sendKeys(ComplainTitle);
    }

    //Enter House no.
    public void enterHouseNo(String HouseNo) {
        txtHouseNo.click();
        txtHouseNo.clear();
        txtHouseNo.sendKeys(HouseNo);
    }

    //Click on HostelListView Drop Down
    public void clickOnHostelListView() {
        ddHostelListView.click();
    }

    //Select HostelType
    public void selectHostelType() {
        lblHostelType.click();
    }

    //Click on ComplaintType Drop Down
    public void clickOnComplaintType() {
        ddComplaintType.click();
    }

    //Select ComplaintType
    public void selectComplaintType() {
        lblComplaintType.click();
    }

    //Enter ComplaintDescription
    public void enterComplaintDescription(String ComplaintDescription) {
        txtComplaintDescription.sendKeys(ComplaintDescription);
    }

    //Tab in Make it private me check box
    public void clickOnMakeItPrivate() {
        chkboxMakeItPrivate.click();
    }

    //Click on submit button
    public void clickOnSubmitButton() {
        btnSubmit.click();
    }

}
