package learning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LearnToFindRightActivity {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "my emulator");
        dc.setCapability("appPackage", "com.amazon.mShop.android.shopping");
        dc.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
        AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);


    }

}
