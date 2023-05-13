package learning;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class FirstCodeIniOSInRealDevice {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "iPhone 11");
        dc.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
        dc.setCapability("platformName", "iOS");
        dc.setCapability("automationName", "XCUITest");
        dc.setCapability("udid", "00008030-000A708E01F0C02E");
        AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(AppiumBy.accessibilityId("Action Sheets")).click();
        driver.findElement(AppiumBy.accessibilityId("Okay / Cancel")).click();
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
