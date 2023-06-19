import com.aventstack.extentreports.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.common.appHomePage;
import pages.common.commonPage;
import pages.common.loginPage;
import pages.complaints.complaintLandingPage;
import pages.complaints.complaintListPage;
import pages.complaints.complaintRegisterPage;

import java.net.MalformedURLException;

public class userCreateNewComplaintTest extends  TestBase{

    @BeforeMethod
    public void beforeEachTest() throws MalformedURLException, InterruptedException {
        test = extend.createTest("Test 01 : driverSetupInstiGo");
        driverSetupInstiGo();
        test.log(Status.INFO,"User successfully launch the application");
    }

    @Test
    public void userCreateNewComplaintTest1() {
        test = extend.createTest("Test 02 : User Create a new Complaint Test");
        SoftAssert softAssert = new SoftAssert();
        loginPage loginpage = new loginPage(driver);
        commonPage commonpage = new commonPage(driver);
        appHomePage apphomepage = new appHomePage(driver);
        complaintLandingPage complaintlandingpage = new complaintLandingPage(driver);
        complaintRegisterPage complaintregisterrage = new complaintRegisterPage(driver);
        complaintListPage complaintlistpage = new complaintListPage(driver);

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
        test.log(Status.INFO,"User successfully navigate to main menu");
        softAssert.assertTrue(apphomepage.verifyEmailAddressContents("mariya1234@mailinator.com"), "Login Email Address is wrong");
        test.log(Status.INFO,"User log with correct log ID");
        apphomepage.navigateToHomePage();
        test.log(Status.INFO,"User successfully navigate to Home Page");

        apphomepage.clickOnComplaintsButton();
        test.log(Status.INFO,"User successfully navigate to Complaints Page");
        complaintlandingpage.clickOnRegisterComplaintButton();
        test.log(Status.INFO,"User successfully navigate to Register Page");
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
        test.log(Status.INFO,"User successfully submit to Complain form");
        //Navigate to Status
        complaintlandingpage.clickOnStatusButton();
        softAssert.assertTrue(complaintlistpage.findCreatedComplaintName("Mariya_ComplainTitle3"));
        test.log(Status.INFO,"User successfully navigate to Status Page");
        softAssert.assertAll();
    }

    @AfterMethod
    public void closeDriver()
    {
        driver.quit();
    }
}
