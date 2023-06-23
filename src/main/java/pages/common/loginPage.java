package pages.common;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pages.utility.waitUtility;

public class loginPage {

    private AndroidDriver driver2;

    //*********Constructor*********
    public loginPage(AndroidDriver driver) {
        this.driver2 = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    //*********MobileElements by using Page Factory*********
    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/ed_user_name")
    public MobileElement txtUserName;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/ed_password")
    public MobileElement txtPassword;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/remember_me_chk_box")
    public MobileElement chkboxRememberMe;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/button_login")
    public MobileElement btnLogin;

    @AndroidFindBy(id = "com.iitdh.sonusourav.instigo:id/login_logo")
    public MobileElement imgLoginLogo;

    @AndroidFindBy(className = "android.widget.Toast")
    public MobileElement popupToastErrorMessage;

    //*********Page Methods*********

    //Verify Login Page
    public boolean verifyLoginPage() {
        return imgLoginLogo.isDisplayed();
    }

    //Verify Toast Error Message
    public boolean verifyToastErrorMessage() {
        waitUtility.waitForElementVisibility(driver2, popupToastErrorMessage,5);
        return popupToastErrorMessage.isDisplayed();
    }
    //Verify Username Field
    public boolean verifyUserNameField() {
        return txtUserName.isDisplayed();
    }

    //Enter Username or Email
    public void enterUserName(String UserEmailAddress) {
        txtUserName.click();
        txtUserName.clear();
        txtUserName.sendKeys(UserEmailAddress);
    }

    //Enter Password
    public void enterPassword(String UserPassword) {
        txtPassword.click();
        txtPassword.clear();
        txtPassword.sendKeys(UserPassword);
    }

    //Verify Password Field
    public boolean verifyPasswordField() {
        return txtPassword.isDisplayed();
    }

    //Tab in remember me check box
    public void clickOnRememberMeCheckBox() {
        chkboxRememberMe.click();
    }

    //Tab on login button
    public void clickOnLoginButton() {
        btnLogin.click();
        waitUtility.waitImplicitlyWebDriverWait(driver2, 5);
    }
    //Verify login button
    public boolean verifyLoginButton() {
        return btnLogin.isEnabled();
    }


}
