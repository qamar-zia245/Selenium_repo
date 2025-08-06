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
		WebElement username =driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("visual_user");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("secret_sauce");
		
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginButton.click();
		
		
	}
	/*public void doLogin(String Username, String password) {
		
		driver.findElement(By.id("user-name")).sendKeys(Username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
	}*/
	public String verifyTitleAfterLogin() {
		String title = driver.getTitle();
		return title; 
	}
}

