package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.Given;
import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {

	public HomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
		if (!eleIsDisplayed(userNameTxt)) {
			throw new RuntimeException("Home page is not displayed");
		}
	}

	@AndroidFindBy(xpath = "//android.view.View[@text='Rajkumar Ganesan']")
	private WebElement userNameTxt;

	@Given("Home page is verified")
	public HomePage verifyHomePage() {
		eleIsDisplayed(userNameTxt);
		return this;
	}

}