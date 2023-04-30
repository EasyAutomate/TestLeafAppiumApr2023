package learning;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LearnMultiTouchAction {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "my emulator");
        dc.setCapability("app", System.getProperty("user.dir") + "/apks/MultiTouch Tester_v1.2.apk");
        dc.setCapability("noReset", true);
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        int maxY = driver.manage().window().getSize().getHeight();
        int maxX = driver.manage().window().getSize().getWidth();
        new MultiTouchAction(driver)
                .add(new TouchAction<>(driver)
                        .press(PointOption.point((int) (maxX * 0.5), (int) (maxY * 0.8)))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
                        .moveTo(PointOption.point((int) (maxX * 0.5), (int) (maxY * 0.2)))
                        .release())
                .add(new TouchAction<>(driver)
                        .press(PointOption.point((int) (maxX * 0.5), (int) (maxY * 0.2)))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
                        .moveTo(PointOption.point((int) (maxX * 0.5), (int) (maxY * 0.8)))
                        .release())
                .perform();


    }
}
