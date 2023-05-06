package wrappers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class CommonWebWrappers extends CommonNativeWrappers {

    // To launch the mobile web browser
    public boolean launchBrowser(String platformName, String browserName, String deviceName, String URL, String udid,
                                 String chromeDriverPort, String wdaLocalPort, String mjpegServerPort, String webkitDebugProxyPort) {
        try {
            DesiredCapabilities dc = new DesiredCapabilities();
            // To pass the Unique Device Identifier
            if (!udid.equals(""))
                dc.setCapability("udid", udid);
            // Android
            // For web app parallel testing
            if (!chromeDriverPort.equals(""))
                dc.setCapability("chromedriverPort", chromeDriverPort);
            // For web app parallel testing
            if (!mjpegServerPort.equals(""))
                dc.setCapability("mjpegServerPort", mjpegServerPort);
            // iOS
            // For web app parallel testing
            if (!wdaLocalPort.equals(""))
                dc.setCapability("wdaLocalPort", wdaLocalPort);
            // Mandatory desired capabilities
            dc.setCapability("browserName", browserName);
            dc.setCapability("deviceName", deviceName);
            // dc.setCapability("platformName", platformName);
            // Comment the below line based on need
            dc.setCapability("noReset", true);
            if (platformName.equalsIgnoreCase("Android")) {
                // Comment the below line based on need
                dc.setCapability("autoGrantPermissions", true);
                driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
            } else if (platformName.equalsIgnoreCase("iOS")) {
                if (!webkitDebugProxyPort.equals(""))
                    dc.setCapability("webkitDebugProxyPort", webkitDebugProxyPort);
                // Comment the below line based on need
                dc.setCapability("autoAcceptAlerts", true);
                dc.setCapability("startIWDP", true);
                dc.setCapability("nativeWebTap", true);
                dc.setCapability("automationName", "XCUITest");
                driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
            }
            driver.get(URL);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return true;
    }

    // To switch the context as WEBVIEW (Note: Not recommended)
    public boolean switchWebView() {
        try {
            Set<String> contextNames = ((SupportsContextSwitching) driver).getContextHandles();
            for (String contextName : contextNames) {
                if (contextName.contains("WEBVIEW"))
                    ((SupportsContextSwitching) driver).context(contextName);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    // To scroll down in browser
    public boolean scrollDownInBrowser(int pixelsToBeScrolled) {
        try {
            JavascriptExecutor jse = driver;
            jse.executeScript("window.scrollBy(0," + pixelsToBeScrolled + "\")", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    // To navigate back in browser
    public boolean navigateBackInBrowser() {
        try {
            driver.navigate().back();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    // To load the given URL
    public boolean loadURL(String url) {
        driver.get(url);
        return true;
    }

    // To switch to last window
    public boolean switchToLastWindow() {
        sleep(5000);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String string : windowHandles) {
            driver.switchTo().window(string);
        }
        return true;
    }

    // To switch to first window
    public boolean switchToFirstWindow() {
        sleep(5000);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String string : windowHandles) {
            driver.switchTo().window(string);
            break;
        }
        return true;
    }
}
