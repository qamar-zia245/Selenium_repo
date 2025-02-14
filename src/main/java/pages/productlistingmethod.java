package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class productlistingmethod
{
	
	WebDriver driver;
	
	public productlistingmethod(WebDriver driver) {
		this.driver = driver;
	}

	public void addToCart() throws InterruptedException
{
		
		WebElement shopping_Cart_span= driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		
		String initialcounttext = shopping_Cart_span.getText();
		boolean initialcount= initialcounttext.isEmpty();
		System.out.print("Updated count->"+initialcount);
		
		
		WebElement add_to_cart1= driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		add_to_cart1.click();
		
		Thread.sleep(3000);
		WebElement add_to_cart2= driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
		add_to_cart2.click();
		
		
		String updatedcounttext= shopping_Cart_span.getText();
		int updatedcount= Integer.parseInt(updatedcounttext);
		
		System.out.print("\n"+"Updated count"+updatedcounttext+"\n");
		
	}
		public void productSorting()
		{
			WebElement DSC_Sort = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
			Select filterDrop = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
			filterDrop.selectByVisibleText("Name (Z to A)");
		//	filterDrop.getAllSelectedOptions();
			System.out.print("\n"+"Selected Fitler Name->"+filterDrop.getAllSelectedOptions()+"\n");
		}
		
	}

