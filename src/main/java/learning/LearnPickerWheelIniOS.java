package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import java.net.MalformedURLException;

public class LearnPickerWheelIniOS extends GenericWrappers {

    @Test
    public void runMyCode() throws MalformedURLException {
        launchIosApp("iPhone 14 Pro", "B88361EF-6968-4345-AB1B-19C8A814BB67", "", "", "/apks/UiCatalog.zip");
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Picker View"));
        enterValue(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"),"10");
        enterValue(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Green color component value"),"50");
        enterValue(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Blue color component value"),"100");

        while (!getText(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value")).equals("40")) {
            chooseNextOptionInPickerWheel(Locators.ACCESSIBILITY_ID.asString(), "Red color component value");
        }

        while (!getText(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Green color component value")).equals("40")) {
            choosePreviousOptionInPickerWheel(Locators.ACCESSIBILITY_ID.asString(), "Green color component value");
        }

        chooseNextOptionInPickerWheel(Locators.ACCESSIBILITY_ID.asString(), "Blue color component value");
    }
}
