import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class openApp {

    private static AndroidDriver driver;
    @Test
    public void setUpInstiGo() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for x86");
        desiredCapabilities.setCapability("appium:platformVersion", "11.0");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:appPackage", "com.iitdh.sonusourav.instigo");
        desiredCapabilities.setCapability("appium:appActivity", "com.iitdh.sonusourav.instigo.Account.SplashActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        Thread.sleep(10000);
        MobileElement SkipButton = (MobileElement) driver.findElementById("com.iitdh.sonusourav.instigo:id/btn_skip");
        SkipButton.click();
    }
//    @Test
//    public void setUpTestClock() throws MalformedURLException {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for x86");
//        desiredCapabilities.setCapability("appium:platformVersion", "11.0");
//        desiredCapabilities.setCapability("platformName", "Android");
//        desiredCapabilities.setCapability("appium:appPackage", "com.android.deskclock");
//        desiredCapabilities.setCapability("appium:appActivity", "com.android.deskclock.DeskClock");
//        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
//        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
//        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
//        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
//        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
//
//        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
//
//    }

    @AfterMethod(alwaysRun = true)
    public void anotationTest5()
    {
        System.out.println("Test Complete");
    }

    public void tearDown() {
        driver.quit();
    }

//    public void implicitWaitExample() {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://www.example.com");
//        WebElement element = driver.findElement(By.id("elementId"));
//        element.click();
//    }

    public void ImplicitWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//    public void explicitWaitExample() {
//        driver.get("https://www.example.com");
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
//        element.click();
//    }

    public WebElement ExplicitWait(WebElement ele, Duration Time) {
        WebDriverWait wait = new WebDriverWait(driver, Time.toSeconds());
        WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
        return element;
    }

//    public void fluentWaitExample() {
//        driver.get("https://www.example.com");
//        Wait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofSeconds(2))
//                .ignoring(NoSuchElementException.class);
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
//        element.click();
//    }

    public static WebElement FluentWait(WebElement ele, Duration Timeout, Duration Time) {
        FluentWait<AndroidDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(Timeout.toSeconds()))
                .pollingEvery(Duration.ofSeconds(Time.toSeconds()))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
        return element;
    }

}
