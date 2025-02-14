package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base_class {
	
	public static WebDriver driver;
	
	public static WebDriver browserInitialize() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		
		return driver;
	}

}
