package learning;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class FirstCodeIniOSUsingBundleId {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "iPhone 14 Pro");
        dc.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
        dc.setCapability("platformName", "iOS");
        dc.setCapability("automationName", "XCUITest");
        //    dc.setCapability("udid","B88361EF-6968-4345-AB1B-19C8A814BB67");
        AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(AppiumBy.accessibilityId("Action Sheets")).click();
        driver.findElement(AppiumBy.accessibilityId("Okay / Cancel")).click();
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
