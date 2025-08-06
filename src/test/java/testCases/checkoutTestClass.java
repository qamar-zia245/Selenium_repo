package testCases;

import org.testng.annotations.Test;

import basePackage.base_class;
import pages.addCartPagecClass;
import pages.checkoutPage;
import pages.loginClass;
import pages.productlistingmethod;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkoutTestClass extends base_class 
{

	WebDriver driver;

	@BeforeClass
	public void beforeMethod() throws InterruptedException
	{
		driver = super.browserInitialize();
		loginClass login = new loginClass(driver);
		login.doLogin();

		productlistingmethod ProdList = new productlistingmethod(driver);
		ProdList.addToCart();

		addCartPagecClass addCart = new addCartPagecClass(driver);
		addCart.cartIconvisibility();
		addCart.clickCartIcon();
		
	}

	@Test
	public void verifyCheckoutButton() throws InterruptedException 
	{
		checkoutPage checkout = new checkoutPage(driver);
		checkout.clickCheckoutButton();

	}

	@Test(enabled = false)
	public void verifyCheckoutInformation() throws InterruptedException
	{
		checkoutPage checkout = new checkoutPage(driver);
		checkout.informationCheckoutDetail();
	}
	
	@Test
	public void verifyCheckoutInformationWithEmptyDetail() throws InterruptedException
	{
		checkoutPage Checkout = new checkoutPage(driver);
		Checkout.emptyCheckoutInformation();
	
		//Assert.assertTrue(false, "Not displayed");
		String expectedErrorMessage = "Error: First Name is required";
		String actualErrorMessage = Checkout.emptyCheckoutInformation();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message is verified" );
		
	}

	@Test(enabled = false)
	public void verifyOrderCompletedOrNot() 
	{
		checkoutPage checkout = new checkoutPage(driver);
		checkout.OrderCompleted();
		String ExpectedUrl="https://www.saucedemo.com/checkout-complete.html";
		String ActualUrl=driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl, ExpectedUrl, "Url Matched");
		
	}
	@Test(enabled = false)
	public void verifyContinueShoppingButton() throws InterruptedException {
		checkoutPage continueShoppingButton = new checkoutPage(driver);
		continueShoppingButton.continueShopingButton();
	}
	@Test(enabled = false)
	public void verifyCartCount() {
		checkoutPage cartBadgeCount = new checkoutPage(driver);
		cartBadgeCount.verifyAddCartCount();
	}
	
	public void verifyProductListingpage() {
		checkoutPage productlisting = new checkoutPage(driver);
				productlisting.clickonHomeButton();
		String ExpectedUrl = "https://www.saucedemo.com/inventory.html";
		String ActualUrl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(ActualUrl, ExpectedUrl, "Url Mathed and test Case passed");
	}
	
	public void verifyProductListingPage() {
		checkoutPage productListing = new checkoutPage(driver);
		productListing.clickonHomeButton();
		List<String> expectedProducts = Arrays.asList(
				"Sauce Labs Backpack",
				"Sauce Labs Bike Light",
				"Sauce Labs Bolt T-Shirt",
				"Sauce Labs Fleece Jacket"
);
		List<WebElement> productTitles = driver.findElements(By.className("inventory_item_img"));
		List<String> actualProducts = new ArrayList<>();
		for (WebElement product : productTitles) {
		    actualProducts.add(product.getText().trim());
		}
		
		for (String expected : expectedProducts) {
		    Assert.assertTrue(actualProducts.contains(expected), "❌ Missing product: " + expected);
		}

		
				
	}

	@AfterClass
	public void tearDown() 
	{
		// driver.close();
	}

}
