import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class isoWeb {

    private WebDriver driver;

    @Test
    public void testOneMobileBrowser() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "iPhone SE (3rd generation)");
        desiredCapabilities.setCapability("appium:platformVersion", "16.4");
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("udid", "EAAE08FA-4718-4FD9-856F-DFC96BC1404F");
        desiredCapabilities.setCapability("appium:automationName", "XCUITest");
        desiredCapabilities.setCapability("webkit:WebRTC", false);
        desiredCapabilities.setCapability("relaxed-security",true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        //desiredCapabilities.setCapability("noReset", "true");
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new IOSDriver<>(remoteUrl, desiredCapabilities);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.google.com");
        driver.get("https://www.yahoo.com");
    }
    @Test
    public void testOneMobileBrowser_ANDROID() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appium:platformVersion", "10");
        desiredCapabilities.setCapability("platformName", "Android");

        desiredCapabilities.setCapability("appium:automationName", "Appium");
        desiredCapabilities.setCapability("browserName", "Chrome");

        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.google.com");
        driver.get("https://www.yahoo.com");
    }
}
