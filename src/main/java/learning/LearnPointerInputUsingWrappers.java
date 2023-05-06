package learning;

import wrappers.GenericWrappers;

import java.net.MalformedURLException;

public class LearnPointerInputUsingWrappers {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        GenericWrappers gm = new GenericWrappers();
        gm.launchAndroidApp("sfds", "", "", "", "/apks/MultiTouch Tester_v1.2.apk");
        gm.swipeUpInApp();
        gm.sleep(2000);
        gm.swipeDownInApp();
        gm.sleep(2000);
        gm.swipeLeftInApp();
        gm.sleep(2000);
        gm.swipeRightInApp();
        gm.sleep(2000);
        gm.closeApp();
    }
}
