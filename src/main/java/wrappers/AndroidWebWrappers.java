package wrappers;

public class AndroidWebWrappers extends AndroidNativeWrappers {

    public boolean launchChromeBrowser(String deviceName, String URL) {
        return launchBrowser("Android", "Chrome", deviceName, URL, "", "", "", "", "");
    }

    public boolean launchChromeBrowserInParallel(String deviceName, String URL, String udid, String chromeDriverPort,
                                                 String mjpegServerPort) {
        return launchBrowser("Android", "Chrome", deviceName, URL, udid, chromeDriverPort, "", mjpegServerPort, "");
    }

    public boolean deleteChromeCookies() {
        driver.manage().deleteAllCookies();
        return true;
    }

}
