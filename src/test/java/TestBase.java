import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import common.constants;
import io.appium.java_client.android.AndroidDriver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import pages.common.splashPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected AndroidDriver driver;
    protected ExtentReports extend;
    protected WebDriverWait wait;
    protected ExtentTest test;

//    public void driverSetupInstiGo() throws MalformedURLException, InterruptedException {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("appium:deviceName", "AOSP on IA Emulator");
//        desiredCapabilities.setCapability("appium:platformVersion", "9");
//        desiredCapabilities.setCapability("platformName", "Android");
//        desiredCapabilities.setCapability("appium:appPackage", "com.iitdh.sonusourav.instigo");
//        desiredCapabilities.setCapability("appium:appActivity", "com.iitdh.sonusourav.instigo.Account.SplashActivity");
//        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
//        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
//        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
//        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
//
//        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
//
//        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver,10);
//
//        splashPage splashpage = new splashPage(driver);
//        splashpage.clickOnSkipButton();
//    }
    @AfterMethod
    public void extendReporting(ITestResult result)
    {
        if(result.getStatus()== ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus()==ITestResult.SUCCESS) {
            test.pass(result.getThrowable());
        }

        extend.flush();
    }

    @BeforeTest
    public void createReport(){
        //Create date format
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String DateTime = now.format(formatter);

        extend = new ExtentReports();
        extend.attachReporter(new ExtentSparkReporter("./TestResultReport"+DateTime+".html"));
    }

    public static String generateCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        return now.format(formatter);
    }

    public static String generateCurrentDayOfWeek() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.getDayOfWeek().name().toUpperCase();
    }

//    public void driverSetup2() throws IOException, ParseException, InterruptedException, org.json.simple.parser.ParseException {
//        JSONParser parser = new JSONParser();
//        JSONObject config = (JSONObject) parser.parse(new FileReader("src/main/java/resources/browser_confic.json"));
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        JSONArray envs = (JSONArray) config.get("environments");
//        Map<String, String> envCapabilities = (Map<String, String>) envs.get(0);
//        Iterator it = envCapabilities.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
//        }
//
//        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
//        it = commonCapabilities.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            if(capabilities.getCapability(pair.getKey().toString()) == null){
//                capabilities.setCapability(pair.getKey().toString(), pair.getValue());
//            }
//        }
//
//        String username = (String) config.get("username");
//
//        String accessKey = (String) config.get("access_key");
//
//        driver = new AndroidDriver (new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//        //driver = new AndroidDriver(remoteUrl, desiredCapabilities);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver,10);
//
//        splashPage splashpage = new splashPage(driver);
//        splashpage.clickOnSkipButton();
//    }

    public void driverSetupInstiGo() throws IOException, InterruptedException, ParseException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "AOSP on IA Emulator");
        desiredCapabilities.setCapability("appium:platformVersion", "9");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:appPackage", "com.iitdh.sonusourav.instigo");
        desiredCapabilities.setCapability("appium:appActivity", "com.iitdh.sonusourav.instigo.Account.SplashActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        if(constants.LOCAL_EXECUTION == true){
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);}
        else{
            JSONParser parser = new JSONParser();
            JSONObject config = (JSONObject) parser.parse(new FileReader("src/main/java/resources/browser_confic.json"));

            DesiredCapabilities capabilities = new DesiredCapabilities();

            JSONArray envs = (JSONArray) config.get("environments");
            Map<String, String> envCapabilities = (Map<String, String>) envs.get(0);
            Iterator it = envCapabilities.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
            }

            Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
            it = commonCapabilities.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if(capabilities.getCapability(pair.getKey().toString()) == null){
                    capabilities.setCapability(pair.getKey().toString(), pair.getValue());
                }
            }

            String username = (String) config.get("username");

            String accessKey = (String) config.get("access_key");

            driver = new AndroidDriver (new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);

        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        wait = new WebDriverWait(driver,10);

        splashPage splashpage = new splashPage(driver);
        splashpage.clickOnSkipButton();
    }

}


