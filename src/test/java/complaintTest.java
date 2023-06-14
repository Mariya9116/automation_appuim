import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.common.appHomePage;
import pages.common.commonPage;
import pages.common.loginPage;
import pages.common.splashPage;
import pages.complaints.complaintLandingPage;
import pages.complaints.complaintListPage;
import pages.complaints.complaintRegisterPage;
import pages.utility.waitUtility;

import java.net.MalformedURLException;
import java.net.URL;

public class complaintTest {
    private static AndroidDriver driver;

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
        waitUtility.waitImplicitlyWebDriverWait(driver, 5);

        splashPage splashpage = new splashPage(driver);
        splashpage.clickOnSkipButton();
    }

    @Test
    public void complaintTest1() {
        SoftAssert softAssert = new SoftAssert();
        loginPage loginpage = new loginPage(driver);
        commonPage commonpage = new commonPage(driver);
        appHomePage apphomepage = new appHomePage(driver);
        complaintLandingPage complaintlandingpage = new complaintLandingPage(driver);
        complaintRegisterPage complaintregisterrage = new complaintRegisterPage(driver);
        complaintListPage complaintlistpage = new complaintListPage(driver);

        softAssert.assertTrue(loginpage.verifyLoginPage(), "Login Page is not visible");

        loginpage.enterUserName("mariya1234@mailinator.com");
        loginpage.enterPassword("mariya1234");
        commonpage.hideKeyboard();
        loginpage.clickOnRememberMeCheckBox();
        loginpage.clickOnLoginButton();


        softAssert.assertTrue(apphomepage.verifyLandingPage("InstiGo"), "Landing page header text is wrong");
        apphomepage.clickOnHamburgerButton();
        softAssert.assertTrue(apphomepage.verifyEmailAddressContents("mariya1234@mailinator.com"), "Login Email Address is wrong");
        apphomepage.navigateToHomePage();


        apphomepage.clickOnComplaintsButton();
        complaintlandingpage.clickOnRegisterComplaintButton();
        //Register new Complaint
        complaintregisterrage.enterComplaintName("Mariya");
        complaintregisterrage.enterComplainTitle("Mariya_ComplainTitle3");
        complaintregisterrage.enterHouseNo("25");
        commonpage.hideKeyboard();
        complaintregisterrage.clickOnHostelListView();
        complaintregisterrage.selectHostelType();
        complaintregisterrage.clickOnComplaintType();
        complaintregisterrage.selectComplaintType();
        complaintregisterrage.enterComplaintDescription("Complaint_Description_Test");
        complaintregisterrage.clickOnMakeItPrivate();
        complaintregisterrage.clickOnSubmitButton();
        //Navigate to Status
        complaintlandingpage.clickOnStatusButton();
        softAssert.assertTrue(complaintlistpage.findCreatedComplaintName("Mariya_ComplainTitle3"));
        softAssert.assertAll();
    }
}
