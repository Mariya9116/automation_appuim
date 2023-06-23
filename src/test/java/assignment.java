import com.aventstack.extentreports.Status;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.common.appHomePage;
import pages.common.appSideMenuPage;
import pages.common.commonPage;
import pages.common.loginPage;
import pages.mess.messFeedBack;
import pages.mess.messLandingPage;
import pages.profile.profilePage;
import pages.profile.profileinfoPage;

import java.io.IOException;

public class assignment extends  TestBase{
    @BeforeMethod

    public void beforeEachTest() throws IOException, InterruptedException, ParseException {
        test = extend.createTest("Driver Setup InstiGo");
        driverSetupInstiGo();
        test.log(Status.INFO,"User successfully launch the application");
    }

    @Test
    public void Test_01() {
        test = extend.createTest("Start of Test 01");
        test = extend.createTest("Test 01 : Validate login page contains");
        SoftAssert softAssert = new SoftAssert();
        loginPage loginpage = new loginPage(driver);

        softAssert.assertTrue(loginpage.verifyLoginPage(), "Login Page is not visible");
        test.log(Status.INFO,"User able to view Login Page");
        softAssert.assertTrue(loginpage.verifyUserNameField(), "UserName Field is not visible");
        softAssert.assertTrue(loginpage.verifyPasswordField(), "Password Field is not visible");
        softAssert.assertTrue(loginpage.verifyLoginButton(), "Login Button is not Enable");
        softAssert.assertAll();

        test = extend.createTest("End of Test 01");
    }
    @Test
    public void Test_02() {
        test = extend.createTest("Start of Test 02");
        test = extend.createTest("Test 02 : Validate user can’t log in to the application with a wrong user name or password");
        SoftAssert softAssert = new SoftAssert();
        loginPage loginpage = new loginPage(driver);
        commonPage commonpage = new commonPage(driver);
        appHomePage apphomepage = new appHomePage(driver);

        softAssert.assertTrue(loginpage.verifyLoginPage(), "Login Page is not visible");
        test.log(Status.INFO,"User able to view Login Page");
        loginpage.enterUserName("EnterWrongUserName@mailinator.com");
        loginpage.enterPassword("EnterWrongPassword");
        commonpage.hideKeyboard();
        loginpage.clickOnRememberMeCheckBox();
        loginpage.clickOnLoginButton();
        softAssert.assertTrue(apphomepage.isLandingPageVerificationFailed(), "User is login");
        softAssert.assertAll();

        test = extend.createTest("End of Test 02");
    }

    @Test
    public void Test_03() {
        test = extend.createTest("Start of Test 03");
        test = extend.createTest("Test 03 : Validate “Mess” page contains the correct day at the top of the screen");
        SoftAssert softAssert = new SoftAssert();
        loginPage loginpage = new loginPage(driver);
        commonPage commonpage = new commonPage(driver);
        appHomePage apphomepage = new appHomePage(driver);
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
        softAssert.assertTrue(messlandingpage.verifyMessLandingPage(), "User Landing to the wrong page");
        test.log(Status.INFO,"User successfully navigate to Mess page");
        String CurrentDayOfWeek = generateCurrentDayOfWeek();
        softAssert.assertTrue(messlandingpage.verifyMessDayOfWeek(CurrentDayOfWeek), "Mess day is not matched");
        test.log(Status.INFO,"Verified the Mess day");
        softAssert.assertAll();

        test = extend.createTest("End of Test 03");
    }

    @Test
    public void Test_04() {
        test = extend.createTest("Start of Test 04");
        test = extend.createTest("Test 04 : Validate user can add a feedback successfully when navigating to the “Mess” section, from the landing page");
        SoftAssert softAssert = new SoftAssert();
        loginPage loginpage = new loginPage(driver);
        commonPage commonpage = new commonPage(driver);
        appHomePage apphomepage = new appHomePage(driver);
        messLandingPage messlandingpage = new messLandingPage(driver);
        messFeedBack messfeedback = new messFeedBack(driver);

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
        softAssert.assertTrue(messlandingpage.verifyMessLandingPage(), "User Landing to the wrong page");
        test.log(Status.INFO,"User successfully navigate to Mess page");
        messlandingpage.clickOnFeedBackButton();
        softAssert.assertTrue(messfeedback.VerifyPlusIconEnable(), "Plus icon not enable");
        test.log(Status.INFO,"User switch to FeedBack section");
        messfeedback.clickOnbtnPlusIcon();
        softAssert.assertTrue(messfeedback.VerifyFeedbackPopupHeader(), "FeedbackPopup Header is not Display");
        test.log(Status.INFO,"User can see Feedback Popup");

        int Meals = messfeedback.MealsType("Lunch");
        messfeedback.SelectOnFeedbackMealsList(String.valueOf(Meals));
        int Day = messfeedback.DayType("Tuesday");
        messfeedback.SelectOnFeedbackDayList(String.valueOf(Day));
        messfeedback.clickOnFeedbackRatings();
        String CurrentDateTimeFormat = generateCurrentDateTime();
        String FeedBackTitle = "Feedback_"+CurrentDateTimeFormat+"Title";
        messfeedback.EnterFeedbackTitle(FeedBackTitle);
        messfeedback.EnterFeedbackDesc("FeedbackDesc");
        commonpage.hideKeyboard();
        messfeedback.clickOnSubmit();
        //softAssert.assertTrue(messfeedback.isTitleAvailableAtCreatedFeedBackInList(FeedBackTitle),"Fail find Created FeedBack");
        softAssert.assertAll();

        test = extend.createTest("End of Test 04");
    }

    @Test
    public void Test_05() throws InterruptedException {
        test = extend.createTest("Start of Test 05");
        test = extend.createTest("Test 05 : Validate user can successfully update “Profile info” by navigating to profile section at the Hamburger menu.");
        SoftAssert softAssert = new SoftAssert();
        loginPage loginpage = new loginPage(driver);
        commonPage commonpage = new commonPage(driver);
        appHomePage apphomepage = new appHomePage(driver);
        appSideMenuPage appsidemenupage = new appSideMenuPage(driver);
        profilePage profilepage = new profilePage(driver);
        profileinfoPage profileinfopage = new profileinfoPage(driver);

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
        test.log(Status.INFO,"User successfully navigate to Side Menu Page");
        appsidemenupage.clickOnProfileBtn();
        profilepage.verifyProfilePage();
        test.log(Status.INFO,"User successfully navigate to Profile Page");
        profilepage.clickOnProfileEditBtn();
        profilepage.verifyProfileUpdatePopup();
        profilepage.SelectUpdateType("PROFILE INFO");
        profileinfopage.verifyProfileInfoPage();
        profileinfopage.enterProfileName("mariyaEdit");
        profileinfopage.enterProfileBranch("2023");
        profileinfopage.enterProfileMob("0123654789");
        commonpage.hideKeyboard();
        profileinfopage.clickOnProfileDOB();
        profileinfopage.clickOnProfileDOBDate();
        profileinfopage.clickOnOkBtn();
        profileinfopage.clickOnProfileGender();
        profileinfopage.SelectGender("Female");
        profileinfopage.clickOnProfileHostel();
        int HostelType = profileinfopage.SelectHostelType("Hostel 1");
        profileinfopage.SelectHostel(HostelType);
        profileinfopage.clickOnProEditSave();
        softAssert.assertTrue(profilepage.verifyProfileName("mariyaEdit"), "Profile Info is not update");
        test.log(Status.INFO,"User successfully update to Profile Info");
        softAssert.assertAll();

        test = extend.createTest("End of Test 05");
    }

    @Test
    public void Test_06() throws InterruptedException {
        test = extend.createTest("Start of Test 06");
        test = extend.createTest("Test 06 : Validate user can navigate to correct page by selecting the options at Hamburger menu");
        SoftAssert softAssert = new SoftAssert();
        loginPage loginpage = new loginPage(driver);
        commonPage commonpage = new commonPage(driver);
        appHomePage apphomepage = new appHomePage(driver);
        appSideMenuPage appsidemenu = new appSideMenuPage(driver);

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
        softAssert.assertTrue(appsidemenu.validateSideMenuItemsVisibility(), "Side Menu Items are not visible");
        test.log(Status.INFO,"Successfully validate the Side Menu Items");
        softAssert.assertAll();

        test = extend.createTest("End of Test 05");
    }

    @Test
    public void Test_07() throws InterruptedException {
        test = extend.createTest("Start of Test 07");
        test = extend.createTest("Test 07 : Validate user can successfully log out from the application");
        SoftAssert softAssert = new SoftAssert();
        loginPage loginpage = new loginPage(driver);
        commonPage commonpage = new commonPage(driver);
        appHomePage apphomepage = new appHomePage(driver);
        appSideMenuPage appsidemenu = new appSideMenuPage(driver);

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
        appsidemenu.scroll(Integer.parseInt("430"),Integer.parseInt("1410"),Integer.parseInt("448"),Integer.parseInt("302"));
        appsidemenu.clickOnLogoutBtn();
        softAssert.assertTrue(loginpage.verifyLoginPage(), "Login Page is not visible");
        test.log(Status.INFO,"User successfully logout in to the application");
        softAssert.assertAll();

        test = extend.createTest("End of Test 07");
    }

    @AfterMethod
    public void closeDriver()
    {
        driver.quit();
    }
}
