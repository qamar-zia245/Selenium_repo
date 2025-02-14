package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class loginClass {
	
	WebDriver driver;
	
	public loginClass (WebDriver driver)
	{
		this.driver=driver;
		
	}	
	public void doLogin() {
		
	
	WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
	username.sendKeys("standard_user");
	
	WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
	Password.sendKeys("secret_sauce");
	
	WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
	login.click();
	
	}
	public String verifyTitleAfterLogin() {
		String title = driver.getTitle();
		return title; 
	}
}

