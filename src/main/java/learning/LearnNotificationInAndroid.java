package learning;

import wrappers.GenericWrappers;

public class LearnNotificationInAndroid {

    public static void main(String[] args) {
        GenericWrappers gm = new GenericWrappers();
        gm.launchAndroidApp("my device", "", "", "", "/apks/leaforg.apk");
        gm.showNotificationMenu();
        gm.sleep(3000);
        gm.hideNotificationMenu();
        gm.sleep(3000);
        gm.closeApp();
    }
}