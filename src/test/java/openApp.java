import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class openApp {

    private static AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUpInstiGo() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "AOSP on IA Emulator");
        desiredCapabilities.setCapability("appium:platformVersion", "9");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:appPackage", "com.iitdh.sonusourav.instigo");
        desiredCapabilities.setCapability("appium:appActivity", "com.iitdh.sonusourav.instigo.Account.SplashActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

//        ImplicitWait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        ExplicitWait
//        wait = new WebDriverWait(driver, 10);
//        By btnSkip = By.id("com.iitdh.sonusourav.instigo:id/btn_skip");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSkip));
//        driver.findElement(btnSkip).click();

        //Click on Skip button
        MobileElement btnSkip = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/btn_skip");
        btnSkip.click();
    }

    @BeforeMethod
    public void validateInstiGoLogin() throws MalformedURLException {
        SoftAssert softAssert = new SoftAssert();
        //Verify the Navigate InstiGo Login page

        //Enter Username or Email
        String UserEmailAddress = "mariya1234@mailinator.com";
        String UserPassword = "mariya1234";
        MobileElement txtUsername = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/ed_user_name");
        txtUsername.click();
        txtUsername.clear();
        txtUsername.sendKeys(UserEmailAddress);

        //Enter Password
        MobileElement txtPassword = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/ed_password");
        softAssert.assertEquals(txtUsername, UserEmailAddress, "Enter email is wrong");
        txtPassword.click();
        txtPassword.clear();
        txtPassword.sendKeys(UserPassword);

        //Hide Keyboard
        driver.hideKeyboard();

        //Tab in remember me check box
        MobileElement chkboxRememberMe = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/remember_me_chk_box");
        chkboxRememberMe.click();

        //Tab on login button
        softAssert.assertEquals(txtPassword, UserPassword, "Enter password is wrong");
        MobileElement btnLogin = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/button_login");
        btnLogin.click();

        //Wait ExplicitWait until Hamburger button appear
        wait = new WebDriverWait(driver, 15);
        By btnnHamburger = By.id("com.iitdh.sonusourav.instigo:id/imagebt_hr");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnnHamburger));

        //Verify the landing page contents are available
        List<MobileElement> lblInstiGo = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
        lblInstiGo.get(0).getText().equalsIgnoreCase("InstiGo");
        //String text0 = lblInstiGo.get(0).getText();
        //String text1 = lblInstiGo.get(1).getText();
        softAssert.assertEquals(lblInstiGo.get(0).getText(), "InstiGo", "Landing page header text is wrong");

        //Tab on hamburger menu
        MobileElement btnHamburger = (MobileElement) driver.findElementByAccessibilityId("Drawer Open");
        btnHamburger.click();

        //Verify the Email Address contents is available
        //Wait ExplicitWait until btnStatus button appear
//        wait = new WebDriverWait(driver, 15);
//        By lblEmailAddressLocator = By.id("com.iitdh.sonusourav.instigo:id/complain_username");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(lblEmailAddressLocator));
//        MobileElement lblEmailAddress = (MobileElement) driver.findElement(lblEmailAddressLocator);
//        lblEmailAddress.getText().equalsIgnoreCase(UserEmailAddress);
//        System.out.println(lblEmailAddress.getText());
//        softAssert.assertEquals(lblEmailAddress, UserEmailAddress, "Email ID is wrong");
//        softAssert.assertAll();

//        //Click on Home
        MobileElement btnHome = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/nav_home");
        btnHome.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }

    @Test(priority = 1)
    public void verifyRegisterComplaints() throws MalformedURLException {
        SoftAssert softAssert = new SoftAssert();

        //Click on Complaints button
//        MobileElement btnComplaints = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/nav_complaint");
//        btnComplaints.click();

        MobileElement btnComplaints = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/imagebt_bp");
        btnComplaints.click();

        //Click on Register Complaint button
        MobileElement btnRegisterComplaint = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/maintenance_register");
        btnRegisterComplaint.click();

        //Wait ExplicitWait until txtName input filed appear
        wait = new WebDriverWait(driver, 15);
        By txtNameLocator = By.id("com.iitdh.sonusourav.instigo:id/complain_username");
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtNameLocator));

        //Fill ADD COMPLAINT
        //Enter Name
        MobileElement txtName = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/complain_username");
        txtName.click();
        txtName.clear();
        txtName.sendKeys("Mariya");

        //Enter Complain Title
        MobileElement txtComplainTitle = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/complain_title");
        txtComplainTitle.click();
        txtComplainTitle.clear();
        txtComplainTitle.sendKeys("Mariya_ComplainTitle");

        //Enter House no.
        MobileElement txtHouseNo = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/complain_house_no");
        txtHouseNo.click();
        txtHouseNo.clear();
        txtHouseNo.sendKeys("25");

        //Hide Keyboard
        driver.hideKeyboard();

        //Click on HostelListView Drop Down
        MobileElement ddHostelListView = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/add_complaint_hostel");
        ddHostelListView.click();

        //Select HostelType
        MobileElement lblHostelType = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
        lblHostelType.click();

        //Click on ComplaintType Drop Down
        MobileElement ddComplaintType = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/add_complaint_type");
        ddComplaintType.click();

        //Select ComplaintType
        MobileElement lblComplaintType = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
        lblComplaintType.click();

        //Enter ComplaintDescription
        MobileElement txtComplaintDescription = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/et_complain_desc");
        txtComplaintDescription.sendKeys("Complaint_Description_Test");

        //Tab in Make it private me check box
        MobileElement chkboxMakeItPrivate = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/complain_is_private");
        chkboxMakeItPrivate.click();

        //Click on submit button
        MobileElement btnSubmit = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/complain_submit");
        btnSubmit.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Click on Back
//        MobileElement btnBack = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
//        btnBack.click();

        //Wait ExplicitWait until Status button appear
        wait = new WebDriverWait(driver, 15);
        By btnStatusLocator = By.id("com.iitdh.sonusourav.instigo:id/maintenance_status");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnStatusLocator));

        //Click on Status button
        MobileElement btnStatus = (MobileElement) driver.findElement(btnStatusLocator);
        btnStatus.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        By txtComplaintNameLocator = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView[3]");
        for (int i = 1; i <= 30; i++) {

            List<MobileElement> complaintList = driver.findElements(By.id("com.iitdh.sonusourav.instigo:id/status_complain_title"));
            for (MobileElement ListItem : complaintList) {
                String complainname = ListItem.getText();
            }
            (new TouchAction(driver)).press(PointOption.point(543, 1883)).moveTo(PointOption.point(543, 642)).release().perform();
            System.out.println("Scroll" + i);
        }
    }

    //Verify the Complaint Name contents are available


    // softAssert.assertAll();


    @AfterMethod(alwaysRun = true)
    public void anotationTest5()
    {
        System.out.println("Test Complete");
    }

    public void tearDown() {
        driver.quit();
    }

}
