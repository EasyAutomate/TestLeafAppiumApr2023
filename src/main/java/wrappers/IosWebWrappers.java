package wrappers;

import io.appium.java_client.remote.SupportsContextSwitching;

public class IosWebWrappers extends IosNativeWrappers {

    public boolean launchSafariBrowser(String deviceName, String URL, String udid) {
        return launchBrowser("iOS", "Safari", deviceName, URL, udid, "", "", "", "");
    }

    public boolean launchSafariBrowserInParallel(String deviceName, String URL, String udid, String wdaLocalPort,
                                                 String webkitDebugProxyPort) {
        return launchBrowser("iOS", "Safari", deviceName, URL, udid, "", wdaLocalPort, "", webkitDebugProxyPort);
    }

    public boolean deleteSafariCookies() {
        stopRunningApp("com.apple.Preferences");
        switchToAnotherApp("com.apple.Preferences");
        switchNativeview();
        swipeDownInApp();
        enterValue(getWebElement(Locators.XPATH.toString(), "//*[@label='Search']"), "Safari");
        try {
            click(getWebElement(Locators.XPATH.toString(), "//XCUIElementTypeCell[2]//*[@name='Safari']"));
        } catch (Exception e) {
            click(getWebElement(Locators.XPATH.toString(), "//*[@label='Safari']"));
        }
        sleep(1000);
        swipeUpInAppUntilElementIsVisible(Locators.XPATH.toString(),
                "//*[@value='Clear History and Website Data' and @visible='true']");
        click(getWebElement(Locators.XPATH.toString(),
                "//*[@value='Clear History and Website Data' and @visible='true']"));
        click(getWebElement(Locators.XPATH.toString(), "//*[@label='Clear' or @label='Clear History and Data']"));
        stopRunningApp("com.apple.Preferences");
        switchToAnotherApp("com.apple.mobilesafari");
        switchWebView();
        return true;
    }

    public void clickGivenKeyboardButtonInIosByName(String name) {
        boolean isNative = ((SupportsContextSwitching) driver).getContext().equalsIgnoreCase("NATIVE_APP");
        String context = ((SupportsContextSwitching) driver).getContext();
        if (!isNative) {
            switchNativeview();
        }
        if (isKeyboardShown()) {
            click(getWebElement(Locators.NAME.toString(), name));
        }
        if (!isNative) {
            switchContext(context);
        }
    }

    public void clickGivenKeyboardButtonInIosByAccessibilityId(String accessId) {
        boolean isNative = ((SupportsContextSwitching) driver).getContext().equalsIgnoreCase("NATIVE_APP");
        String context = ((SupportsContextSwitching) driver).getContext();
        if (!isNative) {
            switchNativeview();
        }
        if (isKeyboardShown()) {
            click(getWebElement(Locators.ACCESSIBILITY_ID.toString(), accessId));
        }
        if (!isNative) {
            switchContext(context);
        }
    }

    public void clickGivenKeyboardButtonInIosByXpath(String xPath) {
        boolean isNative = ((SupportsContextSwitching) driver).getContext().equalsIgnoreCase("NATIVE_APP");
        String context = ((SupportsContextSwitching) driver).getContext();
        if (!isNative) {
            switchNativeview();
        }
        if (isKeyboardShown()) {
            click(getWebElement(Locators.XPATH.toString(), xPath));
        }
        if (!isNative) {
            switchContext(context);
        }
    }
}
