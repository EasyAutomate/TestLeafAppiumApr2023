package wrappers;

import org.testng.annotations.*;
import utils.DataInputProvider;

public class ProjectSpecificWrappers extends GenericWrappers {

    public String dataSheetName;

    @BeforeSuite
    public void bs() {
        initializeReport();
    }

    @BeforeClass
    public void bc() {
        initializeTestCase(testCaseName, testDescription);
    }

    @Parameters({"platformName", "deviceName", "udid", "appPackage", "appActivity", "automationName",
            "chromeDriverPort", "systemPort", "xcodeOrgId", "xcodeSigningId", "bundleId", "app", "mjpegServerPort",
            "wdaLocalPort"})
    @BeforeMethod
    public void bm(String platformName, String deviceName, @Optional("") String udid, @Optional("") String appPackage,
                   @Optional("") String appActivity, @Optional("") String automationName,
                   @Optional("") String chromeDriverPort, @Optional("") String systemPort, @Optional("") String xcodeOrgId,
                   @Optional("") String xcodeSigningId, @Optional("") String bundleId, @Optional("") String app,
                   @Optional("") String mjpegServerPort, @Optional("") String wdaLocalPort) {
        initializeTestNodeForEachTC(testNodes);
        launchApp(platformName, deviceName, udid, appPackage, appActivity, automationName, chromeDriverPort, systemPort,
                xcodeOrgId, xcodeSigningId, bundleId, app, mjpegServerPort, wdaLocalPort);
    }

    @AfterMethod(alwaysRun = true)
    public void am() {
        closeApp();
    }

    @AfterSuite(alwaysRun = true)
    public void as() {
        saveReport();
    }

    @DataProvider(name = "fetchData")
    public Object[][] getData() {
        return DataInputProvider.getSheet(dataSheetName);
    }

}