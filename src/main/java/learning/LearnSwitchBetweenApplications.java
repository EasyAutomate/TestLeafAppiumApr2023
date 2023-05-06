package learning;

import wrappers.CommonNativeWrappers;
import wrappers.GenericWrappers;

public class LearnSwitchBetweenApplications {

    public static void main(String[] args) {
        GenericWrappers gm = new GenericWrappers();
        gm.launchAndroidApp("my device", "", "", "", "/apks/leaforg.apk");
        gm.verifyAndInstallApp("com.the511plus.MultiTouchTester", System.getProperty("user.dir") + "/apks/MultiTouch Tester_v1.2.apk");
        gm.enterValue(gm.getWebElement(CommonNativeWrappers.Locators.CLASS_NAME.asString(), "android.widget.EditText"), "rajkumar@testleaf.com");
        gm.enterValue(gm.getWebElement(CommonNativeWrappers.Locators.XPATH.asString(), "(//android.widget.EditText)[2]"), "Leaf@123");
        gm.click(gm.getWebElement(CommonNativeWrappers.Locators.CLASS_NAME.asString(), "android.widget.Button"));
        gm.switchToAnotherApp("com.the511plus.MultiTouchTester");
        gm.swipeUpInApp();
        gm.stopRunningApp("com.testleaf.leaforg");
        gm.switchToAnotherApp("com.testleaf.leaforg");
        // gm.startAnAppUsingActivity("com.testleaf.leaforg","com.testleaf.leaforg.MainActivity");
        System.out.println(gm.getCurrentAppPackage());
        System.out.println(gm.getCurrentActivity());
    }
}
