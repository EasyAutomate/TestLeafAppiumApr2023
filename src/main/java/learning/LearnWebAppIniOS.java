package learning;

import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import java.net.MalformedURLException;

public class LearnWebAppIniOS extends GenericWrappers {

    @Test
    public void runMyCode() throws MalformedURLException {
        launchSafariBrowser("iPhone 14 Pro","https://www.google.com","00008030-000A708E01F0C02E");
        enterValue(getWebElement(Locators.NAME.asString(), "q"), "Lokesh Kumar Thyagarajan");
        sleep(5000);
        //click(getWebElement(Locators.NAME.asString(), "q"));

        WebElement ele = getWebElement(Locators.NAME.asString(), "q");
        Rectangle rect = ele.getRect();
        int middleX = (int) (((rect.getWidth() + rect.getX() - rect.getX()) * 0.5) + rect.getX());
        int middleY = (int) (((rect.getHeight() + rect.getY() - rect.getY()) * 0.5) + rect.getY());
        tap(middleX,middleY+120);

//        switchNativeview();
//        System.out.println(driver.getPageSource());
//        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Go"));
//        switchWebView();

           clickGivenKeyboardButtonInIosByAccessibilityId("Go");
    }
}
