package pages.mess;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pages.utility.waitUtility;

import java.util.List;

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

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/add_feedback_spinner1")
    public MobileElement ddFeedbackMealsList;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/add_feedback_spinner2")
    public MobileElement ddFeedbackDayList;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/add_feedback_ratings")
    public MobileElement btnfeedbackRatings;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/feedback_title")
    public MobileElement txtFeedbackTitle;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/add_feedback_desc")
    public MobileElement txtFeedbackDesc;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/add_feedback_submit")
    public MobileElement btnSubmit;



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
    //Select FeedbackMealsList

    public int MealsType(String MealsType) {
        if (MealsType.equalsIgnoreCase("Breakfast")) {
            return 1;
        } else if (MealsType.equalsIgnoreCase("Lunch")) {
            return 2;
        } else if (MealsType.equalsIgnoreCase("Snacks")) {
            return 3;
        } else if (MealsType.equalsIgnoreCase("Dinner")) {
            return 4;
        }
        return -1;
    }

    public void SelectOnFeedbackMealsList(String MealsType) {
        By locator = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView["+MealsType+"]");
        ddFeedbackMealsList.findElement(By.className("android.widget.TextView")).click();
        driver.findElement(locator).click();
    }

    //Select FeedbackDayList

    public int DayType(String DayType) {
        if (DayType.equalsIgnoreCase("Sunday")) {
            return 1;
        } else if (DayType.equalsIgnoreCase("Monday")) {
            return 2;
        } else if (DayType.equalsIgnoreCase("Tuesday")) {
            return 3;
        } else if (DayType.equalsIgnoreCase("Wednesday")) {
            return 4;
        }else if (DayType.equalsIgnoreCase("Thursday")) {
            return 5;
        } else if (DayType.equalsIgnoreCase("Friday")) {
            return 6;
        } else if (DayType.equalsIgnoreCase("Saturday")) {
            return 1;
        }
        return -1;
    }
    public void SelectOnFeedbackDayList(String Day) {
        By locator = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView["+Day+"]");
        ddFeedbackDayList.findElement(By.className("android.widget.TextView")).click();
        driver.findElement(locator).click();
    }

    //Enter FeedbackTitle
    public void EnterFeedbackTitle(String FeedbackTitle) {
        txtFeedbackTitle.click();
        txtFeedbackTitle.clear();
        txtFeedbackTitle.sendKeys(FeedbackTitle);
    }
    //Enter FeedbackDesc
    public void EnterFeedbackDesc(String FeedbackDesc) {
        txtFeedbackDesc.click();
        txtFeedbackDesc.clear();
        txtFeedbackDesc.sendKeys(FeedbackDesc);
    }
    //Click on Submit button
    public void clickOnSubmit() {
        btnSubmit.click();
    }

    //Click on feedbackRatings button
    public void clickOnFeedbackRatings() {
        btnfeedbackRatings.click();
    }

    public boolean isTitleAvailableAtCreatedFeedBackInList(String complaintTitle) {
        waitUtility.waitImplicitlyWebDriverWait(driver, 6);
        Boolean isNewFeedBackAvilable = false;
        for (int i = 1; i <= 75; i++) {

            List<MobileElement> complaintList = driver.findElements(By.id("com.iitdh.sonusourav.instigo:id/mess_feedback_title"));
            for (MobileElement ListItem : complaintList) {
                if (ListItem.getText().equals(complaintTitle))
                {
                    isNewFeedBackAvilable = true;
                    break;
                }

            }
            scroll(495,1684, 486, 302);
        }
        return false;
    }

    public void scroll(int Press_X, int Press_Y, int MoveTo_X, int MoveTo_Y)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        (new TouchAction(driver)).press(PointOption.point(Press_X,Press_Y)).moveTo(PointOption.point(MoveTo_X, MoveTo_Y)).release().perform();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
