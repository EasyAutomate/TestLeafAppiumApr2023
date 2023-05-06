package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnWebApps extends GenericWrappers {

    @Test
    public void runCode() {
        launchChromeBrowser("my device", "https://www.google.com");
        enterValue(getWebElement(Locators.NAME.asString(), "q"), "Lokesh Kumar");
        pressEnter();
    }
}