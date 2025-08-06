package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class checkoutPage
{

	WebDriver driver;
	
	public checkoutPage(WebDriver driver)
	{
		this.driver = driver; 
	}
	public void clickCheckoutButton() throws InterruptedException
	{
		Thread.sleep(3000);
		
		WebElement clickCheckoutBtn = driver.findElement(By.xpath("//button[@id='checkout']"));
		clickCheckoutBtn.click();
		Thread.sleep(3000);
	}
	
	public void informationCheckoutDetail() throws InterruptedException
	{
		Thread.sleep(3000);
		
		WebElement firstname = driver.findElement(By.xpath("//input[@id='first-name']"));
		firstname.sendKeys("david");
		Thread.sleep(2000);
		
		WebElement Lastname = driver.findElement(By.xpath("//input[@id='last-name']"));
		Lastname.sendKeys("miller");
		Thread.sleep(2000);
		
		WebElement Zipcode = driver.findElement(By.xpath("//input[@id='postal-code']"));
		Zipcode.sendKeys("47750");
		
		WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));
		continueButton.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Or scroll to the bottom of the page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		WebElement finishButton = driver.findElement(By.xpath("//button[@id='finish']"));
		finishButton.click();
		
	}
	
	public String emptyCheckoutInformation() throws InterruptedException
	{
		WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));
		continueButton.click();
		
		WebElement  erroralert = driver.findElement(By.xpath("//div[@class='error-message-container error']"));
		String alertText=erroralert.getText();
		

		Boolean errorMsg=erroralert.isDisplayed();
		 if (erroralert.isDisplayed()) {
		        System.out.println("Validation error is displayed:\n" + errorMsg);
		    }
		
		return alertText;
		
		
	}
	public void continueShopingButton() throws InterruptedException {
		WebElement continueShopingButton = driver.findElement(By.xpath("//button[@id='continue-shopping']"));
		continueShopingButton.click();
		WebElement addCart3 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
		addCart3.click();
		Thread.sleep(2000);
		WebElement addCart4 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
		addCart4.click();
	}
	
	public void verifyAddCartCount() {
		WebElement shoppingCartBadge = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
		Assert.assertTrue(shoppingCartBadge.isDisplayed(), "cart Badge is not displayed");
		Assert.assertEquals(shoppingCartBadge.getText(),"4", "Cart Badge count is showing the correct count");
	}
	
	public String OrderCompleted() 
	{
		WebElement backToProduct = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
		return backToProduct.getText();
		
	}
	
	
	public void clickonHomeButton() {
		WebElement homeButton = driver.findElement(By.xpath("//button[@id='back-to-products']"));
		homeButton.click();
		
		WebElement productlisitng = driver.findElement(By.xpath("//div[@id='root']"));
		Assert.assertEquals(productlisitng, "'Sauce Labs Backpack'not found");
	}
	
	}

