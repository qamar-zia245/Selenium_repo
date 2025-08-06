package testCases;

import org.testng.annotations.Test;

import basePackage.base_class;
import pages.loginClass;
import pages.productlistingmethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class loginTestClass extends base_class {

	loginClass login;

	@BeforeMethod
	public void beforeMethod() {
		driver = super.browserInitialize();

	}
	@Test
	public void verifyLogin() throws InterruptedException {
		loginClass login = new loginClass(driver);
		login.doLogin();	
		Thread.sleep(3000);
		
		String expectedurl = "https://www.saucedemo.com/inventory.htmls";
		String actualurl=driver.getCurrentUrl();
				Assert.assertEquals(actualurl, expectedurl, "Url mis-matched");
	}
	
	
	
	
	
/*
	@Test
	 @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
            {"standard_user", "secret123"},
            {"locked_out_user", "secret_sauce"},
            {"problem_user", "secret_sauce"},
            {"performance_glitch_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {

        loginClass login = new loginClass(driver);
        login.doLogin(username, password);

        boolean isLoggedIn = driver.getCurrentUrl().contains("inventory.html");
        Assert.assertTrue(isLoggedIn, "Login failed for: " + username);

    }*/

	@AfterMethod
	public void afterMethod() {
	}

}
