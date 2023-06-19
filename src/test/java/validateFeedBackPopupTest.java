import com.aventstack.extentreports.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.common.*;
import pages.mess.messFeedBack;
import pages.mess.messLandingPage;

import java.net.MalformedURLException;

public class validateFeedBackPopupTest extends  TestBase{

    @BeforeMethod
    public void beforeEachTest() throws MalformedURLException, InterruptedException {
        test = extend.createTest("Test 01 : driverSetupInstiGo");
        driverSetupInstiGo();
        test.log(Status.INFO,"User successfully launch the application");
    }
    @Test
    public void validateFeedBackPopupTest1() {
        test = extend.createTest("Test 02 : User validate FeedBack Popup");
        SoftAssert softAssert = new SoftAssert();
        appHomePage apphomepage = new appHomePage(driver);
        loginPage loginpage = new loginPage(driver);
        commonPage commonpage = new commonPage(driver);
        messFeedBack messfeedback = new messFeedBack(driver);
        messLandingPage messlandingpage = new messLandingPage(driver);

        softAssert.assertTrue(loginpage.verifyLoginPage(), "Login Page is not visible");
        test.log(Status.INFO,"User able to view Login Page");

        loginpage.enterUserName("mariya1234@mailinator.com");
        loginpage.enterPassword("mariya1234");
        commonpage.hideKeyboard();
        loginpage.clickOnRememberMeCheckBox();
        loginpage.clickOnLoginButton();

        softAssert.assertTrue(apphomepage.verifyLandingPage("InstiGo"), "Landing page header text is wrong");
        test.log(Status.INFO,"User successfully log in to the application");

        apphomepage.clickOnMessButton();
        test.log(Status.INFO,"User successfully navigate to Mess page");
        messlandingpage.clickOnFeedBackButton();
        softAssert.assertTrue(messfeedback.VerifyPlusIconEnable(), "Plus icon not enable");
        messfeedback.clickOnbtnPlusIcon();
        softAssert.assertTrue(messfeedback.VerifyFeedbackPopupHeader(), "FeedbackPopup Header is not Display");
        test.log(Status.INFO,"User can see Feedback Popup");
        softAssert.assertAll();
    }

    @AfterMethod
    public void closeDriver()
    {
        driver.quit();
    }
}
