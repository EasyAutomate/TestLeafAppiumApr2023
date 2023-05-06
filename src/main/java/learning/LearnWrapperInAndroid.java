package learning;

import wrappers.CommonNativeWrappers;
import wrappers.GenericWrappers;

public class LearnWrapperInAndroid {

    public static void main(String[] args) {
        GenericWrappers gm = new GenericWrappers();
        gm.launchAndroidApp("sfds", "", "", "", "/apks/leaforg.apk");
        gm.enterValue(gm.getWebElement(CommonNativeWrappers.Locators.CLASS_NAME.asString(), "android.widget.EditText"),
                "rajkumar@testleaf.com");
        gm.enterValue(gm.getWebElement(CommonNativeWrappers.Locators.XPATH.asString(), "(//android.widget.EditText)[2]"),
                "Leaf@123");
        gm.click(gm.getWebElement(CommonNativeWrappers.Locators.CLASS_NAME.asString(), "android.widget.Button"));
        gm.sleep(5000);
        gm.closeApp();
    }
}