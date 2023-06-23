import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class dataDriven {

    private AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "AOSP on IA Emulator");
        desiredCapabilities.setCapability("appium:platformVersion", "9");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:appPackage", "io.appium.android.apis");
        desiredCapabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //@Test
    public void verifyAPIDemosItems() {

        SoftAssert softAssert = new SoftAssert();

        MobileElement btnAccessibility = (MobileElement) driver.findElementByAccessibilityId("Accessibility");
        softAssert.assertEquals(btnAccessibility.getText(), "Accessibility", "Accessibility is not visible");

        MobileElement btnAnimation = (MobileElement) driver.findElementByAccessibilityId("Animation");
        softAssert.assertEquals(btnAnimation.getText(), "Animation", "Animation is not visible");

        MobileElement btnContent = (MobileElement) driver.findElementByAccessibilityId("Content");
        softAssert.assertEquals(btnContent.getText(), "Content1", "Content is not visible");

        MobileElement btnApp = (MobileElement) driver.findElementByAccessibilityId("App");
        softAssert.assertEquals(btnApp.getText(), "App", "App is not visible");

        MobileElement btnGraphics = (MobileElement) driver.findElementByAccessibilityId("Graphics");
        softAssert.assertEquals(btnGraphics.getText(), "Graphics", "Graphics is not visible");

        softAssert.assertAll();

    }

    @DataProvider(name = "apiDemosTestData")
    public Object[][] provideTestData() {
        return new Object[][]{
                {"Accessibility"},
                {"Animation"},
                {"Content"},
                {"App"},
                {"Graphics"},

        };
    }
    @Test(dataProvider = "apiDemosTestData")
        public void verifyAPIDemosItems(String accessibilityText) {
            SoftAssert softAssert = new SoftAssert();

            MobileElement btnAccessibility = (MobileElement) driver.findElementByAccessibilityId(accessibilityText);
            String ActualResult = btnAccessibility.getText();
            softAssert.assertEquals(ActualResult, accessibilityText, accessibilityText + " is not visible");
            softAssert.assertAll();
    }
    @AfterMethod
    public void closeAPIDemos() {
        driver.quit();
    }

    @Test(dataProvider = "accessibilityDataCSV")
    public void sampleTest2(String accessibilityId) {
        SoftAssert softAssert = new SoftAssert();
        MobileElement lblAccessibility = (MobileElement) driver.findElementByAccessibilityId(accessibilityId);
        String actualText = lblAccessibility.getText();
        softAssert.assertEquals(actualText, accessibilityId);
        softAssert.assertAll();
    }


    //Data from CSV
//    private static final String CSV_FILE_PATH = "src/main/java/testData/lblNames.csv";
//    @DataProvider(name = "accessibilityDataCSV")
//    public Object[][] accessibilityDataCSV() throws IOException {
//        CSVReader reader = new CSVReaderBuilder(new FileReader(CSV_FILE_PATH)).build();
//
//        // Calculate the number of rows in the CSV file
//        int numRows = 0;
//        while (reader.readNext() != null) {
//            numRows++;
//        }
//
//        // Reset the reader to the beginning of the file
//        reader.close();
//        reader = new CSVReaderBuilder(new FileReader(CSV_FILE_PATH)).build();
//
//        Object[][] data = new Object[numRows][1];
//        String[] record;
//
//        int row = 0;
//        while ((record = reader.readNext()) != null) {
//            data[row][0] = record[0];
//            row++;
//        }
//
//        reader.close();
//        return data;
//    }
}
