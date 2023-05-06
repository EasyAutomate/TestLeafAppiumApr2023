package pages;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import wrappers.GenericWrappers;

import java.time.Duration;

public class LoginPage extends GenericWrappers {
    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    // @iOSXCUITFindBy(id = "")
    private WebElement emailTxtBox;
    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    // @iOSXCUITFindBy(id = "")
    private WebElement pwdTxtBox;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='LOGIN']")
    // @iOSXCUITFindBy(id = "")
    private WebElement loginBtn;

    //	String platform;
    public LoginPage(AppiumDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
//		platform = driver.getCapabilities().getCapability("platformName").toString();
//		System.out.println(platform);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(60)), this);
        eleIsDisplayed(emailTxtBox);
    }

    public LoginPage enterEmailAddress(String email) {
        if (enterValue(emailTxtBox, email)) {
            reportStep("Username entered successfully", "pass");
        } else {
            reportStep("Username entry failed", "fail");
        }
        return this;
    }

    public LoginPage enterPassword(String pwd) {
        if (enterValue(pwdTxtBox, pwd)) {
            reportStep("Password entered successfully", "pass");
        } else {
            reportStep("Password entry failed", "fail");
        }
        return this;
    }

    public HomePage clickLogin() {
        if (click(loginBtn)) {
            reportStep("Login button clicked successfully", "pass");
        } else {
            reportStep("Login button click failed", "fail");
        }
        return new HomePage(driver, test);
    }
}