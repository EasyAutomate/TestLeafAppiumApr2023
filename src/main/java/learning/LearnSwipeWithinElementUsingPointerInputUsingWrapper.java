package learning;

import org.openqa.selenium.WebElement;
import wrappers.CommonNativeWrappers;
import wrappers.GenericWrappers;

import java.net.MalformedURLException;

public class LearnSwipeWithinElementUsingPointerInputUsingWrapper {

    public static void main(String[] args) throws MalformedURLException {
        GenericWrappers gw = new GenericWrappers();
        gw.launchAndroidApp("my emulator", "com.android.vending", "com.android.vending.AssetBrowserActivity", "", "");
        WebElement ele = gw.getWebElement(CommonNativeWrappers.Locators.XPATH.asString(), "(//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View)[1]");
        gw.swipeUpInAppWithWebElement(ele);
        gw.closeApp();
    }
}
