package pages;
import org.testng.Assert; 
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addCartPagecClass 
{

	WebDriver driver;
	
	public addCartPagecClass(WebDriver driver) 
	{
		this.driver = driver;	
		
}
	public boolean cartIconvisibility() throws InterruptedException 
	{
		Thread.sleep(3000);
		WebElement click_cart_icon= driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		return click_cart_icon.isDisplayed();
		
		
	}
	@SuppressWarnings("deprecation")
	public void clickCartIcon() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement click_cart_icon= driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		click_cart_icon.click();
		
		
	}
		
	public void continueShoppingButton()
	{
		WebElement clickContinueShoppingButton= driver.findElement(By.xpath("//button[@id='continue-shopping']"));
		clickContinueShoppingButton.click();
		
	}
	public void addInventory() throws InterruptedException
	{
		WebElement clickAddToCartButton3= driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
		clickAddToCartButton3.click();
		Thread.sleep(2000);
		
		WebElement clickAddToCartButton4 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
		clickAddToCartButton4.click();
		Thread.sleep(3000);
		
	}
	public void sortingItemsOnProductsListingPage() throws InterruptedException 
	{
		WebElement clickOnSortingButton = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select sortingFilterdropdown = new Select (clickOnSortingButton);
		sortingFilterdropdown.selectByIndex(1);
		
		List<WebElement> nameElements = driver.findElements(By.tagName("img"));
		 List<String> actualNames = new ArrayList<>();
		    for (WebElement name : nameElements) {
		        actualNames.add(name.getText());
		        System.out.println("Image Alt Text: " +name.getAttribute("alt"));
		    }
		    
		    List<String> expectedNames = new ArrayList<>(actualNames);
		    Collections.sort(expectedNames, Collections.reverseOrder());
		    if (actualNames.equals(expectedNames)) {
		        System.out.println("✅ Test Passed: Names are sorted from Z to A correctly.");
		    } else 
		    {
		        System.out.println(" Test Failed: Names are not sorted from Z to A.");
		        System.out.println("Actual Order: " + actualNames);
		        System.out.println("Expected Order: " + expectedNames);
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    }
		}
		
			public void verifySidePanelIsOpened() throws InterruptedException {
				WebElement hamburgerMenu = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
				hamburgerMenu.click();
				
				WebElement sideMenu = driver.findElement(By.xpath("//div[@class='bm-menu']"));
				if (sideMenu.isDisplayed())
				System.out.println("Side Menu opened successfully");
				
				else {
					System.out.println("TestCase Failed");}
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
			}
			
			
			public void clickOnResetAppState() throws InterruptedException {
				WebElement resetApp = driver.findElement(By.xpath("//a[@id='reset_sidebar_link']"));
				resetApp.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}
			
			
			public void clickOnLogout() throws InterruptedException {
				WebElement logout = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", logout);
			
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
			    
			    Assert.assertTrue(loginButton.isDisplayed(), "❌ Logout failed — login button not displayed.");

	
				
				/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='logout_sidebar_link']")));
				logoutButton.click();*/	
				
			}
			
			
	
			public void clickOnAboutFromSideMenu() {
				WebElement about = driver.findElement(By.xpath("//a[@id='about_sidebar_link']"));
				about.click();
				
				if (about.isDisplayed())
				System.out.println("About section is displayed");
				
				else {
					System.out.println("About section is not opened");
				}
					
			}
			

	}