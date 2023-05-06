package wrappers;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.connection.HasNetworkConnection;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;

public class AndroidNativeWrappers extends CommonWebWrappers {

    public boolean launchAndroidApp(String deviceName, String appPackage, String appActivity, String automationName,
                                    String app) {
        return launchApp("Android", deviceName, "", appPackage, appActivity, automationName, "", "", "", "", "", app,
                "", "");
    }

    public boolean launchAndroidAppInParallel(String deviceName, String udid, String appPackage, String appActivity,
                                              String automationName, String chromeDriverPort, String mjpegServerPort, String systemPort, String app) {
        return launchApp("Android", deviceName, udid, appPackage, appActivity, automationName, chromeDriverPort,
                systemPort, "", "", "", app, mjpegServerPort, "");
    }

    public boolean startAnAppUsingActivity(String appPackage, String appActivity) {
        try {
            ((StartsActivity) getDriver()).startActivity(new Activity(appPackage, appActivity));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean pressEnter() {
        ((PressesKey) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
        return true;
    }

    public boolean pressBack() {
        ((PressesKey) getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
        return true;
    }

    public void showNotificationMenu() {
        ((AndroidDriver) getDriver()).openNotifications();
    }

    public void hideNotificationMenu() {
        pressBack();
    }

    public boolean dataOffInAndroid() {
        ((HasNetworkConnection) getDriver()).setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
        ((HasNetworkConnection) getDriver()).setConnection(new ConnectionStateBuilder().withDataDisabled().build());
        return true;
    }

    public boolean dataOnInAndroid() {
        ((HasNetworkConnection) getDriver()).setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
        ((HasNetworkConnection) getDriver()).setConnection(new ConnectionStateBuilder().withDataEnabled().build());
        return true;
    }

    public String getCurrentActivity() {
        return ((StartsActivity) getDriver()).currentActivity();
    }

    public String getCurrentAppPackage() {
        return ((StartsActivity) getDriver()).getCurrentPackage();
    }

}
