package learning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstCodeIniOS {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "iPhone 14 Pro");
        dc.setCapability("app", System.getProperty("user.dir") + "/apks/UiCatalog.zip");
        dc.setCapability("platformName", "iOS");
        dc.setCapability("automationName", "XCUITest");
        dc.setCapability("udid", "B88361EF-6968-4345-AB1B-19C8A814BB67");
        AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
    }
}
