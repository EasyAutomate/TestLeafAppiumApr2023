package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import java.net.MalformedURLException;

public class LearnHybridAppIniOS extends GenericWrappers {

    @Test
    public void runMyCode() throws MalformedURLException {
        launchIosApp("iPhone 14 Pro", "B88361EF-6968-4345-AB1B-19C8A814BB67", "", "", "/apks/UiCatalog.zip");
        swipeUpInApp();
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Web View"));
        sleep(10000);
        printContext();
        //switchContext("WEBVIEW_11015.1");
        switchWebView();
        click(getWebElement(Locators.ID.asString(), "globalnav-menutrigger-button"));
        click(getWebElement(Locators.XPATH.asString(), "//a[@data-globalnav-item-name=\"airpods\"]"));
        click(getWebElement(Locators.LINK_TEXT.asString(), "AirPods Max"));

    }
}
