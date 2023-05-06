package wrappers;

import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class IosNativeWrappers extends AndroidWebWrappers {

    public boolean launchIosApp(String deviceName, String udid, String xcodeOrgId, String bundleId, String app) {
        return launchApp("iOS", deviceName, udid, "", "", "XCUITest", "", "", xcodeOrgId, "iPhone Developer", bundleId,
                app, "", "");
    }

    public boolean launchIosAppInParallel(String deviceName, String udid, String xcodeOrgId, String bundleId,
                                          String app, String wdaLocalPort) {
        return launchApp("iOS", deviceName, udid, "", "", "XCUITest", "", "", xcodeOrgId, "iPhone Developer", bundleId,
                app, "", wdaLocalPort);
    }

    public boolean chooseNextOptionInPickerWheel(String locator, String locatorValue) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("order", "next");
        params.put("offset", 0.15);
        params.put("element", getWebElement(locator, locatorValue));
        driver.executeScript("mobile: selectPickerWheelValue", params);
        return true;
    }

    public boolean chooseNextOptionInPickerWheel(WebElement ele) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("order", "next");
        params.put("offset", 0.15);
        params.put("element", ele);
        driver.executeScript("mobile: selectPickerWheelValue", params);
        return true;
    }

    public boolean choosePreviousOptionInPickerWheel(String locator, String locatorValue) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("order", "previous");
        params.put("offset", 0.15);
        params.put("element", getWebElement(locator, locatorValue));
        driver.executeScript("mobile: selectPickerWheelValue", params);
        return true;
    }

    public boolean choosePreviousOptionInPickerWheel(WebElement ele) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("order", "previous");
        params.put("offset", 0.15);
        params.put("element", ele);
        driver.executeScript("mobile: selectPickerWheelValue", params);
        return true;
    }

}
