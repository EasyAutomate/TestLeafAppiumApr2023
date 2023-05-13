package learning;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidFirstScriptUsingSauceLabs {
    public static void main(String[] args) throws MalformedURLException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=leaforg.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:deviceOrientation", "portrait");
        caps.setCapability("appium:platformVersion", "13.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        caps.setCapability("appiumVersion", "1.22.3");
        caps.setCapability("sauce:options", sauceOptions);
        URL url = new URL("https://oauth-epcmafather-5bc49:3108bbd1-4ffc-4834-8536-5e25e5c6872c@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        AndroidDriver
                driver = new AndroidDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.className("android.widget.EditText")).sendKeys("rajkumar@testleaf.com");
        driver.findElement(By.xpath("(//android.widget.EditText)[2]")).sendKeys("Leaf@123");
        driver.findElement(By.className("android.widget.Button")).click();

    }

}
