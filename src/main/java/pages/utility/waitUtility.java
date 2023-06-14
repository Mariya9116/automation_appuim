package pages.utility;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class waitUtility {

    private static AndroidDriver driver;
    private static WebDriverWait wait;


    //*********Constructor*********
    public waitUtility(AndroidDriver driver) {
        this.driver = driver;
    }


    //*********ImplicitlyWait Methods*********
    public static void waitImplicitlyWebDriverWait(AndroidDriver driver, int timeoutInSeconds) {
        driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
    }

    //*********ExplicitWait - waitForElementToBeClickable Methods*********
    public static WebElement waitForElementToBeClickable(AndroidDriver driver, WebElement element, int waitTimeInSeconds) {
        wait = new WebDriverWait(driver, waitTimeInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //*********ExplicitWait - waitForTextToBePresentInElement Methods*********
    public static WebElement waitForElementVisibility(AndroidDriver driver, WebElement element, int waitTimeInSeconds) {
        wait = new WebDriverWait(driver, waitTimeInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //*********ThreadSleep Methods*********
    public static void simpleThreadSleepWait(int seconds) throws InterruptedException{
        Thread.sleep(seconds*1000);
    }



}
