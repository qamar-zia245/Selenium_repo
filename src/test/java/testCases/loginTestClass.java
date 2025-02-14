package testCases;

import org.testng.annotations.Test;

import basePackage.base_class;
import pages.loginClass;
import pages.productlistingmethod;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class loginTestClass extends base_class {

	loginClass login;

	@BeforeMethod
	public void beforeMethod() {
		driver = super.browserInitialize();

	}

	@Test
	public void loginWithValidCredentials() throws InterruptedException {
		loginClass login = new loginClass(driver);
		login.doLogin();

		String ExpectedUrl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(driver.getCurrentUrl(), ExpectedUrl, "Url Verification Passed");
		Thread.sleep(3000);
	}
	
	
	@Test
	/*public void verifyTitleAfterLogin() {
		loginClass login = new loginClass(driver);
		String ExpectedTitle = login.verifyTitleAfterLogin();
		System.out.println("After Login Page Title is: "+ExpectedTitle);

		Assert.assertEquals(driver.getTitle(), ExpectedTitle, "Title Verification Passed!");*/
		
	
	

	@AfterMethod
	public void afterMethod() {
		 driver.close();
	}

}
