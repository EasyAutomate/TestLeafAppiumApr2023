package learning;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class LearnZoom {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("appium:app", System.getProperty("user.dir") + "/apks/MultiTouch Tester_v1.2.apk");
        dc.setCapability("appium:deviceName", "my emulator");
        dc.setCapability("noReset", true);
        // dc.setCapability("platformName", "Android");
        // AppiumDriver driver = new AppiumDriver(new
        // URL("http://0.0.0.0:4723/wd/hub"),dc);
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        Thread.sleep(3000);
        int maxX = driver.manage().window().getSize().getWidth();
        int maxY = driver.manage().window().getSize().getHeight();

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "index finger");
        Sequence sequence1 = new Sequence(finger1, 1);
        sequence1.addAction(
                finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxX * 0.5), (int) (maxY * 0.5)));
        sequence1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence1.addAction(finger1.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), (int) (maxX * 0.75),
                (int) (maxY * 0.25)));
        sequence1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "thumb finger");
        Sequence sequence2 = new Sequence(finger2, 1);
        sequence2.addAction(
                finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxX * 0.5), (int) (maxY * 0.5)));
        sequence2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence2.addAction(finger2.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), (int) (maxX * 0.25),
                (int) (maxY * 0.75)));
        sequence2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(sequence1, sequence2));


        //driver.quit();

    }
}