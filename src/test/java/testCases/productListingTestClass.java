package testCases;

import org.testng.annotations.Test;

import basePackage.base_class;
import pages.loginClass;
import pages.productlistingmethod;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class productListingTestClass extends base_class {
	WebDriver driver;
	
	@BeforeMethod
	  public void beforeMethod() {
		driver = super.browserInitialize();
		loginClass login = new loginClass(driver);
		login.doLogin();
	  }
	
	 	@Test
		public void verifyAddToCart() throws InterruptedException {
		productlistingmethod products = new productlistingmethod(driver);
		products.addToCart();
		}
	 	
	 	public void productSorting() throws InterruptedException {
	 		productlistingmethod DESC_Sort = new productlistingmethod(driver);
	 		DESC_Sort.addToCart();
	 	
	 	}

  @AfterMethod
  public void afterMethod() {
	 // driver.close();
  }

}
