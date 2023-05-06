package learning;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class LearnSwipeWithinElementUsingPointerInput {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "my emulator");
        dc.setCapability("appPackage", "com.android.vending");
        dc.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
        dc.setCapability("noReset", true);
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        int startX, startY, endX, endY;
        int EendX, EstartX, EendY, EstartY;
        WebElement ele = driver.findElement(By.xpath("(//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View)[1]"));
        Rectangle rect = ele.getRect();
//        EstartX = ele.getLocation().getX();
//        EstartY = ele.getLocation().getY();
//        EendX = ele.getSize().getWidth() + EstartX;
//        EendY = ele.getSize().getHeight() +EstartY;
        EstartX = rect.getX();
        EstartY = rect.getY();
        EendX = rect.getWidth() + EstartX;
        EendY = rect.getHeight() + EstartY;
        startX = (int) (((EendX - EstartX) * 0.5) + EstartX);
        startY = (int) (((EendY - EstartY) * 0.8) + EstartY);
        endX = (int) (((EendX - EstartX) * 0.5) + EstartX);
        endY = (int) (((EendY - EstartY) * 0.2) + EstartY);
        System.out.println("performing swipe up...");
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger 1");
        Sequence seq = new Sequence(input, 1);
        seq.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        seq.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(input.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), endX, endY));
        seq.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(seq));

    }
}
