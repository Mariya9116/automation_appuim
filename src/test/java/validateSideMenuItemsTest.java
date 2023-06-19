import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.common.*;

import java.net.MalformedURLException;

public class validateSideMenuItemsTest extends  TestBase{

    @BeforeMethod
    public void beforeEachTest() throws MalformedURLException, InterruptedException {
        driverSetupInstiGo();
    }
    @Test
    public void validateSideMenuItemsTest1() {
        SoftAssert softAssert = new SoftAssert();
        appHomePage apphomepage = new appHomePage(driver);
        loginPage loginpage = new loginPage(driver);
        commonPage commonpage = new commonPage(driver);
        appSideMenuPage appsidemenu = new appSideMenuPage(driver);

        softAssert.assertTrue(loginpage.verifyLoginPage(), "Login Page is not visible");

        loginpage.enterUserName("mariya1234@mailinator.com");
        loginpage.enterPassword("mariya1234");
        commonpage.hideKeyboard();
        loginpage.clickOnRememberMeCheckBox();
        loginpage.clickOnLoginButton();

        softAssert.assertTrue(apphomepage.verifyLandingPage("InstiGo"), "Landing page header text is wrong");

        apphomepage.clickOnHamburgerButton();
        softAssert.assertTrue(apphomepage.verifyEmailAddressContents("mariya1234@mailinator.com"), "Login Email Address is wrong");
        softAssert.assertTrue(appsidemenu.validateSideMenuItemsVisibility(), "Side Menu Items are not visible");
        softAssert.assertTrue(appsidemenu.validateSideMenuHomeItem());
        softAssert.assertTrue(appsidemenu.validateSideMenuComplaintsItem());
        softAssert.assertTrue(appsidemenu.validateSideMenuCouncilItem());
        softAssert.assertTrue(appsidemenu.validateSideMenuResourceItem());
        softAssert.assertTrue(appsidemenu.validateSideMenuCouncilItem());
        softAssert.assertTrue(appsidemenu.validateSideMessHomeItem());

        softAssert.assertAll();
    }

    @AfterMethod
    public void closeDriver()
    {
        driver.quit();
    }
}
