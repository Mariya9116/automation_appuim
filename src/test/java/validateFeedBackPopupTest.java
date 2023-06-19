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
        driverSetupInstiGo();
    }
    @Test
    public void validateFeedBackPopupTest1() {
        SoftAssert softAssert = new SoftAssert();
        appHomePage apphomepage = new appHomePage(driver);
        loginPage loginpage = new loginPage(driver);
        commonPage commonpage = new commonPage(driver);
        messFeedBack messfeedback = new messFeedBack(driver);
        messLandingPage messlandingpage = new messLandingPage(driver);

        softAssert.assertTrue(loginpage.verifyLoginPage(), "Login Page is not visible");

        loginpage.enterUserName("mariya1234@mailinator.com");
        loginpage.enterPassword("mariya1234");
        commonpage.hideKeyboard();
        loginpage.clickOnRememberMeCheckBox();
        loginpage.clickOnLoginButton();

        softAssert.assertTrue(apphomepage.verifyLandingPage("InstiGo"), "Landing page header text is wrong");

        apphomepage.clickOnMessButton();
        messlandingpage.clickOnFeedBackButton();
        softAssert.assertTrue(messfeedback.VerifyPlusIconEnable(), "Plus icon not enable");
        messfeedback.clickOnbtnPlusIcon();
        softAssert.assertTrue(messfeedback.VerifyFeedbackPopupHeader(), "FeedbackPopup Header is not Display");

        softAssert.assertAll();
    }

    @AfterMethod
    public void closeDriver()
    {
        driver.quit();
    }
}
