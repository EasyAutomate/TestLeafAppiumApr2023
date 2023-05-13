package learning;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class FirstCodeIniOSInSauceLabs {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:app", "storage:filename=UICatalog.zip");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "iPhone Simulator");
        caps.setCapability("appium:deviceOrientation", "portrait");
        caps.setCapability("appium:platformVersion", "15.5");
        caps.setCapability("appium:automationName", "XCUITest");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        caps.setCapability("appiumVersion", "1.22.3");

        caps.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://oauth-epcmafather-5bc49:3108bbd1-4ffc-4834-8536-5e25e5c6872c@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        IOSDriver driver = new IOSDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(AppiumBy.accessibilityId("Action Sheets")).click();
        driver.findElement(AppiumBy.accessibilityId("Okay / Cancel")).click();
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
