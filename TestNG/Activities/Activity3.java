package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {

	WebDriver driver;
	
	@Test
  public void Login() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		
		driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button")).click();
		
		String ActualMessage = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("Actual Message - " + ActualMessage);
		
		Assert.assertEquals("Welcome Back, admin", ActualMessage);
  }
	
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "C:/Users/IBMADMIN/Documents/Automation/Drivers/chromedriver.exe");  
	  driver = new ChromeDriver();	 
	  driver.get("https://www.training-support.net/selenium/login-form");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
