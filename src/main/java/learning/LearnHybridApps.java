package learning;

import wrappers.CommonNativeWrappers;
import wrappers.GenericWrappers;

public class LearnHybridApps {

    public static void main(String[] args) {
        GenericWrappers gm = new GenericWrappers();
        gm.launchAndroidApp("sfds", "", "", "", "/apks/leaforg.apk");
        gm.printContext();
        gm.switchContext("WEBVIEW_com.testleaf.leaforg");
        gm.enterValue(gm.getWebElement(CommonNativeWrappers.Locators.TAG_NAME.asString(), "input"), "rajkumar@testleaf.com");
        gm.enterValue(gm.getWebElement(CommonNativeWrappers.Locators.XPATH.asString(), "//input[@formcontrolname=\"password\"]"), "Leaf@123");
        gm.click(gm.getWebElement(CommonNativeWrappers.Locators.XPATH.asString(), "//button[@type='submit']"));
        gm.sleep(5000);
        gm.closeApp();
    }
}
