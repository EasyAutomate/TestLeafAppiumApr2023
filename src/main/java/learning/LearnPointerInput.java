package learning;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class LearnPointerInput {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "my emulator");
        dc.setCapability("app", System.getProperty("user.dir") + "/apks/MultiTouch Tester_v1.2.apk");
        dc.setCapability("noReset", true);
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        int maxY = driver.manage().window().getSize().getHeight();
        int maxX = driver.manage().window().getSize().getWidth();
        System.out.println("performing swipe up...");
        int startX, startY, endX, endY;
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger 1");
        Sequence seq = new Sequence(input, 1);
        seq.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxX * 0.5), (int) (maxY * 0.8)));
        seq.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(input.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), (int) (maxX * 0.5), (int) (maxY * 0.2)));
        seq.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(seq));

        System.out.println("performing swipe down...");
        PointerInput input1 = new PointerInput(PointerInput.Kind.TOUCH, "finger 1");
        Sequence seq1 = new Sequence(input1, 1);
        seq1.addAction(input1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxX * 0.5), (int) (maxY * 0.2)));
        seq1.addAction(input1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq1.addAction(input1.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), (int) (maxX * 0.5), (int) (maxY * 0.8)));
        seq1.addAction(input1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(seq1));

        System.out.println("performing swipe left...");
        PointerInput input2 = new PointerInput(PointerInput.Kind.TOUCH, "finger 1");
        Sequence seq2 = new Sequence(input2, 1);
        seq2.addAction(input2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxX * 0.8), (int) (maxY * 0.5)));
        seq2.addAction(input2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq2.addAction(input2.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), (int) (maxX * 0.2), (int) (maxY * 0.5)));
        seq2.addAction(input2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(seq2));

        System.out.println("performing swipe right...");
        PointerInput input3 = new PointerInput(PointerInput.Kind.TOUCH, "finger 2");
        Sequence seq3 = new Sequence(input3, 1);
        seq3.addAction(input3.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxX * 0.2), (int) (maxY * 0.5)));
        seq3.addAction(input3.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq3.addAction(input3.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), (int) (maxX * 0.8), (int) (maxY * 0.5)));
        seq3.addAction(input3.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(seq3));
    }
}
