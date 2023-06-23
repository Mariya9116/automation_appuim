import com.aventstack.extentreports.Status;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.common.appHomePage;
import pages.common.commonPage;
import pages.common.loginPage;

import java.io.IOException;
import java.net.MalformedURLException;


public class validateUserLoginWithCorrectLoginIDTest extends  TestBase{

    @BeforeMethod
    public void beforeEachTest() throws IOException, InterruptedException, ParseException {
        test = extend.createTest("Test 01 : driverSetupInstiGo");
        driverSetupInstiGo();
        test.log(Status.INFO,"User successfully launch the application");
    }
    @Test
    public void loginTest1() {
        test = extend.createTest("Test 02 : login Test");

        SoftAssert softAssert = new SoftAssert();
        loginPage loginpage = new loginPage(driver);
        commonPage commonpage = new commonPage(driver);

        softAssert.assertTrue(loginpage.verifyLoginPage(), "Login Page is not visible");
        test.log(Status.INFO,"User able to view Login Page");

        loginpage.enterUserName("mariya1234@mailinator.com");
        loginpage.enterPassword("mariya1234");
        commonpage.hideKeyboard();
        loginpage.clickOnRememberMeCheckBox();
        loginpage.clickOnLoginButton();
        softAssert.assertAll();
        test.log(Status.INFO,"User successfully login to the application");

    }
    @Test
    public void validateUserLoginWithCorrectLoginID1() throws InterruptedException {
        test = extend.createTest("Test 02 : Validate user login With Correct Login ID Test");
        SoftAssert softAssert = new SoftAssert();
        appHomePage apphomepage = new appHomePage(driver);
        loginPage loginpage = new loginPage(driver);
        commonPage commonpage = new commonPage(driver);

        softAssert.assertTrue(loginpage.verifyLoginPage(), "Login Page is not visible");
        test.log(Status.INFO,"User able to view Login Page");

        loginpage.enterUserName("mariya1234@mailinator.com");
        loginpage.enterPassword("mariya1234");
        commonpage.hideKeyboard();
        loginpage.clickOnRememberMeCheckBox();
        loginpage.clickOnLoginButton();

        softAssert.assertTrue(apphomepage.verifyLandingPage("InstiGo"), "Landing page header text is wrong");
        test.log(Status.INFO,"User successfully log in to the application");

        apphomepage.clickOnHamburgerButton();
        softAssert.assertTrue(apphomepage.verifyEmailAddressContents("mariya1234@mailinator.com"), "Login Email Address is wrong");
        test.log(Status.INFO,"User log with correct log ID");
        softAssert.assertAll();

    }

    @AfterMethod
    public void closeDriver()
    {
        driver.quit();
    }
}
