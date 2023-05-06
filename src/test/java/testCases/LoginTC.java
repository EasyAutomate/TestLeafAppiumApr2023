package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectSpecificWrappers;

public class LoginTC extends ProjectSpecificWrappers {

	@BeforeTest
	public void bt() {
		testCaseName = "Login TC";
		testNodes = "TC001";
		testDescription = "Login funtionality";
		category = "Smoke";
		authors = "Lokesh Kumar";
		dataSheetName = "TC001";
	}

	@Test(dataProvider = "fetchData")
	public void runMyTC(String userName, String password) {
		new LoginPage(driver, test).enterEmailAddress(userName).enterPassword(password).clickLogin();
	}
}