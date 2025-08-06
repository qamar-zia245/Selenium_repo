package testCases;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.base_class;
import pages.addCartPagecClass;
import pages.loginClass;
import pages.productlistingmethod;

public class addCartTestClass extends base_class
{

	WebDriver driver;

	@BeforeClass
	public void beforeClass() throws InterruptedException 
	{
		driver = super.browserInitialize();
		loginClass login = new loginClass(driver);
		login.doLogin();
		productlistingmethod ProdList=new productlistingmethod(driver);
		ProdList.addToCart();
		addCartPagecClass addCart=new addCartPagecClass(driver);
		addCart.cartIconvisibility();
		addCart.clickCartIcon();
		
	}

	@Test 
	public void verifyCartIconIsVisibleOrNot() throws InterruptedException 
	{
		addCartPagecClass addCart= new addCartPagecClass(driver);
		addCart.cartIconvisibility();
	}
	@Test
	public void verifyCartIconIsClickable() throws InterruptedException 
	{
		addCartPagecClass addCart= new addCartPagecClass(driver);
		addCart.clickCartIcon();
	}
	@Test
	public void verifyContinueShoppingButtonIsClickable()
	{
		addCartPagecClass addcart = new addCartPagecClass(driver);
		addcart.continueShoppingButton();	
	}
	@Test
	public void verifyInventory() throws InterruptedException
	{
		addCartPagecClass addToCart = new addCartPagecClass(driver);
		addToCart.addInventory();
	}
		
	@Test
	public void clickCartIconAgainAfterAddingAnotherItems() throws InterruptedException 
	{
		// verifyCartIconIsClickable();
		addCartPagecClass addCart= new addCartPagecClass(driver);
		addCart.clickCartIcon();
	
	}
	@Test
	public void verifySortingFilter() throws InterruptedException { 
	 addCartPagecClass Sorting = new addCartPagecClass(driver);
	 Sorting.sortingItemsOnProductsListingPage();
	 
	}
	@Test
	public void verifySideMenuIsOpened() throws InterruptedException {
		addCartPagecClass sidePanel = new addCartPagecClass(driver);
				sidePanel.verifySidePanelIsOpened();
		
	}
	
	@Test
	public void verifyLogoutFromSidePanel() throws InterruptedException {
		addCartPagecClass logoutbtn = new addCartPagecClass(driver);
		logoutbtn.clickOnLogout();
	}
	
	@Test(enabled = false)
	public void verifyResetAppState() throws InterruptedException {
		addCartPagecClass resetbtn1 = new addCartPagecClass(driver);
				resetbtn1.clickOnResetAppState();
	}
	
	@Test (enabled = false)
	public void verifyAboutIsOpened() {
		addCartPagecClass about1 = new addCartPagecClass(driver);
		about1.clickOnAboutFromSideMenu();
	}

	@AfterClass
	public void tearDown() 
	{
		//driver.close();
	}

}
