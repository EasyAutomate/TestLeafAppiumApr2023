package learning;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidFirstScriptUsingApp {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "my emulator");
        dc.setCapability("app", System.getProperty("user.dir") + "/apks/vodqa.apk");
        dc.setCapability("noReset", true);
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
    }

}
